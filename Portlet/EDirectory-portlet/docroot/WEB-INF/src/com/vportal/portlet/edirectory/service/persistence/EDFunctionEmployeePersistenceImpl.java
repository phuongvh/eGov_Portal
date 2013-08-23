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

import com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException;
import com.vportal.portlet.edirectory.model.EDFunctionEmployee;
import com.vportal.portlet.edirectory.model.impl.EDFunctionEmployeeImpl;
import com.vportal.portlet.edirectory.model.impl.EDFunctionEmployeeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e d function employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDFunctionEmployeePersistence
 * @see EDFunctionEmployeeUtil
 * @generated
 */
public class EDFunctionEmployeePersistenceImpl extends BasePersistenceImpl<EDFunctionEmployee>
	implements EDFunctionEmployeePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EDFunctionEmployeeUtil} to access the e d function employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EDFunctionEmployeeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EDFunctionEmployeeModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNCTIONID =
		new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFunctionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID =
		new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFunctionId",
			new String[] { Long.class.getName() },
			EDFunctionEmployeeModelImpl.FUNCTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FUNCTIONID = new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFunctionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID =
		new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] { Long.class.getName() },
			EDFunctionEmployeeModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the e d function employee in the entity cache if it is enabled.
	 *
	 * @param edFunctionEmployee the e d function employee
	 */
	public void cacheResult(EDFunctionEmployee edFunctionEmployee) {
		EntityCacheUtil.putResult(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class, edFunctionEmployee.getPrimaryKey(),
			edFunctionEmployee);

		edFunctionEmployee.resetOriginalValues();
	}

	/**
	 * Caches the e d function employees in the entity cache if it is enabled.
	 *
	 * @param edFunctionEmployees the e d function employees
	 */
	public void cacheResult(List<EDFunctionEmployee> edFunctionEmployees) {
		for (EDFunctionEmployee edFunctionEmployee : edFunctionEmployees) {
			if (EntityCacheUtil.getResult(
						EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
						EDFunctionEmployeeImpl.class,
						edFunctionEmployee.getPrimaryKey()) == null) {
				cacheResult(edFunctionEmployee);
			}
			else {
				edFunctionEmployee.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e d function employees.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EDFunctionEmployeeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EDFunctionEmployeeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e d function employee.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EDFunctionEmployee edFunctionEmployee) {
		EntityCacheUtil.removeResult(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class, edFunctionEmployee.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EDFunctionEmployee> edFunctionEmployees) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EDFunctionEmployee edFunctionEmployee : edFunctionEmployees) {
			EntityCacheUtil.removeResult(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
				EDFunctionEmployeeImpl.class, edFunctionEmployee.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e d function employee with the primary key. Does not add the e d function employee to the database.
	 *
	 * @param id the primary key for the new e d function employee
	 * @return the new e d function employee
	 */
	public EDFunctionEmployee create(long id) {
		EDFunctionEmployee edFunctionEmployee = new EDFunctionEmployeeImpl();

		edFunctionEmployee.setNew(true);
		edFunctionEmployee.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		edFunctionEmployee.setUuid(uuid);

		return edFunctionEmployee;
	}

	/**
	 * Removes the e d function employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e d function employee
	 * @return the e d function employee that was removed
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee remove(long id)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the e d function employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e d function employee
	 * @return the e d function employee that was removed
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDFunctionEmployee remove(Serializable primaryKey)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EDFunctionEmployee edFunctionEmployee = (EDFunctionEmployee)session.get(EDFunctionEmployeeImpl.class,
					primaryKey);

			if (edFunctionEmployee == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEDFunctionEmployeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(edFunctionEmployee);
		}
		catch (NoSuchEDFunctionEmployeeException nsee) {
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
	protected EDFunctionEmployee removeImpl(
		EDFunctionEmployee edFunctionEmployee) throws SystemException {
		edFunctionEmployee = toUnwrappedModel(edFunctionEmployee);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, edFunctionEmployee);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(edFunctionEmployee);

		return edFunctionEmployee;
	}

	@Override
	public EDFunctionEmployee updateImpl(
		com.vportal.portlet.edirectory.model.EDFunctionEmployee edFunctionEmployee,
		boolean merge) throws SystemException {
		edFunctionEmployee = toUnwrappedModel(edFunctionEmployee);

		boolean isNew = edFunctionEmployee.isNew();

		EDFunctionEmployeeModelImpl edFunctionEmployeeModelImpl = (EDFunctionEmployeeModelImpl)edFunctionEmployee;

		if (Validator.isNull(edFunctionEmployee.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			edFunctionEmployee.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, edFunctionEmployee, merge);

			edFunctionEmployee.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EDFunctionEmployeeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((edFunctionEmployeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						edFunctionEmployeeModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { edFunctionEmployeeModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((edFunctionEmployeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edFunctionEmployeeModelImpl.getOriginalFunctionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNCTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID,
					args);

				args = new Object[] {
						Long.valueOf(edFunctionEmployeeModelImpl.getFunctionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNCTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID,
					args);
			}

			if ((edFunctionEmployeeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edFunctionEmployeeModelImpl.getOriginalEmployeeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);

				args = new Object[] {
						Long.valueOf(edFunctionEmployeeModelImpl.getEmployeeId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID,
					args);
			}
		}

		EntityCacheUtil.putResult(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionEmployeeImpl.class, edFunctionEmployee.getPrimaryKey(),
			edFunctionEmployee);

		return edFunctionEmployee;
	}

	protected EDFunctionEmployee toUnwrappedModel(
		EDFunctionEmployee edFunctionEmployee) {
		if (edFunctionEmployee instanceof EDFunctionEmployeeImpl) {
			return edFunctionEmployee;
		}

		EDFunctionEmployeeImpl edFunctionEmployeeImpl = new EDFunctionEmployeeImpl();

		edFunctionEmployeeImpl.setNew(edFunctionEmployee.isNew());
		edFunctionEmployeeImpl.setPrimaryKey(edFunctionEmployee.getPrimaryKey());

		edFunctionEmployeeImpl.setUuid(edFunctionEmployee.getUuid());
		edFunctionEmployeeImpl.setId(edFunctionEmployee.getId());
		edFunctionEmployeeImpl.setFunctionId(edFunctionEmployee.getFunctionId());
		edFunctionEmployeeImpl.setEmployeeId(edFunctionEmployee.getEmployeeId());

		return edFunctionEmployeeImpl;
	}

	/**
	 * Returns the e d function employee with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e d function employee
	 * @return the e d function employee
	 * @throws com.liferay.portal.NoSuchModelException if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDFunctionEmployee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the e d function employee with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException} if it could not be found.
	 *
	 * @param id the primary key of the e d function employee
	 * @return the e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee findByPrimaryKey(long id)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		EDFunctionEmployee edFunctionEmployee = fetchByPrimaryKey(id);

		if (edFunctionEmployee == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchEDFunctionEmployeeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return edFunctionEmployee;
	}

	/**
	 * Returns the e d function employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e d function employee
	 * @return the e d function employee, or <code>null</code> if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDFunctionEmployee fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the e d function employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e d function employee
	 * @return the e d function employee, or <code>null</code> if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee fetchByPrimaryKey(long id)
		throws SystemException {
		EDFunctionEmployee edFunctionEmployee = (EDFunctionEmployee)EntityCacheUtil.getResult(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
				EDFunctionEmployeeImpl.class, id);

		if (edFunctionEmployee == _nullEDFunctionEmployee) {
			return null;
		}

		if (edFunctionEmployee == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				edFunctionEmployee = (EDFunctionEmployee)session.get(EDFunctionEmployeeImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (edFunctionEmployee != null) {
					cacheResult(edFunctionEmployee);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EDFunctionEmployeeModelImpl.ENTITY_CACHE_ENABLED,
						EDFunctionEmployeeImpl.class, id,
						_nullEDFunctionEmployee);
				}

				closeSession(session);
			}
		}

		return edFunctionEmployee;
	}

	/**
	 * Returns all the e d function employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d function employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e d function employees
	 * @param end the upper bound of the range of e d function employees (not inclusive)
	 * @return the range of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d function employees where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of e d function employees
	 * @param end the upper bound of the range of e d function employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<EDFunctionEmployee> list = (List<EDFunctionEmployee>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDFUNCTIONEMPLOYEE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDFunctionEmployeeModelImpl.ORDER_BY_JPQL);
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

				list = (List<EDFunctionEmployee>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first e d function employee in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		List<EDFunctionEmployee> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionEmployeeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d function employee in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		int count = countByUuid(uuid);

		List<EDFunctionEmployee> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionEmployeeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d function employees before and after the current e d function employee in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d function employee
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		EDFunctionEmployee edFunctionEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDFunctionEmployee[] array = new EDFunctionEmployeeImpl[3];

			array[0] = getByUuid_PrevAndNext(session, edFunctionEmployee, uuid,
					orderByComparator, true);

			array[1] = edFunctionEmployee;

			array[2] = getByUuid_PrevAndNext(session, edFunctionEmployee, uuid,
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

	protected EDFunctionEmployee getByUuid_PrevAndNext(Session session,
		EDFunctionEmployee edFunctionEmployee, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDFUNCTIONEMPLOYEE_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(EDFunctionEmployeeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(edFunctionEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDFunctionEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d function employees where functionId = &#63;.
	 *
	 * @param functionId the function ID
	 * @return the matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByFunctionId(long functionId)
		throws SystemException {
		return findByFunctionId(functionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d function employees where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param functionId the function ID
	 * @param start the lower bound of the range of e d function employees
	 * @param end the upper bound of the range of e d function employees (not inclusive)
	 * @return the range of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByFunctionId(long functionId,
		int start, int end) throws SystemException {
		return findByFunctionId(functionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d function employees where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param functionId the function ID
	 * @param start the lower bound of the range of e d function employees
	 * @param end the upper bound of the range of e d function employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByFunctionId(long functionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID;
			finderArgs = new Object[] { functionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNCTIONID;
			finderArgs = new Object[] { functionId, start, end, orderByComparator };
		}

		List<EDFunctionEmployee> list = (List<EDFunctionEmployee>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDFUNCTIONEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_FUNCTIONID_FUNCTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDFunctionEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(functionId);

				list = (List<EDFunctionEmployee>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first e d function employee in the ordered set where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param functionId the function ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee findByFunctionId_First(long functionId,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		List<EDFunctionEmployee> list = findByFunctionId(functionId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("functionId=");
			msg.append(functionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionEmployeeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d function employee in the ordered set where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param functionId the function ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee findByFunctionId_Last(long functionId,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		int count = countByFunctionId(functionId);

		List<EDFunctionEmployee> list = findByFunctionId(functionId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("functionId=");
			msg.append(functionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionEmployeeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d function employees before and after the current e d function employee in the ordered set where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d function employee
	 * @param functionId the function ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee[] findByFunctionId_PrevAndNext(long id,
		long functionId, OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		EDFunctionEmployee edFunctionEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDFunctionEmployee[] array = new EDFunctionEmployeeImpl[3];

			array[0] = getByFunctionId_PrevAndNext(session, edFunctionEmployee,
					functionId, orderByComparator, true);

			array[1] = edFunctionEmployee;

			array[2] = getByFunctionId_PrevAndNext(session, edFunctionEmployee,
					functionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EDFunctionEmployee getByFunctionId_PrevAndNext(Session session,
		EDFunctionEmployee edFunctionEmployee, long functionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDFUNCTIONEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_FUNCTIONID_FUNCTIONID_2);

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
			query.append(EDFunctionEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(functionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edFunctionEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDFunctionEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d function employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByEmployeeId(long employeeId)
		throws SystemException {
		return findByEmployeeId(employeeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d function employees where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of e d function employees
	 * @param end the upper bound of the range of e d function employees (not inclusive)
	 * @return the range of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByEmployeeId(long employeeId,
		int start, int end) throws SystemException {
		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d function employees where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of e d function employees
	 * @param end the upper bound of the range of e d function employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findByEmployeeId(long employeeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEEID;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<EDFunctionEmployee> list = (List<EDFunctionEmployee>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDFUNCTIONEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDFunctionEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				list = (List<EDFunctionEmployee>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first e d function employee in the ordered set where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee findByEmployeeId_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		List<EDFunctionEmployee> list = findByEmployeeId(employeeId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionEmployeeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d function employee in the ordered set where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a matching e d function employee could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee findByEmployeeId_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		int count = countByEmployeeId(employeeId);

		List<EDFunctionEmployee> list = findByEmployeeId(employeeId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("employeeId=");
			msg.append(employeeId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionEmployeeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d function employees before and after the current e d function employee in the ordered set where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d function employee
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d function employee
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionEmployeeException if a e d function employee with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionEmployee[] findByEmployeeId_PrevAndNext(long id,
		long employeeId, OrderByComparator orderByComparator)
		throws NoSuchEDFunctionEmployeeException, SystemException {
		EDFunctionEmployee edFunctionEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDFunctionEmployee[] array = new EDFunctionEmployeeImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(session, edFunctionEmployee,
					employeeId, orderByComparator, true);

			array[1] = edFunctionEmployee;

			array[2] = getByEmployeeId_PrevAndNext(session, edFunctionEmployee,
					employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EDFunctionEmployee getByEmployeeId_PrevAndNext(Session session,
		EDFunctionEmployee edFunctionEmployee, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDFUNCTIONEMPLOYEE_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			query.append(EDFunctionEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edFunctionEmployee);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDFunctionEmployee> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d function employees.
	 *
	 * @return the e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d function employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e d function employees
	 * @param end the upper bound of the range of e d function employees (not inclusive)
	 * @return the range of e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d function employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e d function employees
	 * @param end the upper bound of the range of e d function employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionEmployee> findAll(int start, int end,
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

		List<EDFunctionEmployee> list = (List<EDFunctionEmployee>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EDFUNCTIONEMPLOYEE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EDFUNCTIONEMPLOYEE.concat(EDFunctionEmployeeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EDFunctionEmployee>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EDFunctionEmployee>)QueryUtil.list(q,
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
	 * Removes all the e d function employees where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (EDFunctionEmployee edFunctionEmployee : findByUuid(uuid)) {
			remove(edFunctionEmployee);
		}
	}

	/**
	 * Removes all the e d function employees where functionId = &#63; from the database.
	 *
	 * @param functionId the function ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByFunctionId(long functionId) throws SystemException {
		for (EDFunctionEmployee edFunctionEmployee : findByFunctionId(
				functionId)) {
			remove(edFunctionEmployee);
		}
	}

	/**
	 * Removes all the e d function employees where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmployeeId(long employeeId) throws SystemException {
		for (EDFunctionEmployee edFunctionEmployee : findByEmployeeId(
				employeeId)) {
			remove(edFunctionEmployee);
		}
	}

	/**
	 * Removes all the e d function employees from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EDFunctionEmployee edFunctionEmployee : findAll()) {
			remove(edFunctionEmployee);
		}
	}

	/**
	 * Returns the number of e d function employees where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDFUNCTIONEMPLOYEE_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
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

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
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
	 * Returns the number of e d function employees where functionId = &#63;.
	 *
	 * @param functionId the function ID
	 * @return the number of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFunctionId(long functionId) throws SystemException {
		Object[] finderArgs = new Object[] { functionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FUNCTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDFUNCTIONEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_FUNCTIONID_FUNCTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(functionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FUNCTIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d function employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmployeeId(long employeeId) throws SystemException {
		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDFUNCTIONEMPLOYEE_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of e d function employees.
	 *
	 * @return the number of e d function employees
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EDFUNCTIONEMPLOYEE);

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
	 * Initializes the e d function employee persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.edirectory.model.EDFunctionEmployee")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EDFunctionEmployee>> listenersList = new ArrayList<ModelListener<EDFunctionEmployee>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EDFunctionEmployee>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EDFunctionEmployeeImpl.class.getName());
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
	private static final String _SQL_SELECT_EDFUNCTIONEMPLOYEE = "SELECT edFunctionEmployee FROM EDFunctionEmployee edFunctionEmployee";
	private static final String _SQL_SELECT_EDFUNCTIONEMPLOYEE_WHERE = "SELECT edFunctionEmployee FROM EDFunctionEmployee edFunctionEmployee WHERE ";
	private static final String _SQL_COUNT_EDFUNCTIONEMPLOYEE = "SELECT COUNT(edFunctionEmployee) FROM EDFunctionEmployee edFunctionEmployee";
	private static final String _SQL_COUNT_EDFUNCTIONEMPLOYEE_WHERE = "SELECT COUNT(edFunctionEmployee) FROM EDFunctionEmployee edFunctionEmployee WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "edFunctionEmployee.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "edFunctionEmployee.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(edFunctionEmployee.uuid IS NULL OR edFunctionEmployee.uuid = ?)";
	private static final String _FINDER_COLUMN_FUNCTIONID_FUNCTIONID_2 = "edFunctionEmployee.functionId = ?";
	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 = "edFunctionEmployee.employeeId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "edFunctionEmployee.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EDFunctionEmployee exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EDFunctionEmployee exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EDFunctionEmployeePersistenceImpl.class);
	private static EDFunctionEmployee _nullEDFunctionEmployee = new EDFunctionEmployeeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EDFunctionEmployee> toCacheModel() {
				return _nullEDFunctionEmployeeCacheModel;
			}
		};

	private static CacheModel<EDFunctionEmployee> _nullEDFunctionEmployeeCacheModel =
		new CacheModel<EDFunctionEmployee>() {
			public EDFunctionEmployee toEntityModel() {
				return _nullEDFunctionEmployee;
			}
		};
}