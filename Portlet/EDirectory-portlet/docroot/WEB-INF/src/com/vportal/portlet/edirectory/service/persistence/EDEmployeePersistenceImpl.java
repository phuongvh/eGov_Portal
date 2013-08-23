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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.vportal.portlet.edirectory.NoSuchEDEmployeeException;
import com.vportal.portlet.edirectory.model.EDEmployee;
import com.vportal.portlet.edirectory.model.impl.EDEmployeeImpl;
import com.vportal.portlet.edirectory.model.impl.EDEmployeeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e d employee service.
 * 
 * <p>
 * Caching information and settings can be found in
 * <code>portal.properties</code>
 * </p>
 * 
 * @author HOAN
 * @see EDEmployeePersistence
 * @see EDEmployeeUtil
 * @generated
 */
public class EDEmployeePersistenceImpl extends BasePersistenceImpl<EDEmployee>
		implements EDEmployeePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never modify or reference this class directly. Always use {@link
	 * EDEmployeeUtil} to access the e d employee persistence. Modify
	 * <code>service.xml</code> and rerun ServiceBuilder to regenerate this
	 * class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EDEmployeeImpl.class
			.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY
			+ ".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY
			+ ".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid", new String[] {
					String.class.getName(),

					"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EDEmployeeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G", new String[] {
					String.class.getName(), Long.class.getName() },
			EDEmployeeModelImpl.UUID_COLUMN_BITMASK
					| EDEmployeeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_DEPARTMENT_ID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDepartment_Id", new String[] {
					Long.class.getName(), Long.class.getName() },
			EDEmployeeModelImpl.DEPARTMENTID_COLUMN_BITMASK
					| EDEmployeeModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENT_ID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartment_Id",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName(),

			"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			EDEmployeeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID_STATUS = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentId_Status", new String[] { Long.class.getName(),
					Long.class.getName(), Long.class.getName(),

					"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_STATUS = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentId_Status", new String[] { Long.class.getName(),
					Long.class.getName(), Long.class.getName() },
			EDEmployeeModelImpl.DEPARTMENTID_COLUMN_BITMASK
					| EDEmployeeModelImpl.GROUPID_COLUMN_BITMASK
					| EDEmployeeModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTID_STATUS = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentId_Status", new String[] { Long.class.getName(),
					Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartmentId",
			new String[] { Long.class.getName(),

			"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartmentId",
			new String[] { Long.class.getName() },
			EDEmployeeModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartmentId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSHOWED = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsShowed",
			new String[] { Boolean.class.getName(),

			"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSHOWED = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsShowed",
			new String[] { Boolean.class.getName() },
			EDEmployeeModelImpl.ISSHOWTREE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSHOWED = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsShowed",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L", new String[] {
					Long.class.getName(), String.class.getName(),

					"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] { Long.class.getName(), String.class.getName() },
			EDEmployeeModelImpl.GROUPID_COLUMN_BITMASK
					| EDEmployeeModelImpl.LANGUAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_I = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_I",
			new String[] { Long.class.getName(), String.class.getName(),
					Boolean.class.getName(),

					"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_I = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_I",
			new String[] { Long.class.getName(), String.class.getName(),
					Boolean.class.getName() },
			EDEmployeeModelImpl.GROUPID_COLUMN_BITMASK
					| EDEmployeeModelImpl.LANGUAGEID_COLUMN_BITMASK
					| EDEmployeeModelImpl.ISSHOWTREE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_I = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_I",
			new String[] { Long.class.getName(), String.class.getName(),
					Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_E_G = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByE_G", new String[] {
					Long.class.getName(), Long.class.getName() },
			EDEmployeeModelImpl.ID_COLUMN_BITMASK
					| EDEmployeeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_E_G = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_G",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID_GROUPID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentId_GroupId", new String[] { Long.class.getName(),
					Long.class.getName(),

					"java.lang.Integer", "java.lang.Integer",
					"com.liferay.portal.kernel.util.OrderByComparator" });
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_GROUPID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentId_GroupId", new String[] { Long.class.getName(),
					Long.class.getName() },
			EDEmployeeModelImpl.DEPARTMENTID_COLUMN_BITMASK
					| EDEmployeeModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTID_GROUPID = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentId_GroupId", new String[] { Long.class.getName(),
					Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, EDEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(
			EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the e d employee in the entity cache if it is enabled.
	 * 
	 * @param edEmployee
	 *            the e d employee
	 */
	public void cacheResult(EDEmployee edEmployee) {
		EntityCacheUtil.putResult(EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
				EDEmployeeImpl.class, edEmployee.getPrimaryKey(), edEmployee);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, new Object[] {
				edEmployee.getUuid(), Long.valueOf(edEmployee.getGroupId()) },
				edEmployee);

		FinderCacheUtil.putResult(
				FINDER_PATH_FETCH_BY_DEPARTMENT_ID,
				new Object[] { Long.valueOf(edEmployee.getDepartmentId()),
						Long.valueOf(edEmployee.getId()) }, edEmployee);

		FinderCacheUtil.putResult(
				FINDER_PATH_FETCH_BY_E_G,
				new Object[] { Long.valueOf(edEmployee.getId()),
						Long.valueOf(edEmployee.getGroupId()) }, edEmployee);

		edEmployee.resetOriginalValues();
	}

	/**
	 * Caches the e d employees in the entity cache if it is enabled.
	 * 
	 * @param edEmployees
	 *            the e d employees
	 */
	public void cacheResult(List<EDEmployee> edEmployees) {
		for (EDEmployee edEmployee : edEmployees) {
			if (EntityCacheUtil.getResult(
					EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
					EDEmployeeImpl.class, edEmployee.getPrimaryKey()) == null) {
				cacheResult(edEmployee);
			} else {
				edEmployee.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e d employees.
	 * 
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and
	 * {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by
	 * this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EDEmployeeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EDEmployeeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e d employee.
	 * 
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and
	 * {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by
	 * this method.
	 * </p>
	 */
	@Override
	public void clearCache(EDEmployee edEmployee) {
		EntityCacheUtil.removeResult(EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
				EDEmployeeImpl.class, edEmployee.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(edEmployee);
	}

	@Override
	public void clearCache(List<EDEmployee> edEmployees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EDEmployee edEmployee : edEmployees) {
			EntityCacheUtil.removeResult(
					EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
					EDEmployeeImpl.class, edEmployee.getPrimaryKey());

			clearUniqueFindersCache(edEmployee);
		}
	}

	protected void clearUniqueFindersCache(EDEmployee edEmployee) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, new Object[] {
				edEmployee.getUuid(), Long.valueOf(edEmployee.getGroupId()) });

		FinderCacheUtil.removeResult(
				FINDER_PATH_FETCH_BY_DEPARTMENT_ID,
				new Object[] { Long.valueOf(edEmployee.getDepartmentId()),
						Long.valueOf(edEmployee.getId()) });

		FinderCacheUtil.removeResult(
				FINDER_PATH_FETCH_BY_E_G,
				new Object[] { Long.valueOf(edEmployee.getId()),
						Long.valueOf(edEmployee.getGroupId()) });
	}

	/**
	 * Creates a new e d employee with the primary key. Does not add the e d
	 * employee to the database.
	 * 
	 * @param id
	 *            the primary key for the new e d employee
	 * @return the new e d employee
	 */
	public EDEmployee create(long id) {
		EDEmployee edEmployee = new EDEmployeeImpl();

		edEmployee.setNew(true);
		edEmployee.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		edEmployee.setUuid(uuid);

		return edEmployee;
	}

	/**
	 * Removes the e d employee with the primary key from the database. Also
	 * notifies the appropriate model listeners.
	 * 
	 * @param id
	 *            the primary key of the e d employee
	 * @return the e d employee that was removed
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee remove(long id) throws NoSuchEDEmployeeException,
			SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the e d employee with the primary key from the database. Also
	 * notifies the appropriate model listeners.
	 * 
	 * @param primaryKey
	 *            the primary key of the e d employee
	 * @return the e d employee that was removed
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	@Override
	public EDEmployee remove(Serializable primaryKey)
			throws NoSuchEDEmployeeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EDEmployee edEmployee = (EDEmployee) session.get(
					EDEmployeeImpl.class, primaryKey);

			if (edEmployee == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEDEmployeeException(
						_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(edEmployee);
		} catch (NoSuchEDEmployeeException nsee) {
			throw nsee;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	@Override
	protected EDEmployee removeImpl(EDEmployee edEmployee)
			throws SystemException {
		edEmployee = toUnwrappedModel(edEmployee);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, edEmployee);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}

		clearCache(edEmployee);

		return edEmployee;
	}

	@Override
	public EDEmployee updateImpl(
			com.vportal.portlet.edirectory.model.EDEmployee edEmployee,
			boolean merge) throws SystemException {
		edEmployee = toUnwrappedModel(edEmployee);

		boolean isNew = edEmployee.isNew();

		EDEmployeeModelImpl edEmployeeModelImpl = (EDEmployeeModelImpl) edEmployee;

		if (Validator.isNull(edEmployee.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			edEmployee.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, edEmployee, merge);

			edEmployee.setNew(false);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EDEmployeeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil
					.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { edEmployeeModelImpl
						.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID, args);

				args = new Object[] { edEmployeeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID, args);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { Long.valueOf(edEmployeeModelImpl
						.getOriginalGroupId()) };

				FinderCacheUtil
						.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID, args);

				args = new Object[] { Long.valueOf(edEmployeeModelImpl
						.getGroupId()) };

				FinderCacheUtil
						.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID, args);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_STATUS
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edEmployeeModelImpl
								.getOriginalDepartmentId()),
						Long.valueOf(edEmployeeModelImpl.getOriginalGroupId()),
						Long.valueOf(edEmployeeModelImpl.getOriginalStatus()) };

				FinderCacheUtil.removeResult(
						FINDER_PATH_COUNT_BY_DEPARTMENTID_STATUS, args);
				FinderCacheUtil
						.removeResult(
								FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_STATUS,
								args);

				args = new Object[] {
						Long.valueOf(edEmployeeModelImpl.getDepartmentId()),
						Long.valueOf(edEmployeeModelImpl.getGroupId()),
						Long.valueOf(edEmployeeModelImpl.getStatus()) };

				FinderCacheUtil.removeResult(
						FINDER_PATH_COUNT_BY_DEPARTMENTID_STATUS, args);
				FinderCacheUtil
						.removeResult(
								FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_STATUS,
								args);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { Long.valueOf(edEmployeeModelImpl
						.getOriginalDepartmentId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTID,
						args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID,
						args);

				args = new Object[] { Long.valueOf(edEmployeeModelImpl
						.getDepartmentId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTID,
						args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID,
						args);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSHOWED
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { Boolean
						.valueOf(edEmployeeModelImpl.getOriginalIsShowTree()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSHOWED,
						args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSHOWED, args);

				args = new Object[] { Boolean.valueOf(edEmployeeModelImpl
						.getIsShowTree()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSHOWED,
						args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSHOWED, args);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edEmployeeModelImpl.getOriginalGroupId()),

						edEmployeeModelImpl.getOriginalLanguageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L, args);

				args = new Object[] {
						Long.valueOf(edEmployeeModelImpl.getGroupId()),

						edEmployeeModelImpl.getLanguageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L, args);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_I
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edEmployeeModelImpl.getOriginalGroupId()),

						edEmployeeModelImpl.getOriginalLanguageId(),
						Boolean.valueOf(edEmployeeModelImpl
								.getOriginalIsShowTree()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_I, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_I, args);

				args = new Object[] {
						Long.valueOf(edEmployeeModelImpl.getGroupId()),

						edEmployeeModelImpl.getLanguageId(),
						Boolean.valueOf(edEmployeeModelImpl.getIsShowTree()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_I, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_I, args);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_GROUPID
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edEmployeeModelImpl
								.getOriginalDepartmentId()),
						Long.valueOf(edEmployeeModelImpl.getOriginalGroupId()) };

				FinderCacheUtil.removeResult(
						FINDER_PATH_COUNT_BY_DEPARTMENTID_GROUPID, args);
				FinderCacheUtil
						.removeResult(
								FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_GROUPID,
								args);

				args = new Object[] {
						Long.valueOf(edEmployeeModelImpl.getDepartmentId()),
						Long.valueOf(edEmployeeModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(
						FINDER_PATH_COUNT_BY_DEPARTMENTID_GROUPID, args);
				FinderCacheUtil
						.removeResult(
								FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_GROUPID,
								args);
			}
		}

		EntityCacheUtil.putResult(EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
				EDEmployeeImpl.class, edEmployee.getPrimaryKey(), edEmployee);

		if (isNew) {
			FinderCacheUtil
					.putResult(
							FINDER_PATH_FETCH_BY_UUID_G,
							new Object[] { edEmployee.getUuid(),
									Long.valueOf(edEmployee.getGroupId()) },
							edEmployee);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DEPARTMENT_ID,
					new Object[] { Long.valueOf(edEmployee.getDepartmentId()),
							Long.valueOf(edEmployee.getId()) }, edEmployee);

			FinderCacheUtil
					.putResult(FINDER_PATH_FETCH_BY_E_G,
							new Object[] { Long.valueOf(edEmployee.getId()),
									Long.valueOf(edEmployee.getGroupId()) },
							edEmployee);
		} else {
			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_FETCH_BY_UUID_G
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						edEmployeeModelImpl.getOriginalUuid(),
						Long.valueOf(edEmployeeModelImpl.getOriginalGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

				FinderCacheUtil.putResult(
						FINDER_PATH_FETCH_BY_UUID_G,
						new Object[] { edEmployee.getUuid(),
								Long.valueOf(edEmployee.getGroupId()) },
						edEmployee);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_FETCH_BY_DEPARTMENT_ID
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edEmployeeModelImpl
								.getOriginalDepartmentId()),
						Long.valueOf(edEmployeeModelImpl.getOriginalId()) };

				FinderCacheUtil.removeResult(
						FINDER_PATH_COUNT_BY_DEPARTMENT_ID, args);
				FinderCacheUtil.removeResult(
						FINDER_PATH_FETCH_BY_DEPARTMENT_ID, args);

				FinderCacheUtil.putResult(
						FINDER_PATH_FETCH_BY_DEPARTMENT_ID,
						new Object[] {
								Long.valueOf(edEmployee.getDepartmentId()),
								Long.valueOf(edEmployee.getId()) }, edEmployee);
			}

			if ((edEmployeeModelImpl.getColumnBitmask() & FINDER_PATH_FETCH_BY_E_G
					.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edEmployeeModelImpl.getOriginalId()),
						Long.valueOf(edEmployeeModelImpl.getOriginalGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_E_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_E_G, args);

				FinderCacheUtil.putResult(
						FINDER_PATH_FETCH_BY_E_G,
						new Object[] { Long.valueOf(edEmployee.getId()),
								Long.valueOf(edEmployee.getGroupId()) },
						edEmployee);
			}
		}

		return edEmployee;
	}

	protected EDEmployee toUnwrappedModel(EDEmployee edEmployee) {
		if (edEmployee instanceof EDEmployeeImpl) {
			return edEmployee;
		}

		EDEmployeeImpl edEmployeeImpl = new EDEmployeeImpl();

		edEmployeeImpl.setNew(edEmployee.isNew());
		edEmployeeImpl.setPrimaryKey(edEmployee.getPrimaryKey());

		edEmployeeImpl.setUuid(edEmployee.getUuid());
		edEmployeeImpl.setId(edEmployee.getId());
		edEmployeeImpl.setCreatedDate(edEmployee.getCreatedDate());
		edEmployeeImpl.setModifiedDate(edEmployee.getModifiedDate());
		edEmployeeImpl.setTitle(edEmployee.getTitle());
		edEmployeeImpl.setName(edEmployee.getName());
		edEmployeeImpl.setBirthday(edEmployee.getBirthday());
		edEmployeeImpl.setHomeSide(edEmployee.getHomeSide());
		edEmployeeImpl.setFamily(edEmployee.getFamily());
		edEmployeeImpl.setRace(edEmployee.getRace());
		edEmployeeImpl.setHome(edEmployee.getHome());
		edEmployeeImpl.setHomePhone(edEmployee.getHomePhone());
		edEmployeeImpl.setWorkPhone(edEmployee.getWorkPhone());
		edEmployeeImpl.setMobilePhone(edEmployee.getMobilePhone());
		edEmployeeImpl.setEmail(edEmployee.getEmail());
		edEmployeeImpl.setDepartmentId(edEmployee.getDepartmentId());
		edEmployeeImpl.setMajorLevel(edEmployee.getMajorLevel());
		edEmployeeImpl.setPhilosophism(edEmployee.getPhilosophism());
		edEmployeeImpl.setForeignLanguage(edEmployee.getForeignLanguage());
		edEmployeeImpl.setJoinDate(edEmployee.getJoinDate());
		edEmployeeImpl.setImage(edEmployee.getImage());
		edEmployeeImpl.setIsShowTree(edEmployee.isIsShowTree());
		edEmployeeImpl.setOtherInfo(edEmployee.getOtherInfo());
		edEmployeeImpl.setCompanyId(edEmployee.getCompanyId());
		edEmployeeImpl.setGroupId(edEmployee.getGroupId());
		edEmployeeImpl.setUserId(edEmployee.getUserId());
		edEmployeeImpl.setLanguageId(edEmployee.getLanguageId());
		edEmployeeImpl.setDisplayOrder(edEmployee.getDisplayOrder());
		edEmployeeImpl.setSex(edEmployee.getSex());
		edEmployeeImpl.setStatus(edEmployee.getStatus());
		edEmployeeImpl.setShow(edEmployee.getShow());

		return edEmployeeImpl;
	}

	/**
	 * Returns the e d employee with the primary key or throws a
	 * {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 * 
	 * @param primaryKey
	 *            the primary key of the e d employee
	 * @return the e d employee
	 * @throws com.liferay.portal.NoSuchModelException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	@Override
	public EDEmployee findByPrimaryKey(Serializable primaryKey)
			throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long) primaryKey).longValue());
	}

	/**
	 * Returns the e d employee with the primary key or throws a
	 * {@link com.vportal.portlet.edirectory.NoSuchEDEmployeeException} if it
	 * could not be found.
	 * 
	 * @param id
	 *            the primary key of the e d employee
	 * @return the e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByPrimaryKey(long id)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = fetchByPrimaryKey(id);

		if (edEmployee == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchEDEmployeeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
		}

		return edEmployee;
	}

	/**
	 * Returns the e d employee with the primary key or returns
	 * <code>null</code> if it could not be found.
	 * 
	 * @param primaryKey
	 *            the primary key of the e d employee
	 * @return the e d employee, or <code>null</code> if a e d employee with the
	 *         primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	@Override
	public EDEmployee fetchByPrimaryKey(Serializable primaryKey)
			throws SystemException {
		return fetchByPrimaryKey(((Long) primaryKey).longValue());
	}

	/**
	 * Returns the e d employee with the primary key or returns
	 * <code>null</code> if it could not be found.
	 * 
	 * @param id
	 *            the primary key of the e d employee
	 * @return the e d employee, or <code>null</code> if a e d employee with the
	 *         primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee fetchByPrimaryKey(long id) throws SystemException {
		EDEmployee edEmployee = (EDEmployee) EntityCacheUtil.getResult(
				EDEmployeeModelImpl.ENTITY_CACHE_ENABLED, EDEmployeeImpl.class,
				id);

		if (edEmployee == _nullEDEmployee) {
			return null;
		}

		if (edEmployee == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				edEmployee = (EDEmployee) session.get(EDEmployeeImpl.class,
						Long.valueOf(id));
			} catch (Exception e) {
				hasException = true;

				throw processException(e);
			} finally {
				if (edEmployee != null) {
					cacheResult(edEmployee);
				} else if (!hasException) {
					EntityCacheUtil.putResult(
							EDEmployeeModelImpl.ENTITY_CACHE_ENABLED,
							EDEmployeeImpl.class, id, _nullEDEmployee);
				}

				closeSession(session);
			}
		}

		return edEmployee;
	}

	/**
	 * Returns all the e d employees where uuid = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @return the matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d employees where uuid = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param uuid
	 *            the uuid
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByUuid(String uuid, int start, int end)
			throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d employees where uuid = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param uuid
	 *            the uuid
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByUuid(String uuid, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						3 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			} else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				} else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			else {
				query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
						start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e d employee in the ordered set where uuid = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param uuid
	 *            the uuid
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByUuid_First(String uuid,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		List<EDEmployee> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d employee in the ordered set where uuid = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param uuid
	 *            the uuid
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByUuid_Last(String uuid,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		int count = countByUuid(uuid);

		List<EDEmployee> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d employees before and after the current e d employee in
	 * the ordered set where uuid = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param id
	 *            the primary key of the current e d employee
	 * @param uuid
	 *            the uuid
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee[] findByUuid_PrevAndNext(long id, String uuid,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDEmployee[] array = new EDEmployeeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, edEmployee, uuid,
					orderByComparator, true);

			array[1] = edEmployee;

			array[2] = getByUuid_PrevAndNext(session, edEmployee, uuid,
					orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected EDEmployee getByUuid_PrevAndNext(Session session,
			EDEmployee edEmployee, String uuid,
			OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		} else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			} else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(edEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns the e d employee where uuid = &#63; and groupId = &#63; or throws
	 * a {@link com.vportal.portlet.edirectory.NoSuchEDEmployeeException} if it
	 * could not be found.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @return the matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByUUID_G(String uuid, long groupId)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = fetchByUUID_G(uuid, groupId);

		if (edEmployee == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEDEmployeeException(msg.toString());
		}

		return edEmployee;
	}

	/**
	 * Returns the e d employee where uuid = &#63; and groupId = &#63; or
	 * returns <code>null</code> if it could not be found. Uses the finder
	 * cache.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @return the matching e d employee, or <code>null</code> if a matching e d
	 *         employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee fetchByUUID_G(String uuid, long groupId)
			throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the e d employee where uuid = &#63; and groupId = &#63; or
	 * returns <code>null</code> if it could not be found, optionally using the
	 * finder cache.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @param retrieveFromCache
	 *            whether to use the finder cache
	 * @return the matching e d employee, or <code>null</code> if a matching e d
	 *         employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee fetchByUUID_G(String uuid, long groupId,
			boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			} else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				} else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<EDEmployee> list = q.list();

				result = list;

				EDEmployee edEmployee = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, list);
				} else {
					edEmployee = list.get(0);

					cacheResult(edEmployee);

					if ((edEmployee.getUuid() == null)
							|| !edEmployee.getUuid().equals(uuid)
							|| (edEmployee.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
								finderArgs, edEmployee);
					}
				}

				return edEmployee;
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs);
				}

				closeSession(session);
			}
		} else {
			if (result instanceof List<?>) {
				return null;
			} else {
				return (EDEmployee) result;
			}
		}
	}

	/**
	 * Returns the e d employee where departmentId = &#63; and id = &#63; or
	 * throws a {@link com.vportal.portlet.edirectory.NoSuchEDEmployeeException}
	 * if it could not be found.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param id
	 *            the ID
	 * @return the matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByDepartment_Id(long departmentId, long id)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = fetchByDepartment_Id(departmentId, id);

		if (edEmployee == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(", id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEDEmployeeException(msg.toString());
		}

		return edEmployee;
	}

	/**
	 * Returns the e d employee where departmentId = &#63; and id = &#63; or
	 * returns <code>null</code> if it could not be found. Uses the finder
	 * cache.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param id
	 *            the ID
	 * @return the matching e d employee, or <code>null</code> if a matching e d
	 *         employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee fetchByDepartment_Id(long departmentId, long id)
			throws SystemException {
		return fetchByDepartment_Id(departmentId, id, true);
	}

	/**
	 * Returns the e d employee where departmentId = &#63; and id = &#63; or
	 * returns <code>null</code> if it could not be found, optionally using the
	 * finder cache.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param id
	 *            the ID
	 * @param retrieveFromCache
	 *            whether to use the finder cache
	 * @return the matching e d employee, or <code>null</code> if a matching e d
	 *         employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee fetchByDepartment_Id(long departmentId, long id,
			boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(
					FINDER_PATH_FETCH_BY_DEPARTMENT_ID, finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENT_ID_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENT_ID_ID_2);

			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(id);

				List<EDEmployee> list = q.list();

				result = list;

				EDEmployee edEmployee = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(
							FINDER_PATH_FETCH_BY_DEPARTMENT_ID, finderArgs,
							list);
				} else {
					edEmployee = list.get(0);

					cacheResult(edEmployee);

					if ((edEmployee.getDepartmentId() != departmentId)
							|| (edEmployee.getId() != id)) {
						FinderCacheUtil.putResult(
								FINDER_PATH_FETCH_BY_DEPARTMENT_ID, finderArgs,
								edEmployee);
					}
				}

				return edEmployee;
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (result == null) {
					FinderCacheUtil.removeResult(
							FINDER_PATH_FETCH_BY_DEPARTMENT_ID, finderArgs);
				}

				closeSession(session);
			}
		} else {
			if (result instanceof List<?>) {
				return null;
			} else {
				return (EDEmployee) result;
			}
		}
	}

	/**
	 * Returns all the e d employees where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @return the matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);
	}

	/**
	 * Returns a range of all the e d employees where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByGroupId(long groupId, int start, int end)
			throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d employees where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByGroupId(long groupId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						3 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			else {
				query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
						start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e d employee in the ordered set where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByGroupId_First(long groupId,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		List<EDEmployee> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d employee in the ordered set where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByGroupId_Last(long groupId,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		int count = countByGroupId(groupId);

		List<EDEmployee> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d employees before and after the current e d employee in
	 * the ordered set where groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param id
	 *            the primary key of the current e d employee
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee[] findByGroupId_PrevAndNext(long id, long groupId,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDEmployee[] array = new EDEmployeeImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, edEmployee, groupId,
					orderByComparator, true);

			array[1] = edEmployee;

			array[2] = getByGroupId_PrevAndNext(session, edEmployee, groupId,
					orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected EDEmployee getByGroupId_PrevAndNext(Session session,
			EDEmployee edEmployee, long groupId,
			OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(edEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns all the e d employees where departmentId = &#63; and groupId =
	 * &#63; and status = &#63;.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param status
	 *            the status
	 * @return the matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId_Status(long departmentId,
			long groupId, long status) throws SystemException {
		return findByDepartmentId_Status(departmentId, groupId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d employees where departmentId = &#63; and
	 * groupId = &#63; and status = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param status
	 *            the status
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId_Status(long departmentId,
			long groupId, long status, int start, int end)
			throws SystemException {
		return findByDepartmentId_Status(departmentId, groupId, status, start,
				end, null);
	}

	/**
	 * Returns an ordered range of all the e d employees where departmentId =
	 * &#63; and groupId = &#63; and status = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param status
	 *            the status
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId_Status(long departmentId,
			long groupId, long status, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_STATUS;
			finderArgs = new Object[] { departmentId, groupId, status };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID_STATUS;
			finderArgs = new Object[] { departmentId, groupId, status,

			start, end, orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						5 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			else {
				query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(groupId);

				qPos.add(status);

				list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
						start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e d employee in the ordered set where departmentId =
	 * &#63; and groupId = &#63; and status = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param status
	 *            the status
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByDepartmentId_Status_First(long departmentId,
			long groupId, long status, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		List<EDEmployee> list = findByDepartmentId_Status(departmentId,
				groupId, status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d employee in the ordered set where departmentId =
	 * &#63; and groupId = &#63; and status = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param status
	 *            the status
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByDepartmentId_Status_Last(long departmentId,
			long groupId, long status, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		int count = countByDepartmentId_Status(departmentId, groupId, status);

		List<EDEmployee> list = findByDepartmentId_Status(departmentId,
				groupId, status, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d employees before and after the current e d employee in
	 * the ordered set where departmentId = &#63; and groupId = &#63; and status
	 * = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param id
	 *            the primary key of the current e d employee
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param status
	 *            the status
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee[] findByDepartmentId_Status_PrevAndNext(long id,
			long departmentId, long groupId, long status,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDEmployee[] array = new EDEmployeeImpl[3];

			array[0] = getByDepartmentId_Status_PrevAndNext(session,
					edEmployee, departmentId, groupId, status,
					orderByComparator, true);

			array[1] = edEmployee;

			array[2] = getByDepartmentId_Status_PrevAndNext(session,
					edEmployee, departmentId, groupId, status,
					orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected EDEmployee getByDepartmentId_Status_PrevAndNext(Session session,
			EDEmployee edEmployee, long departmentId, long groupId,
			long status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_GROUPID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(edEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns all the e d employees where departmentId = &#63;.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @return the matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId(long departmentId)
			throws SystemException {
		return findByDepartmentId(departmentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d employees where departmentId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId(long departmentId, int start,
			int end) throws SystemException {
		return findByDepartmentId(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d employees where departmentId =
	 * &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId(long departmentId, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID;
			finderArgs = new Object[] { departmentId };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID;
			finderArgs = new Object[] { departmentId,

			start, end, orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						3 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			else {
				query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
						start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e d employee in the ordered set where departmentId =
	 * &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByDepartmentId_First(long departmentId,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		List<EDEmployee> list = findByDepartmentId(departmentId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d employee in the ordered set where departmentId =
	 * &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByDepartmentId_Last(long departmentId,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		int count = countByDepartmentId(departmentId);

		List<EDEmployee> list = findByDepartmentId(departmentId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d employees before and after the current e d employee in
	 * the ordered set where departmentId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param id
	 *            the primary key of the current e d employee
	 * @param departmentId
	 *            the department ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee[] findByDepartmentId_PrevAndNext(long id,
			long departmentId, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDEmployee[] array = new EDEmployeeImpl[3];

			array[0] = getByDepartmentId_PrevAndNext(session, edEmployee,
					departmentId, orderByComparator, true);

			array[1] = edEmployee;

			array[2] = getByDepartmentId_PrevAndNext(session, edEmployee,
					departmentId, orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected EDEmployee getByDepartmentId_PrevAndNext(Session session,
			EDEmployee edEmployee, long departmentId,
			OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(edEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns all the e d employees where isShowTree = &#63;.
	 * 
	 * @param isShowTree
	 *            the is show tree
	 * @return the matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByIsShowed(boolean isShowTree)
			throws SystemException {
		return findByIsShowed(isShowTree, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null);
	}

	/**
	 * Returns a range of all the e d employees where isShowTree = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param isShowTree
	 *            the is show tree
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByIsShowed(boolean isShowTree, int start,
			int end) throws SystemException {
		return findByIsShowed(isShowTree, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d employees where isShowTree =
	 * &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param isShowTree
	 *            the is show tree
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByIsShowed(boolean isShowTree, int start,
			int end, OrderByComparator orderByComparator)
			throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSHOWED;
			finderArgs = new Object[] { isShowTree };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSHOWED;
			finderArgs = new Object[] { isShowTree, start, end,
					orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						3 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_ISSHOWED_ISSHOWTREE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			else {
				query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isShowTree);

				list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
						start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e d employee in the ordered set where isShowTree =
	 * &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param isShowTree
	 *            the is show tree
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByIsShowed_First(boolean isShowTree,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		List<EDEmployee> list = findByIsShowed(isShowTree, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("isShowTree=");
			msg.append(isShowTree);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d employee in the ordered set where isShowTree =
	 * &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param isShowTree
	 *            the is show tree
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByIsShowed_Last(boolean isShowTree,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		int count = countByIsShowed(isShowTree);

		List<EDEmployee> list = findByIsShowed(isShowTree, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("isShowTree=");
			msg.append(isShowTree);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d employees before and after the current e d employee in
	 * the ordered set where isShowTree = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param id
	 *            the primary key of the current e d employee
	 * @param isShowTree
	 *            the is show tree
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee[] findByIsShowed_PrevAndNext(long id, boolean isShowTree,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDEmployee[] array = new EDEmployeeImpl[3];

			array[0] = getByIsShowed_PrevAndNext(session, edEmployee,
					isShowTree, orderByComparator, true);

			array[1] = edEmployee;

			array[2] = getByIsShowed_PrevAndNext(session, edEmployee,
					isShowTree, orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected EDEmployee getByIsShowed_PrevAndNext(Session session,
			EDEmployee edEmployee, boolean isShowTree,
			OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_ISSHOWED_ISSHOWTREE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isShowTree);

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(edEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns all the e d employees where groupId = &#63; and languageId =
	 * &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @return the matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByG_L(long groupId, String languageId)
			throws SystemException {
		return findByG_L(groupId, languageId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d employees where groupId = &#63; and
	 * languageId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByG_L(long groupId, String languageId,
			int start, int end) throws SystemException {
		return findByG_L(groupId, languageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d employees where groupId = &#63;
	 * and languageId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByG_L(long groupId, String languageId,
			int start, int end, OrderByComparator orderByComparator)
			throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L;
			finderArgs = new Object[] { groupId, languageId };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L;
			finderArgs = new Object[] { groupId, languageId,

			start, end, orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						4 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGEID_1);
			} else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_LANGUAGEID_3);
				} else {
					query.append(_FINDER_COLUMN_G_L_LANGUAGEID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			else {
				query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (languageId != null) {
					qPos.add(languageId);
				}

				list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
						start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e d employee in the ordered set where groupId = &#63;
	 * and languageId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByG_L_First(long groupId, String languageId,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		List<EDEmployee> list = findByG_L(groupId, languageId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d employee in the ordered set where groupId = &#63;
	 * and languageId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByG_L_Last(long groupId, String languageId,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		int count = countByG_L(groupId, languageId);

		List<EDEmployee> list = findByG_L(groupId, languageId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d employees before and after the current e d employee in
	 * the ordered set where groupId = &#63; and languageId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param id
	 *            the primary key of the current e d employee
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee[] findByG_L_PrevAndNext(long id, long groupId,
			String languageId, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDEmployee[] array = new EDEmployeeImpl[3];

			array[0] = getByG_L_PrevAndNext(session, edEmployee, groupId,
					languageId, orderByComparator, true);

			array[1] = edEmployee;

			array[2] = getByG_L_PrevAndNext(session, edEmployee, groupId,
					languageId, orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected EDEmployee getByG_L_PrevAndNext(Session session,
			EDEmployee edEmployee, long groupId, String languageId,
			OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_L_GROUPID_2);

		if (languageId == null) {
			query.append(_FINDER_COLUMN_G_L_LANGUAGEID_1);
		} else {
			if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGEID_3);
			} else {
				query.append(_FINDER_COLUMN_G_L_LANGUAGEID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (languageId != null) {
			qPos.add(languageId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(edEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns all the e d employees where groupId = &#63; and languageId =
	 * &#63; and isShowTree = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param isShowTree
	 *            the is show tree
	 * @return the matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByG_L_I(long groupId, String languageId,
			boolean isShowTree) throws SystemException {
		return findByG_L_I(groupId, languageId, isShowTree, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d employees where groupId = &#63; and
	 * languageId = &#63; and isShowTree = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param isShowTree
	 *            the is show tree
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByG_L_I(long groupId, String languageId,
			boolean isShowTree, int start, int end) throws SystemException {
		return findByG_L_I(groupId, languageId, isShowTree, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d employees where groupId = &#63;
	 * and languageId = &#63; and isShowTree = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param isShowTree
	 *            the is show tree
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByG_L_I(long groupId, String languageId,
			boolean isShowTree, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_I;
			finderArgs = new Object[] { groupId, languageId, isShowTree };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_I;
			finderArgs = new Object[] { groupId, languageId, isShowTree,

			start, end, orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						5 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_L_I_GROUPID_2);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_1);
			} else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_3);
				} else {
					query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_G_L_I_ISSHOWTREE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			else {
				query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(isShowTree);

				list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
						start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e d employee in the ordered set where groupId = &#63;
	 * and languageId = &#63; and isShowTree = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param isShowTree
	 *            the is show tree
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByG_L_I_First(long groupId, String languageId,
			boolean isShowTree, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		List<EDEmployee> list = findByG_L_I(groupId, languageId, isShowTree, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(", isShowTree=");
			msg.append(isShowTree);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d employee in the ordered set where groupId = &#63;
	 * and languageId = &#63; and isShowTree = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param isShowTree
	 *            the is show tree
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByG_L_I_Last(long groupId, String languageId,
			boolean isShowTree, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		int count = countByG_L_I(groupId, languageId, isShowTree);

		List<EDEmployee> list = findByG_L_I(groupId, languageId, isShowTree,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", languageId=");
			msg.append(languageId);

			msg.append(", isShowTree=");
			msg.append(isShowTree);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d employees before and after the current e d employee in
	 * the ordered set where groupId = &#63; and languageId = &#63; and
	 * isShowTree = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param id
	 *            the primary key of the current e d employee
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param isShowTree
	 *            the is show tree
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee[] findByG_L_I_PrevAndNext(long id, long groupId,
			String languageId, boolean isShowTree,
			OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDEmployee[] array = new EDEmployeeImpl[3];

			array[0] = getByG_L_I_PrevAndNext(session, edEmployee, groupId,
					languageId, isShowTree, orderByComparator, true);

			array[1] = edEmployee;

			array[2] = getByG_L_I_PrevAndNext(session, edEmployee, groupId,
					languageId, isShowTree, orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected EDEmployee getByG_L_I_PrevAndNext(Session session,
			EDEmployee edEmployee, long groupId, String languageId,
			boolean isShowTree, OrderByComparator orderByComparator,
			boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_G_L_I_GROUPID_2);

		if (languageId == null) {
			query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_1);
		} else {
			if (languageId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_3);
			} else {
				query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_2);
			}
		}

		query.append(_FINDER_COLUMN_G_L_I_ISSHOWTREE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (languageId != null) {
			qPos.add(languageId);
		}

		qPos.add(isShowTree);

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(edEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns the e d employee where id = &#63; and groupId = &#63; or throws a
	 * {@link com.vportal.portlet.edirectory.NoSuchEDEmployeeException} if it
	 * could not be found.
	 * 
	 * @param id
	 *            the ID
	 * @param groupId
	 *            the group ID
	 * @return the matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByE_G(long id, long groupId)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = fetchByE_G(id, groupId);

		if (edEmployee == null) {
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

			throw new NoSuchEDEmployeeException(msg.toString());
		}

		return edEmployee;
	}

	/**
	 * Returns the e d employee where id = &#63; and groupId = &#63; or returns
	 * <code>null</code> if it could not be found. Uses the finder cache.
	 * 
	 * @param id
	 *            the ID
	 * @param groupId
	 *            the group ID
	 * @return the matching e d employee, or <code>null</code> if a matching e d
	 *         employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee fetchByE_G(long id, long groupId) throws SystemException {
		return fetchByE_G(id, groupId, true);
	}

	/**
	 * Returns the e d employee where id = &#63; and groupId = &#63; or returns
	 * <code>null</code> if it could not be found, optionally using the finder
	 * cache.
	 * 
	 * @param id
	 *            the ID
	 * @param groupId
	 *            the group ID
	 * @param retrieveFromCache
	 *            whether to use the finder cache
	 * @return the matching e d employee, or <code>null</code> if a matching e d
	 *         employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee fetchByE_G(long id, long groupId,
			boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { id, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_E_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_E_G_ID_2);

			query.append(_FINDER_COLUMN_E_G_GROUPID_2);

			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				qPos.add(groupId);

				List<EDEmployee> list = q.list();

				result = list;

				EDEmployee edEmployee = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_G,
							finderArgs, list);
				} else {
					edEmployee = list.get(0);

					cacheResult(edEmployee);

					if ((edEmployee.getId() != id)
							|| (edEmployee.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_G,
								finderArgs, edEmployee);
					}
				}

				return edEmployee;
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_E_G,
							finderArgs);
				}

				closeSession(session);
			}
		} else {
			if (result instanceof List<?>) {
				return null;
			} else {
				return (EDEmployee) result;
			}
		}
	}

	/**
	 * Returns all the e d employees where departmentId = &#63; and groupId =
	 * &#63;.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @return the matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId_GroupId(long departmentId,
			long groupId) throws SystemException {
		return findByDepartmentId_GroupId(departmentId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d employees where departmentId = &#63; and
	 * groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId_GroupId(long departmentId,
			long groupId, int start, int end) throws SystemException {
		return findByDepartmentId_GroupId(departmentId, groupId, start, end,
				null);
	}

	/**
	 * Returns an ordered range of all the e d employees where departmentId =
	 * &#63; and groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findByDepartmentId_GroupId(long departmentId,
			long groupId, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID_GROUPID;
			finderArgs = new Object[] { departmentId, groupId };
		} else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID_GROUPID;
			finderArgs = new Object[] { departmentId, groupId,

			start, end, orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						4 + (orderByComparator.getOrderByFields().length * 3));
			} else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_GROUPID_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTID_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
			}

			else {
				query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(groupId);

				list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
						start, end);
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first e d employee in the ordered set where departmentId =
	 * &#63; and groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the first matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByDepartmentId_GroupId_First(long departmentId,
			long groupId, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		List<EDEmployee> list = findByDepartmentId_GroupId(departmentId,
				groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d employee in the ordered set where departmentId =
	 * &#63; and groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the last matching e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a matching e d employee could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee findByDepartmentId_GroupId_Last(long departmentId,
			long groupId, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		int count = countByDepartmentId_GroupId(departmentId, groupId);

		List<EDEmployee> list = findByDepartmentId_GroupId(departmentId,
				groupId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDEmployeeException(msg.toString());
		} else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d employees before and after the current e d employee in
	 * the ordered set where departmentId = &#63; and groupId = &#63;.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param id
	 *            the primary key of the current e d employee
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param orderByComparator
	 *            the comparator to order the set by (optionally
	 *            <code>null</code>)
	 * @return the previous, current, and next e d employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDEmployeeException
	 *             if a e d employee with the primary key could not be found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public EDEmployee[] findByDepartmentId_GroupId_PrevAndNext(long id,
			long departmentId, long groupId, OrderByComparator orderByComparator)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDEmployee[] array = new EDEmployeeImpl[3];

			array[0] = getByDepartmentId_GroupId_PrevAndNext(session,
					edEmployee, departmentId, groupId, orderByComparator, true);

			array[1] = edEmployee;

			array[2] = getByDepartmentId_GroupId_PrevAndNext(session,
					edEmployee, departmentId, groupId, orderByComparator, false);

			return array;
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

	protected EDEmployee getByDepartmentId_GroupId_PrevAndNext(Session session,
			EDEmployee edEmployee, long departmentId, long groupId,
			OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 6));
		} else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTID_GROUPID_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTID_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator
					.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					} else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					} else {
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
					} else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				} else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					} else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(EDEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator
					.getOrderByConditionValues(edEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		} else {
			return null;
		}
	}

	/**
	 * Returns all the e d employees.
	 * 
	 * @return the e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d employees.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @return the range of e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d employees.
	 * 
	 * <p>
	 * Useful when paginating results. Returns a maximum of
	 * <code>end - start</code> instances. <code>start</code> and
	 * <code>end</code> are not primary keys, they are indexes in the result
	 * set. Thus, <code>0</code> refers to the first result in the set. Setting
	 * both <code>start</code> and <code>end</code> to
	 * {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return
	 * the full result set.
	 * </p>
	 * 
	 * @param start
	 *            the lower bound of the range of e d employees
	 * @param end
	 *            the upper bound of the range of e d employees (not inclusive)
	 * @param orderByComparator
	 *            the comparator to order the results by (optionally
	 *            <code>null</code>)
	 * @return the ordered range of e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<EDEmployee> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)
				&& (orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		} else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EDEmployee> list = (List<EDEmployee>) FinderCacheUtil.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
						2 + (orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EDEMPLOYEE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

				sql = query.toString();
			} else {
				sql = _SQL_SELECT_EDEMPLOYEE
						.concat(EDEmployeeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				} else {
					list = (List<EDEmployee>) QueryUtil.list(q, getDialect(),
							start, end);
				}
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				} else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the e d employees where uuid = &#63; from the database.
	 * 
	 * @param uuid
	 *            the uuid
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (EDEmployee edEmployee : findByUuid(uuid)) {
			remove(edEmployee);
		}
	}

	/**
	 * Removes the e d employee where uuid = &#63; and groupId = &#63; from the
	 * database.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByUUID_G(uuid, groupId);

		remove(edEmployee);
	}

	/**
	 * Removes the e d employee where departmentId = &#63; and id = &#63; from
	 * the database.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param id
	 *            the ID
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByDepartment_Id(long departmentId, long id)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByDepartment_Id(departmentId, id);

		remove(edEmployee);
	}

	/**
	 * Removes all the e d employees where groupId = &#63; from the database.
	 * 
	 * @param groupId
	 *            the group ID
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (EDEmployee edEmployee : findByGroupId(groupId)) {
			remove(edEmployee);
		}
	}

	/**
	 * Removes all the e d employees where departmentId = &#63; and groupId =
	 * &#63; and status = &#63; from the database.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param status
	 *            the status
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByDepartmentId_Status(long departmentId, long groupId,
			long status) throws SystemException {
		for (EDEmployee edEmployee : findByDepartmentId_Status(departmentId,
				groupId, status)) {
			remove(edEmployee);
		}
	}

	/**
	 * Removes all the e d employees where departmentId = &#63; from the
	 * database.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByDepartmentId(long departmentId) throws SystemException {
		for (EDEmployee edEmployee : findByDepartmentId(departmentId)) {
			remove(edEmployee);
		}
	}

	/**
	 * Removes all the e d employees where isShowTree = &#63; from the database.
	 * 
	 * @param isShowTree
	 *            the is show tree
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByIsShowed(boolean isShowTree) throws SystemException {
		for (EDEmployee edEmployee : findByIsShowed(isShowTree)) {
			remove(edEmployee);
		}
	}

	/**
	 * Removes all the e d employees where groupId = &#63; and languageId =
	 * &#63; from the database.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByG_L(long groupId, String languageId)
			throws SystemException {
		for (EDEmployee edEmployee : findByG_L(groupId, languageId)) {
			remove(edEmployee);
		}
	}

	/**
	 * Removes all the e d employees where groupId = &#63; and languageId =
	 * &#63; and isShowTree = &#63; from the database.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param isShowTree
	 *            the is show tree
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByG_L_I(long groupId, String languageId,
			boolean isShowTree) throws SystemException {
		for (EDEmployee edEmployee : findByG_L_I(groupId, languageId,
				isShowTree)) {
			remove(edEmployee);
		}
	}

	/**
	 * Removes the e d employee where id = &#63; and groupId = &#63; from the
	 * database.
	 * 
	 * @param id
	 *            the ID
	 * @param groupId
	 *            the group ID
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByE_G(long id, long groupId)
			throws NoSuchEDEmployeeException, SystemException {
		EDEmployee edEmployee = findByE_G(id, groupId);

		remove(edEmployee);
	}

	/**
	 * Removes all the e d employees where departmentId = &#63; and groupId =
	 * &#63; from the database.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeByDepartmentId_GroupId(long departmentId, long groupId)
			throws SystemException {
		for (EDEmployee edEmployee : findByDepartmentId_GroupId(departmentId,
				groupId)) {
			remove(edEmployee);
		}
	}

	/**
	 * Removes all the e d employees from the database.
	 * 
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EDEmployee edEmployee : findAll()) {
			remove(edEmployee);
		}
	}

	/**
	 * Returns the number of e d employees where uuid = &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_UUID, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			} else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				} else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees where uuid = &#63; and groupId =
	 * &#63;.
	 * 
	 * @param uuid
	 *            the uuid
	 * @param groupId
	 *            the group ID
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_UUID_G, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			} else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				} else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees where departmentId = &#63; and id =
	 * &#63;.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param id
	 *            the ID
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByDepartment_Id(long departmentId, long id)
			throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, id };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_DEPARTMENT_ID, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENT_ID_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENT_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(id);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENT_ID,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees where groupId = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_GROUPID, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
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
	 * Returns the number of e d employees where departmentId = &#63; and
	 * groupId = &#63; and status = &#63;.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @param status
	 *            the status
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByDepartmentId_Status(long departmentId, long groupId,
			long status) throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, groupId, status };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_DEPARTMENTID_STATUS, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_GROUPID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTID_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(
						FINDER_PATH_COUNT_BY_DEPARTMENTID_STATUS, finderArgs,
						count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees where departmentId = &#63;.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByDepartmentId(long departmentId) throws SystemException {
		Object[] finderArgs = new Object[] { departmentId };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_DEPARTMENTID, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTID,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees where isShowTree = &#63;.
	 * 
	 * @param isShowTree
	 *            the is show tree
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByIsShowed(boolean isShowTree) throws SystemException {
		Object[] finderArgs = new Object[] { isShowTree };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_ISSHOWED, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_ISSHOWED_ISSHOWTREE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isShowTree);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISSHOWED,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees where groupId = &#63; and languageId
	 * = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByG_L(long groupId, String languageId)
			throws SystemException {
		Object[] finderArgs = new Object[] { groupId, languageId };

		Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGEID_1);
			} else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_LANGUAGEID_3);
				} else {
					query.append(_FINDER_COLUMN_G_L_LANGUAGEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (languageId != null) {
					qPos.add(languageId);
				}

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
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
	 * Returns the number of e d employees where groupId = &#63; and languageId
	 * = &#63; and isShowTree = &#63;.
	 * 
	 * @param groupId
	 *            the group ID
	 * @param languageId
	 *            the language ID
	 * @param isShowTree
	 *            the is show tree
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByG_L_I(long groupId, String languageId, boolean isShowTree)
			throws SystemException {
		Object[] finderArgs = new Object[] { groupId, languageId, isShowTree };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_G_L_I, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_G_L_I_GROUPID_2);

			if (languageId == null) {
				query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_1);
			} else {
				if (languageId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_3);
				} else {
					query.append(_FINDER_COLUMN_G_L_I_LANGUAGEID_2);
				}
			}

			query.append(_FINDER_COLUMN_G_L_I_ISSHOWTREE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (languageId != null) {
					qPos.add(languageId);
				}

				qPos.add(isShowTree);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_L_I,
						finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees where id = &#63; and groupId = &#63;.
	 * 
	 * @param id
	 *            the ID
	 * @param groupId
	 *            the group ID
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByE_G(long id, long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { id, groupId };

		Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_E_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_E_G_ID_2);

			query.append(_FINDER_COLUMN_E_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				qPos.add(groupId);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E_G, finderArgs,
						count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees where departmentId = &#63; and
	 * groupId = &#63;.
	 * 
	 * @param departmentId
	 *            the department ID
	 * @param groupId
	 *            the group ID
	 * @return the number of matching e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countByDepartmentId_GroupId(long departmentId, long groupId)
			throws SystemException {
		Object[] finderArgs = new Object[] { departmentId, groupId };

		Long count = (Long) FinderCacheUtil.getResult(
				FINDER_PATH_COUNT_BY_DEPARTMENTID_GROUPID, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EDEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_GROUPID_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTID_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(groupId);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(
						FINDER_PATH_COUNT_BY_DEPARTMENTID_GROUPID, finderArgs,
						count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d employees.
	 * 
	 * @return the number of e d employees
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EDEMPLOYEE);

				count = (Long) q.uniqueResult();
			} catch (Exception e) {
				throw processException(e);
			} finally {
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
	 * Initializes the e d employee persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil
				.split(GetterUtil.getString(com.liferay.util.service.ServiceProps
						.get("value.object.listener.com.vportal.portlet.edirectory.model.EDEmployee")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EDEmployee>> listenersList = new ArrayList<ModelListener<EDEmployee>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList
							.add((ModelListener<EDEmployee>) InstanceFactory
									.newInstance(listenerClassName));
				}

				listeners = listenersList
						.toArray(new ModelListener[listenersList.size()]);
			} catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EDEmployeeImpl.class.getName());
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
	private static final String _SQL_SELECT_EDEMPLOYEE = "SELECT edEmployee FROM EDEmployee edEmployee";
	private static final String _SQL_SELECT_EDEMPLOYEE_WHERE = "SELECT edEmployee FROM EDEmployee edEmployee WHERE ";
	private static final String _SQL_COUNT_EDEMPLOYEE = "SELECT COUNT(edEmployee) FROM EDEmployee edEmployee";
	private static final String _SQL_COUNT_EDEMPLOYEE_WHERE = "SELECT COUNT(edEmployee) FROM EDEmployee edEmployee WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "edEmployee.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "edEmployee.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(edEmployee.uuid IS NULL OR edEmployee.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "edEmployee.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "edEmployee.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(edEmployee.uuid IS NULL OR edEmployee.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "edEmployee.groupId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENT_ID_DEPARTMENTID_2 = "edEmployee.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENT_ID_ID_2 = "edEmployee.id = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "edEmployee.groupId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTID_STATUS_DEPARTMENTID_2 = "edEmployee.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTID_STATUS_GROUPID_2 = "edEmployee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTID_STATUS_STATUS_2 = "edEmployee.status = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2 = "edEmployee.departmentId = ?";
	private static final String _FINDER_COLUMN_ISSHOWED_ISSHOWTREE_2 = "edEmployee.isShowTree = ?";
	private static final String _FINDER_COLUMN_G_L_GROUPID_2 = "edEmployee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_LANGUAGEID_1 = "edEmployee.languageId IS NULL";
	private static final String _FINDER_COLUMN_G_L_LANGUAGEID_2 = "edEmployee.languageId = ?";
	private static final String _FINDER_COLUMN_G_L_LANGUAGEID_3 = "(edEmployee.languageId IS NULL OR edEmployee.languageId = ?)";
	private static final String _FINDER_COLUMN_G_L_I_GROUPID_2 = "edEmployee.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_I_LANGUAGEID_1 = "edEmployee.languageId IS NULL AND ";
	private static final String _FINDER_COLUMN_G_L_I_LANGUAGEID_2 = "edEmployee.languageId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_I_LANGUAGEID_3 = "(edEmployee.languageId IS NULL OR edEmployee.languageId = ?) AND ";
	private static final String _FINDER_COLUMN_G_L_I_ISSHOWTREE_2 = "edEmployee.isShowTree = ?";
	private static final String _FINDER_COLUMN_E_G_ID_2 = "edEmployee.id = ? AND ";
	private static final String _FINDER_COLUMN_E_G_GROUPID_2 = "edEmployee.groupId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTID_GROUPID_DEPARTMENTID_2 = "edEmployee.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTID_GROUPID_GROUPID_2 = "edEmployee.groupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "edEmployee.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EDEmployee exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EDEmployee exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil
			.getBoolean(PropsUtil
					.get(PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil
			.getLog(EDEmployeePersistenceImpl.class);
	private static EDEmployee _nullEDEmployee = new EDEmployeeImpl() {
		@Override
		public Object clone() {
			return this;
		}

		@Override
		public CacheModel<EDEmployee> toCacheModel() {
			return _nullEDEmployeeCacheModel;
		}
	};

	private static CacheModel<EDEmployee> _nullEDEmployeeCacheModel = new CacheModel<EDEmployee>() {
		public EDEmployee toEntityModel() {
			return _nullEDEmployee;
		}
	};
}