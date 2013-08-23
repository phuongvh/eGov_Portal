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
 

package com.vportal.portlet.edirectory.service.persistence;

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

import com.vportal.portlet.edirectory.NoSuchEDDepartmentException;
import com.vportal.portlet.edirectory.model.EDDepartment;
import com.vportal.portlet.edirectory.model.impl.EDDepartmentImpl;
import com.vportal.portlet.edirectory.model.impl.EDDepartmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e d department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDDepartmentPersistence
 * @see EDDepartmentUtil
 * @generated
 */
public class EDDepartmentPersistenceImpl extends BasePersistenceImpl<EDDepartment>
	implements EDDepartmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EDDepartmentUtil} to access the e d department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EDDepartmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVEL = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevel",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevel",
			new String[] { Long.class.getName() },
			EDDepartmentModelImpl.LEVELED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVEL = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevel",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EDDepartmentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			EDDepartmentModelImpl.PARENT_COLUMN_BITMASK |
			EDDepartmentModelImpl.LANGUAGEID_COLUMN_BITMASK |
			EDDepartmentModelImpl.GROUPID_COLUMN_BITMASK |
			EDDepartmentModelImpl.DOMAINID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParent",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT =
		new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent",
			new String[] { Long.class.getName() },
			EDDepartmentModelImpl.PARENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENT = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParent",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGEANDGROUP =
		new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLanguageAndGroup",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEANDGROUP =
		new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLanguageAndGroup",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			EDDepartmentModelImpl.LANGUAGEID_COLUMN_BITMASK |
			EDDepartmentModelImpl.GROUPID_COLUMN_BITMASK |
			EDDepartmentModelImpl.DOMAINID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGEANDGROUP = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLanguageAndGroup",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDDOMAIN =
		new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevelAndDomain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDDOMAIN =
		new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevelAndDomain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			EDDepartmentModelImpl.LEVELED_COLUMN_BITMASK |
			EDDepartmentModelImpl.LANGUAGEID_COLUMN_BITMASK |
			EDDepartmentModelImpl.GROUPID_COLUMN_BITMASK |
			EDDepartmentModelImpl.DOMAINID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVELANDDOMAIN = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevelAndDomain",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), String.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_D_G = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByD_G",
			new String[] { Long.class.getName(), Long.class.getName() },
			EDDepartmentModelImpl.ID_COLUMN_BITMASK |
			EDDepartmentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_G = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_G",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_L_G = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByL_G",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByL_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EDDepartmentModelImpl.LANGUAGEID_COLUMN_BITMASK |
			EDDepartmentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_L_G = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByL_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_L_G_P = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByL_G_P",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G_P = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByL_G_P",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			EDDepartmentModelImpl.LANGUAGEID_COLUMN_BITMASK |
			EDDepartmentModelImpl.GROUPID_COLUMN_BITMASK |
			EDDepartmentModelImpl.PARENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_L_G_P = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByL_G_P",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, EDDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the e d department in the entity cache if it is enabled.
	 *
	 * @param edDepartment the e d department
	 */
	public void cacheResult(EDDepartment edDepartment) {
		EntityCacheUtil.putResult(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentImpl.class, edDepartment.getPrimaryKey(), edDepartment);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_G,
			new Object[] {
				Long.valueOf(edDepartment.getId()),
				Long.valueOf(edDepartment.getGroupId())
			}, edDepartment);

		edDepartment.resetOriginalValues();
	}

	/**
	 * Caches the e d departments in the entity cache if it is enabled.
	 *
	 * @param edDepartments the e d departments
	 */
	public void cacheResult(List<EDDepartment> edDepartments) {
		for (EDDepartment edDepartment : edDepartments) {
			if (EntityCacheUtil.getResult(
						EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						EDDepartmentImpl.class, edDepartment.getPrimaryKey()) == null) {
				cacheResult(edDepartment);
			}
			else {
				edDepartment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e d departments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EDDepartmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EDDepartmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e d department.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EDDepartment edDepartment) {
		EntityCacheUtil.removeResult(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentImpl.class, edDepartment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(edDepartment);
	}

	@Override
	public void clearCache(List<EDDepartment> edDepartments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EDDepartment edDepartment : edDepartments) {
			EntityCacheUtil.removeResult(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				EDDepartmentImpl.class, edDepartment.getPrimaryKey());

			clearUniqueFindersCache(edDepartment);
		}
	}

	protected void clearUniqueFindersCache(EDDepartment edDepartment) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_G,
			new Object[] {
				Long.valueOf(edDepartment.getId()),
				Long.valueOf(edDepartment.getGroupId())
			});
	}

	/**
	 * Creates a new e d department with the primary key. Does not add the e d department to the database.
	 *
	 * @param id the primary key for the new e d department
	 * @return the new e d department
	 */
	public EDDepartment create(long id) {
		EDDepartment edDepartment = new EDDepartmentImpl();

		edDepartment.setNew(true);
		edDepartment.setPrimaryKey(id);

		return edDepartment;
	}

	/**
	 * Removes the e d department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e d department
	 * @return the e d department that was removed
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment remove(long id)
		throws NoSuchEDDepartmentException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the e d department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e d department
	 * @return the e d department that was removed
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDDepartment remove(Serializable primaryKey)
		throws NoSuchEDDepartmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EDDepartment edDepartment = (EDDepartment)session.get(EDDepartmentImpl.class,
					primaryKey);

			if (edDepartment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEDDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(edDepartment);
		}
		catch (NoSuchEDDepartmentException nsee) {
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
	protected EDDepartment removeImpl(EDDepartment edDepartment)
		throws SystemException {
		edDepartment = toUnwrappedModel(edDepartment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, edDepartment);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(edDepartment);

		return edDepartment;
	}

	@Override
	public EDDepartment updateImpl(
		com.vportal.portlet.edirectory.model.EDDepartment edDepartment,
		boolean merge) throws SystemException {
		edDepartment = toUnwrappedModel(edDepartment);

		boolean isNew = edDepartment.isNew();

		EDDepartmentModelImpl edDepartmentModelImpl = (EDDepartmentModelImpl)edDepartment;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, edDepartment, merge);

			edDepartment.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EDDepartmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getOriginalLevelEd())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL,
					args);

				args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getLevelEd())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL,
					args);
			}

			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getOriginalParent()),
						
						edDepartmentModelImpl.getOriginalLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getOriginalGroupId()),
						
						edDepartmentModelImpl.getOriginalDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getParent()),
						
						edDepartmentModelImpl.getLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getGroupId()),
						
						edDepartmentModelImpl.getDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getOriginalParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);

				args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT,
					args);
			}

			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEANDGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						edDepartmentModelImpl.getOriginalLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getOriginalGroupId()),
						
						edDepartmentModelImpl.getOriginalDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEANDGROUP,
					args);

				args = new Object[] {
						edDepartmentModelImpl.getLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getGroupId()),
						
						edDepartmentModelImpl.getDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGEANDGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEANDGROUP,
					args);
			}

			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDDOMAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getOriginalLevelEd()),
						
						edDepartmentModelImpl.getOriginalLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getOriginalGroupId()),
						
						edDepartmentModelImpl.getOriginalDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDDOMAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDDOMAIN,
					args);

				args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getLevelEd()),
						
						edDepartmentModelImpl.getLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getGroupId()),
						
						edDepartmentModelImpl.getDomainId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDDOMAIN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDDOMAIN,
					args);
			}

			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						edDepartmentModelImpl.getOriginalLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G,
					args);

				args = new Object[] {
						edDepartmentModelImpl.getLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G,
					args);
			}

			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						edDepartmentModelImpl.getOriginalLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getOriginalGroupId()),
						Long.valueOf(edDepartmentModelImpl.getOriginalParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G_P,
					args);

				args = new Object[] {
						edDepartmentModelImpl.getLanguageId(),
						Long.valueOf(edDepartmentModelImpl.getGroupId()),
						Long.valueOf(edDepartmentModelImpl.getParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_L_G_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G_P,
					args);
			}
		}

		EntityCacheUtil.putResult(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDDepartmentImpl.class, edDepartment.getPrimaryKey(), edDepartment);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_G,
				new Object[] {
					Long.valueOf(edDepartment.getId()),
					Long.valueOf(edDepartment.getGroupId())
				}, edDepartment);
		}
		else {
			if ((edDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_D_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edDepartmentModelImpl.getOriginalId()),
						Long.valueOf(edDepartmentModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_G, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_G,
					new Object[] {
						Long.valueOf(edDepartment.getId()),
						Long.valueOf(edDepartment.getGroupId())
					}, edDepartment);
			}
		}

		return edDepartment;
	}

	protected EDDepartment toUnwrappedModel(EDDepartment edDepartment) {
		if (edDepartment instanceof EDDepartmentImpl) {
			return edDepartment;
		}

		EDDepartmentImpl edDepartmentImpl = new EDDepartmentImpl();

		edDepartmentImpl.setNew(edDepartment.isNew());
		edDepartmentImpl.setPrimaryKey(edDepartment.getPrimaryKey());

		edDepartmentImpl.setId(edDepartment.getId());
		edDepartmentImpl.setCreatedDate(edDepartment.getCreatedDate());
		edDepartmentImpl.setName(edDepartment.getName());
		edDepartmentImpl.setParent(edDepartment.getParent());
		edDepartmentImpl.setPhone(edDepartment.getPhone());
		edDepartmentImpl.setFax(edDepartment.getFax());
		edDepartmentImpl.setLevelEd(edDepartment.getLevelEd());
		edDepartmentImpl.setEmail(edDepartment.getEmail());
		edDepartmentImpl.setAddress(edDepartment.getAddress());
		edDepartmentImpl.setDescription(edDepartment.getDescription());
		edDepartmentImpl.setWebsite(edDepartment.getWebsite());
		edDepartmentImpl.setImgurl(edDepartment.getImgurl());
		edDepartmentImpl.setCompanyId(edDepartment.getCompanyId());
		edDepartmentImpl.setGroupId(edDepartment.getGroupId());
		edDepartmentImpl.setUserId(edDepartment.getUserId());
		edDepartmentImpl.setLanguageId(edDepartment.getLanguageId());
		edDepartmentImpl.setDomainId(edDepartment.getDomainId());

		return edDepartmentImpl;
	}

	/**
	 * Returns the e d department with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e d department
	 * @return the e d department
	 * @throws com.liferay.portal.NoSuchModelException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDDepartment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the e d department with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDDepartmentException} if it could not be found.
	 *
	 * @param id the primary key of the e d department
	 * @return the e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByPrimaryKey(long id)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = fetchByPrimaryKey(id);

		if (edDepartment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchEDDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return edDepartment;
	}

	/**
	 * Returns the e d department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e d department
	 * @return the e d department, or <code>null</code> if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDDepartment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the e d department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e d department
	 * @return the e d department, or <code>null</code> if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment fetchByPrimaryKey(long id) throws SystemException {
		EDDepartment edDepartment = (EDDepartment)EntityCacheUtil.getResult(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				EDDepartmentImpl.class, id);

		if (edDepartment == _nullEDDepartment) {
			return null;
		}

		if (edDepartment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				edDepartment = (EDDepartment)session.get(EDDepartmentImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (edDepartment != null) {
					cacheResult(edDepartment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EDDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						EDDepartmentImpl.class, id, _nullEDDepartment);
				}

				closeSession(session);
			}
		}

		return edDepartment;
	}

	/**
	 * Returns all the e d departments where levelEd = &#63;.
	 *
	 * @param levelEd the level ed
	 * @return the matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLevel(long levelEd)
		throws SystemException {
		return findByLevel(levelEd, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments where levelEd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelEd the level ed
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLevel(long levelEd, int start, int end)
		throws SystemException {
		return findByLevel(levelEd, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments where levelEd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelEd the level ed
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLevel(long levelEd, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL;
			finderArgs = new Object[] { levelEd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVEL;
			finderArgs = new Object[] { levelEd, start, end, orderByComparator };
		}

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_LEVEL_LEVELED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelEd);

				list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e d department in the ordered set where levelEd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelEd the level ed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByLevel_First(long levelEd,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		List<EDDepartment> list = findByLevel(levelEd, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("levelEd=");
			msg.append(levelEd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d department in the ordered set where levelEd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelEd the level ed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByLevel_Last(long levelEd,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		int count = countByLevel(levelEd);

		List<EDDepartment> list = findByLevel(levelEd, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("levelEd=");
			msg.append(levelEd);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d departments before and after the current e d department in the ordered set where levelEd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d department
	 * @param levelEd the level ed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment[] findByLevel_PrevAndNext(long id, long levelEd,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDDepartment[] array = new EDDepartmentImpl[3];

			array[0] = getByLevel_PrevAndNext(session, edDepartment, levelEd,
					orderByComparator, true);

			array[1] = edDepartment;

			array[2] = getByLevel_PrevAndNext(session, edDepartment, levelEd,
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

	protected EDDepartment getByLevel_PrevAndNext(Session session,
		EDDepartment edDepartment, long levelEd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_LEVEL_LEVELED_2);

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
			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(levelEd);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d departments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByGroupId(long groupId, int start, int end,
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

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e d department in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		List<EDDepartment> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d department in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		int count = countByGroupId(groupId);

		List<EDDepartment> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d departments before and after the current e d department in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d department
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment[] findByGroupId_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDDepartment[] array = new EDDepartmentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, edDepartment, groupId,
					orderByComparator, true);

			array[1] = edDepartment;

			array[2] = getByGroupId_PrevAndNext(session, edDepartment, groupId,
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

	protected EDDepartment getByGroupId_PrevAndNext(Session session,
		EDDepartment edDepartment, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

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
			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * @param parent the parent
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @return the matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByParentId(long parent, String languageId,
		long groupId, String domainId) throws SystemException {
		return findByParentId(parent, languageId, groupId, domainId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByParentId(long parent, String languageId,
		long groupId, String domainId, int start, int end)
		throws SystemException {
		return findByParentId(parent, languageId, groupId, domainId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByParentId(long parent, String languageId,
		long groupId, String domainId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parent, languageId, groupId, domainId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] {
					parent, languageId, groupId, domainId,
					
					start, end, orderByComparator
				};
		}

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENT_2);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_PARENTID_GROUPID_2);

			if (domainId == null) {
				query.append(_FINDER_COLUMN_PARENTID_DOMAINID_1);
			}
			else {
				if (domainId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENTID_DOMAINID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENTID_DOMAINID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parent);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(groupId);

				if (domainId != null) {
					qPos.add(domainId);
				}

				list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e d department in the ordered set where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByParentId_First(long parent, String languageId,
		long groupId, String domainId, OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		List<EDDepartment> list = findByParentId(parent, languageId, groupId,
				domainId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parent=");
			msg.append(parent);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", domainId=");
			msg.append(domainId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d department in the ordered set where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByParentId_Last(long parent, String languageId,
		long groupId, String domainId, OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		int count = countByParentId(parent, languageId, groupId, domainId);

		List<EDDepartment> list = findByParentId(parent, languageId, groupId,
				domainId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parent=");
			msg.append(parent);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", domainId=");
			msg.append(domainId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d departments before and after the current e d department in the ordered set where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d department
	 * @param parent the parent
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment[] findByParentId_PrevAndNext(long id, long parent,
		String languageId, long groupId, String domainId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDDepartment[] array = new EDDepartmentImpl[3];

			array[0] = getByParentId_PrevAndNext(session, edDepartment, parent,
					languageId, groupId, domainId, orderByComparator, true);

			array[1] = edDepartment;

			array[2] = getByParentId_PrevAndNext(session, edDepartment, parent,
					languageId, groupId, domainId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EDDepartment getByParentId_PrevAndNext(Session session,
		EDDepartment edDepartment, long parent, String languageId,
		long groupId, String domainId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_PARENT_2);

		if (languageId == null) {
			query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_1);
		}
		else {
			if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_2);
			}
		}

		query.append(_FINDER_COLUMN_PARENTID_GROUPID_2);

		if (domainId == null) {
			query.append(_FINDER_COLUMN_PARENTID_DOMAINID_1);
		}
		else {
			if (domainId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTID_DOMAINID_3);
			}
			else {
				query.append(_FINDER_COLUMN_PARENTID_DOMAINID_2);
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
			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parent);

		if (languageId != null) {
			qPos.add(languageId);
		}

		qPos.add(groupId);

		if (domainId != null) {
			qPos.add(domainId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d departments where parent = &#63;.
	 *
	 * @param parent the parent
	 * @return the matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByParent(long parent)
		throws SystemException {
		return findByParent(parent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByParent(long parent, int start, int end)
		throws SystemException {
		return findByParent(parent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByParent(long parent, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { parent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENT;
			finderArgs = new Object[] { parent, start, end, orderByComparator };
		}

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parent);

				list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e d department in the ordered set where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByParent_First(long parent,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		List<EDDepartment> list = findByParent(parent, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d department in the ordered set where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByParent_Last(long parent,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		int count = countByParent(parent);

		List<EDDepartment> list = findByParent(parent, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d departments before and after the current e d department in the ordered set where parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d department
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment[] findByParent_PrevAndNext(long id, long parent,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDDepartment[] array = new EDDepartmentImpl[3];

			array[0] = getByParent_PrevAndNext(session, edDepartment, parent,
					orderByComparator, true);

			array[1] = edDepartment;

			array[2] = getByParent_PrevAndNext(session, edDepartment, parent,
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

	protected EDDepartment getByParent_PrevAndNext(Session session,
		EDDepartment edDepartment, long parent,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_PARENT_PARENT_2);

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
			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @return the matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLanguageAndGroup(String languageId,
		long groupId, String domainId) throws SystemException {
		return findByLanguageAndGroup(languageId, groupId, domainId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLanguageAndGroup(String languageId,
		long groupId, String domainId, int start, int end)
		throws SystemException {
		return findByLanguageAndGroup(languageId, groupId, domainId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLanguageAndGroup(String languageId,
		long groupId, String domainId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGEANDGROUP;
			finderArgs = new Object[] { languageId, groupId, domainId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGEANDGROUP;
			finderArgs = new Object[] {
					languageId, groupId, domainId,
					
					start, end, orderByComparator
				};
		}

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_GROUPID_2);

			if (domainId == null) {
				query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_1);
			}
			else {
				if (domainId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_3);
				}
				else {
					query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(groupId);

				if (domainId != null) {
					qPos.add(domainId);
				}

				list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e d department in the ordered set where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByLanguageAndGroup_First(String languageId,
		long groupId, String domainId, OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		List<EDDepartment> list = findByLanguageAndGroup(languageId, groupId,
				domainId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", domainId=");
			msg.append(domainId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d department in the ordered set where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByLanguageAndGroup_Last(String languageId,
		long groupId, String domainId, OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		int count = countByLanguageAndGroup(languageId, groupId, domainId);

		List<EDDepartment> list = findByLanguageAndGroup(languageId, groupId,
				domainId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", domainId=");
			msg.append(domainId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d departments before and after the current e d department in the ordered set where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d department
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment[] findByLanguageAndGroup_PrevAndNext(long id,
		String languageId, long groupId, String domainId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDDepartment[] array = new EDDepartmentImpl[3];

			array[0] = getByLanguageAndGroup_PrevAndNext(session, edDepartment,
					languageId, groupId, domainId, orderByComparator, true);

			array[1] = edDepartment;

			array[2] = getByLanguageAndGroup_PrevAndNext(session, edDepartment,
					languageId, groupId, domainId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EDDepartment getByLanguageAndGroup_PrevAndNext(Session session,
		EDDepartment edDepartment, String languageId, long groupId,
		String domainId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

		if (languageId == null) {
			query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_1);
		}
		else {
			if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_2);
			}
		}

		query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_GROUPID_2);

		if (domainId == null) {
			query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_1);
		}
		else {
			if (domainId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_3);
			}
			else {
				query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_2);
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
			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (languageId != null) {
			qPos.add(languageId);
		}

		qPos.add(groupId);

		if (domainId != null) {
			qPos.add(domainId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * @param levelEd the level ed
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @return the matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLevelAndDomain(long levelEd,
		String languageId, long groupId, String domainId)
		throws SystemException {
		return findByLevelAndDomain(levelEd, languageId, groupId, domainId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelEd the level ed
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLevelAndDomain(long levelEd,
		String languageId, long groupId, String domainId, int start, int end)
		throws SystemException {
		return findByLevelAndDomain(levelEd, languageId, groupId, domainId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelEd the level ed
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByLevelAndDomain(long levelEd,
		String languageId, long groupId, String domainId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDDOMAIN;
			finderArgs = new Object[] { levelEd, languageId, groupId, domainId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDDOMAIN;
			finderArgs = new Object[] {
					levelEd, languageId, groupId, domainId,
					
					start, end, orderByComparator
				};
		}

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LEVELED_2);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_LEVELANDDOMAIN_GROUPID_2);

			if (domainId == null) {
				query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_1);
			}
			else {
				if (domainId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_3);
				}
				else {
					query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelEd);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(groupId);

				if (domainId != null) {
					qPos.add(domainId);
				}

				list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e d department in the ordered set where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelEd the level ed
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByLevelAndDomain_First(long levelEd,
		String languageId, long groupId, String domainId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		List<EDDepartment> list = findByLevelAndDomain(levelEd, languageId,
				groupId, domainId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("levelEd=");
			msg.append(levelEd);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", domainId=");
			msg.append(domainId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d department in the ordered set where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param levelEd the level ed
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByLevelAndDomain_Last(long levelEd,
		String languageId, long groupId, String domainId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		int count = countByLevelAndDomain(levelEd, languageId, groupId, domainId);

		List<EDDepartment> list = findByLevelAndDomain(levelEd, languageId,
				groupId, domainId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("levelEd=");
			msg.append(levelEd);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", domainId=");
			msg.append(domainId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d departments before and after the current e d department in the ordered set where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d department
	 * @param levelEd the level ed
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment[] findByLevelAndDomain_PrevAndNext(long id,
		long levelEd, String languageId, long groupId, String domainId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDDepartment[] array = new EDDepartmentImpl[3];

			array[0] = getByLevelAndDomain_PrevAndNext(session, edDepartment,
					levelEd, languageId, groupId, domainId, orderByComparator,
					true);

			array[1] = edDepartment;

			array[2] = getByLevelAndDomain_PrevAndNext(session, edDepartment,
					levelEd, languageId, groupId, domainId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EDDepartment getByLevelAndDomain_PrevAndNext(Session session,
		EDDepartment edDepartment, long levelEd, String languageId,
		long groupId, String domainId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LEVELED_2);

		if (languageId == null) {
			query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_1);
		}
		else {
			if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_2);
			}
		}

		query.append(_FINDER_COLUMN_LEVELANDDOMAIN_GROUPID_2);

		if (domainId == null) {
			query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_1);
		}
		else {
			if (domainId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_3);
			}
			else {
				query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_2);
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
			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(levelEd);

		if (languageId != null) {
			qPos.add(languageId);
		}

		qPos.add(groupId);

		if (domainId != null) {
			qPos.add(domainId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the e d department where id = &#63; and groupId = &#63; or throws a {@link com.vportal.portlet.edirectory.NoSuchEDDepartmentException} if it could not be found.
	 *
	 * @param id the ID
	 * @param groupId the group ID
	 * @return the matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByD_G(long id, long groupId)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = fetchByD_G(id, groupId);

		if (edDepartment == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEDDepartmentException(msg.toString());
		}

		return edDepartment;
	}

	/**
	 * Returns the e d department where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @param groupId the group ID
	 * @return the matching e d department, or <code>null</code> if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment fetchByD_G(long id, long groupId)
		throws SystemException {
		return fetchByD_G(id, groupId, true);
	}

	/**
	 * Returns the e d department where id = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching e d department, or <code>null</code> if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment fetchByD_G(long id, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { id, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_D_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_D_G_ID_2);

			query.append(_FINDER_COLUMN_D_G_GROUPID_2);

			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				qPos.add(groupId);

				List<EDDepartment> list = q.list();

				result = list;

				EDDepartment edDepartment = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_G,
						finderArgs, list);
				}
				else {
					edDepartment = list.get(0);

					cacheResult(edDepartment);

					if ((edDepartment.getId() != id) ||
							(edDepartment.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_G,
							finderArgs, edDepartment);
					}
				}

				return edDepartment;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_G,
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
				return (EDDepartment)result;
			}
		}
	}

	/**
	 * Returns all the e d departments where languageId = &#63; and groupId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @return the matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByL_G(String languageId, long groupId)
		throws SystemException {
		return findByL_G(languageId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments where languageId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByL_G(String languageId, long groupId,
		int start, int end) throws SystemException {
		return findByL_G(languageId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments where languageId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByL_G(String languageId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G;
			finderArgs = new Object[] { languageId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_L_G;
			finderArgs = new Object[] {
					languageId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_L_G_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_L_G_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_L_G_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_L_G_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(groupId);

				list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e d department in the ordered set where languageId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByL_G_First(String languageId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		List<EDDepartment> list = findByL_G(languageId, groupId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d department in the ordered set where languageId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByL_G_Last(String languageId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		int count = countByL_G(languageId, groupId);

		List<EDDepartment> list = findByL_G(languageId, groupId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d departments before and after the current e d department in the ordered set where languageId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d department
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment[] findByL_G_PrevAndNext(long id, String languageId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDDepartment[] array = new EDDepartmentImpl[3];

			array[0] = getByL_G_PrevAndNext(session, edDepartment, languageId,
					groupId, orderByComparator, true);

			array[1] = edDepartment;

			array[2] = getByL_G_PrevAndNext(session, edDepartment, languageId,
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

	protected EDDepartment getByL_G_PrevAndNext(Session session,
		EDDepartment edDepartment, String languageId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

		if (languageId == null) {
			query.append(_FINDER_COLUMN_L_G_LANGUAGEID_1);
		}
		else {
			if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_L_G_LANGUAGEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_L_G_LANGUAGEID_2);
			}
		}

		query.append(_FINDER_COLUMN_L_G_GROUPID_2);

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
			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (languageId != null) {
			qPos.add(languageId);
		}

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param parent the parent
	 * @return the matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByL_G_P(String languageId, long groupId,
		long parent) throws SystemException {
		return findByL_G_P(languageId, groupId, parent, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByL_G_P(String languageId, long groupId,
		long parent, int start, int end) throws SystemException {
		return findByL_G_P(languageId, groupId, parent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findByL_G_P(String languageId, long groupId,
		long parent, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_L_G_P;
			finderArgs = new Object[] { languageId, groupId, parent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_L_G_P;
			finderArgs = new Object[] {
					languageId, groupId, parent,
					
					start, end, orderByComparator
				};
		}

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_L_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_L_G_P_PARENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(groupId);

				qPos.add(parent);

				list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e d department in the ordered set where languageId = &#63; and groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByL_G_P_First(String languageId, long groupId,
		long parent, OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		List<EDDepartment> list = findByL_G_P(languageId, groupId, parent, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d department in the ordered set where languageId = &#63; and groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a matching e d department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment findByL_G_P_Last(String languageId, long groupId,
		long parent, OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		int count = countByL_G_P(languageId, groupId, parent);

		List<EDDepartment> list = findByL_G_P(languageId, groupId, parent,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("languageId=");
			msg.append(languageId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", parent=");
			msg.append(parent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d departments before and after the current e d department in the ordered set where languageId = &#63; and groupId = &#63; and parent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d department
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param parent the parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDDepartmentException if a e d department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDDepartment[] findByL_G_P_PrevAndNext(long id, String languageId,
		long groupId, long parent, OrderByComparator orderByComparator)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDDepartment[] array = new EDDepartmentImpl[3];

			array[0] = getByL_G_P_PrevAndNext(session, edDepartment,
					languageId, groupId, parent, orderByComparator, true);

			array[1] = edDepartment;

			array[2] = getByL_G_P_PrevAndNext(session, edDepartment,
					languageId, groupId, parent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EDDepartment getByL_G_P_PrevAndNext(Session session,
		EDDepartment edDepartment, String languageId, long groupId,
		long parent, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDDEPARTMENT_WHERE);

		if (languageId == null) {
			query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_1);
		}
		else {
			if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_2);
			}
		}

		query.append(_FINDER_COLUMN_L_G_P_GROUPID_2);

		query.append(_FINDER_COLUMN_L_G_P_PARENT_2);

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
			query.append(EDDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (languageId != null) {
			qPos.add(languageId);
		}

		qPos.add(groupId);

		qPos.add(parent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d departments.
	 *
	 * @return the e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @return the range of e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e d departments
	 * @param end the upper bound of the range of e d departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDDepartment> findAll(int start, int end,
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

		List<EDDepartment> list = (List<EDDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EDDEPARTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EDDEPARTMENT.concat(EDDepartmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EDDepartment>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e d departments where levelEd = &#63; from the database.
	 *
	 * @param levelEd the level ed
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLevel(long levelEd) throws SystemException {
		for (EDDepartment edDepartment : findByLevel(levelEd)) {
			remove(edDepartment);
		}
	}

	/**
	 * Removes all the e d departments where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (EDDepartment edDepartment : findByGroupId(groupId)) {
			remove(edDepartment);
		}
	}

	/**
	 * Removes all the e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	 *
	 * @param parent the parent
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentId(long parent, String languageId, long groupId,
		String domainId) throws SystemException {
		for (EDDepartment edDepartment : findByParentId(parent, languageId,
				groupId, domainId)) {
			remove(edDepartment);
		}
	}

	/**
	 * Removes all the e d departments where parent = &#63; from the database.
	 *
	 * @param parent the parent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParent(long parent) throws SystemException {
		for (EDDepartment edDepartment : findByParent(parent)) {
			remove(edDepartment);
		}
	}

	/**
	 * Removes all the e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLanguageAndGroup(String languageId, long groupId,
		String domainId) throws SystemException {
		for (EDDepartment edDepartment : findByLanguageAndGroup(languageId,
				groupId, domainId)) {
			remove(edDepartment);
		}
	}

	/**
	 * Removes all the e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63; from the database.
	 *
	 * @param levelEd the level ed
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLevelAndDomain(long levelEd, String languageId,
		long groupId, String domainId) throws SystemException {
		for (EDDepartment edDepartment : findByLevelAndDomain(levelEd,
				languageId, groupId, domainId)) {
			remove(edDepartment);
		}
	}

	/**
	 * Removes the e d department where id = &#63; and groupId = &#63; from the database.
	 *
	 * @param id the ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByD_G(long id, long groupId)
		throws NoSuchEDDepartmentException, SystemException {
		EDDepartment edDepartment = findByD_G(id, groupId);

		remove(edDepartment);
	}

	/**
	 * Removes all the e d departments where languageId = &#63; and groupId = &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByL_G(String languageId, long groupId)
		throws SystemException {
		for (EDDepartment edDepartment : findByL_G(languageId, groupId)) {
			remove(edDepartment);
		}
	}

	/**
	 * Removes all the e d departments where languageId = &#63; and groupId = &#63; and parent = &#63; from the database.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param parent the parent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByL_G_P(String languageId, long groupId, long parent)
		throws SystemException {
		for (EDDepartment edDepartment : findByL_G_P(languageId, groupId, parent)) {
			remove(edDepartment);
		}
	}

	/**
	 * Removes all the e d departments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EDDepartment edDepartment : findAll()) {
			remove(edDepartment);
		}
	}

	/**
	 * Returns the number of e d departments where levelEd = &#63;.
	 *
	 * @param levelEd the level ed
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLevel(long levelEd) throws SystemException {
		Object[] finderArgs = new Object[] { levelEd };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LEVEL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_LEVEL_LEVELED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelEd);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEVEL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d departments where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

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
	 * Returns the number of e d departments where parent = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * @param parent the parent
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentId(long parent, String languageId, long groupId,
		String domainId) throws SystemException {
		Object[] finderArgs = new Object[] { parent, languageId, groupId, domainId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENT_2);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENTID_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_PARENTID_GROUPID_2);

			if (domainId == null) {
				query.append(_FINDER_COLUMN_PARENTID_DOMAINID_1);
			}
			else {
				if (domainId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENTID_DOMAINID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENTID_DOMAINID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parent);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(groupId);

				if (domainId != null) {
					qPos.add(domainId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d departments where parent = &#63;.
	 *
	 * @param parent the parent
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParent(long parent) throws SystemException {
		Object[] finderArgs = new Object[] { parent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_PARENT_PARENT_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d departments where languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLanguageAndGroup(String languageId, long groupId,
		String domainId) throws SystemException {
		Object[] finderArgs = new Object[] { languageId, groupId, domainId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LANGUAGEANDGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_GROUPID_2);

			if (domainId == null) {
				query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_1);
			}
			else {
				if (domainId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_3);
				}
				else {
					query.append(_FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(groupId);

				if (domainId != null) {
					qPos.add(domainId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LANGUAGEANDGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d departments where levelEd = &#63; and languageId = &#63; and groupId = &#63; and domainId = &#63;.
	 *
	 * @param levelEd the level ed
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param domainId the domain ID
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLevelAndDomain(long levelEd, String languageId,
		long groupId, String domainId) throws SystemException {
		Object[] finderArgs = new Object[] {
				levelEd, languageId, groupId, domainId
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LEVELANDDOMAIN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LEVELED_2);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_LEVELANDDOMAIN_GROUPID_2);

			if (domainId == null) {
				query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_1);
			}
			else {
				if (domainId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_3);
				}
				else {
					query.append(_FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(levelEd);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(groupId);

				if (domainId != null) {
					qPos.add(domainId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LEVELANDDOMAIN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d departments where id = &#63; and groupId = &#63;.
	 *
	 * @param id the ID
	 * @param groupId the group ID
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByD_G(long id, long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { id, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_D_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_D_G_ID_2);

			query.append(_FINDER_COLUMN_D_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_G, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d departments where languageId = &#63; and groupId = &#63;.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByL_G(String languageId, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { languageId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_L_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_L_G_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_L_G_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_L_G_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_L_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (languageId != null) {
					qPos.add(languageId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_L_G, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d departments where languageId = &#63; and groupId = &#63; and parent = &#63;.
	 *
	 * @param languageId the language ID
	 * @param groupId the group ID
	 * @param parent the parent
	 * @return the number of matching e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByL_G_P(String languageId, long groupId, long parent)
		throws SystemException {
		Object[] finderArgs = new Object[] { languageId, groupId, parent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_L_G_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EDDEPARTMENT_WHERE);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_1);
			}
			else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_L_G_P_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_L_G_P_GROUPID_2);

			query.append(_FINDER_COLUMN_L_G_P_PARENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (languageId != null) {
					qPos.add(languageId);
				}

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_L_G_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d departments.
	 *
	 * @return the number of e d departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EDDEPARTMENT);

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
	 * Initializes the e d department persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.edirectory.model.EDDepartment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EDDepartment>> listenersList = new ArrayList<ModelListener<EDDepartment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EDDepartment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EDDepartmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = EDDepartmentPersistence.class)
	protected EDDepartmentPersistence edDepartmentPersistence;
	@BeanReference(type = EDEmployeePersistence.class)
	protected EDEmployeePersistence edEmployeePersistence;
	@BeanReference(type = EDFunctionPersistence.class)
	protected EDFunctionPersistence edFunctionPersistence;
	@BeanReference(type = EDFunctionDepartmentPersistence.class)
	protected EDFunctionDepartmentPersistence edFunctionDepartmentPersistence;
	@BeanReference(type = EDFunctionEmployeePersistence.class)
	protected EDFunctionEmployeePersistence edFunctionEmployeePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EDDEPARTMENT = "SELECT edDepartment FROM EDDepartment edDepartment";
	private static final String _SQL_SELECT_EDDEPARTMENT_WHERE = "SELECT edDepartment FROM EDDepartment edDepartment WHERE ";
	private static final String _SQL_COUNT_EDDEPARTMENT = "SELECT COUNT(edDepartment) FROM EDDepartment edDepartment";
	private static final String _SQL_COUNT_EDDEPARTMENT_WHERE = "SELECT COUNT(edDepartment) FROM EDDepartment edDepartment WHERE ";
	private static final String _FINDER_COLUMN_LEVEL_LEVELED_2 = "edDepartment.levelEd = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "edDepartment.groupId = ?";
	private static final String _FINDER_COLUMN_PARENTID_PARENT_2 = "edDepartment.parent = ? AND ";
	private static final String _FINDER_COLUMN_PARENTID_LANGUAGEID_1 = "edDepartment.languageId IS NULL AND ";
	private static final String _FINDER_COLUMN_PARENTID_LANGUAGEID_2 = "edDepartment.languageId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTID_LANGUAGEID_3 = "(edDepartment.languageId IS NULL OR edDepartment.languageId = ?) AND ";
	private static final String _FINDER_COLUMN_PARENTID_GROUPID_2 = "edDepartment.groupId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTID_DOMAINID_1 = "edDepartment.domainId IS NULL";
	private static final String _FINDER_COLUMN_PARENTID_DOMAINID_2 = "edDepartment.domainId = ?";
	private static final String _FINDER_COLUMN_PARENTID_DOMAINID_3 = "(edDepartment.domainId IS NULL OR edDepartment.domainId = ?)";
	private static final String _FINDER_COLUMN_PARENT_PARENT_2 = "edDepartment.parent = ?";
	private static final String _FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_1 = "edDepartment.languageId IS NULL AND ";
	private static final String _FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_2 = "edDepartment.languageId = ? AND ";
	private static final String _FINDER_COLUMN_LANGUAGEANDGROUP_LANGUAGEID_3 = "(edDepartment.languageId IS NULL OR edDepartment.languageId = ?) AND ";
	private static final String _FINDER_COLUMN_LANGUAGEANDGROUP_GROUPID_2 = "edDepartment.groupId = ? AND ";
	private static final String _FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_1 = "edDepartment.domainId IS NULL";
	private static final String _FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_2 = "edDepartment.domainId = ?";
	private static final String _FINDER_COLUMN_LANGUAGEANDGROUP_DOMAINID_3 = "(edDepartment.domainId IS NULL OR edDepartment.domainId = ?)";
	private static final String _FINDER_COLUMN_LEVELANDDOMAIN_LEVELED_2 = "edDepartment.levelEd = ? AND ";
	private static final String _FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_1 = "edDepartment.languageId IS NULL AND ";
	private static final String _FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_2 = "edDepartment.languageId = ? AND ";
	private static final String _FINDER_COLUMN_LEVELANDDOMAIN_LANGUAGEID_3 = "(edDepartment.languageId IS NULL OR edDepartment.languageId = ?) AND ";
	private static final String _FINDER_COLUMN_LEVELANDDOMAIN_GROUPID_2 = "edDepartment.groupId = ? AND ";
	private static final String _FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_1 = "edDepartment.domainId IS NULL";
	private static final String _FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_2 = "edDepartment.domainId = ?";
	private static final String _FINDER_COLUMN_LEVELANDDOMAIN_DOMAINID_3 = "(edDepartment.domainId IS NULL OR edDepartment.domainId = ?)";
	private static final String _FINDER_COLUMN_D_G_ID_2 = "edDepartment.id = ? AND ";
	private static final String _FINDER_COLUMN_D_G_GROUPID_2 = "edDepartment.groupId = ?";
	private static final String _FINDER_COLUMN_L_G_LANGUAGEID_1 = "edDepartment.languageId IS NULL AND ";
	private static final String _FINDER_COLUMN_L_G_LANGUAGEID_2 = "edDepartment.languageId = ? AND ";
	private static final String _FINDER_COLUMN_L_G_LANGUAGEID_3 = "(edDepartment.languageId IS NULL OR edDepartment.languageId = ?) AND ";
	private static final String _FINDER_COLUMN_L_G_GROUPID_2 = "edDepartment.groupId = ?";
	private static final String _FINDER_COLUMN_L_G_P_LANGUAGEID_1 = "edDepartment.languageId IS NULL AND ";
	private static final String _FINDER_COLUMN_L_G_P_LANGUAGEID_2 = "edDepartment.languageId = ? AND ";
	private static final String _FINDER_COLUMN_L_G_P_LANGUAGEID_3 = "(edDepartment.languageId IS NULL OR edDepartment.languageId = ?) AND ";
	private static final String _FINDER_COLUMN_L_G_P_GROUPID_2 = "edDepartment.groupId = ? AND ";
	private static final String _FINDER_COLUMN_L_G_P_PARENT_2 = "edDepartment.parent = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "edDepartment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EDDepartment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EDDepartment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EDDepartmentPersistenceImpl.class);
	private static EDDepartment _nullEDDepartment = new EDDepartmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EDDepartment> toCacheModel() {
				return _nullEDDepartmentCacheModel;
			}
		};

	private static CacheModel<EDDepartment> _nullEDDepartmentCacheModel = new CacheModel<EDDepartment>() {
			public EDDepartment toEntityModel() {
				return _nullEDDepartment;
			}
		};
}