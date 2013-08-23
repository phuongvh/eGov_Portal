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

import com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException;
import com.vportal.portlet.edirectory.model.EDFunctionDepartment;
import com.vportal.portlet.edirectory.model.impl.EDFunctionDepartmentImpl;
import com.vportal.portlet.edirectory.model.impl.EDFunctionDepartmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e d function department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author HOAN
 * @see EDFunctionDepartmentPersistence
 * @see EDFunctionDepartmentUtil
 * @generated
 */
public class EDFunctionDepartmentPersistenceImpl extends BasePersistenceImpl<EDFunctionDepartment>
	implements EDFunctionDepartmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EDFunctionDepartmentUtil} to access the e d function department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EDFunctionDepartmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FUNCTIONID =
		new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFunctionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID =
		new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFunctionId",
			new String[] { Long.class.getName() },
			EDFunctionDepartmentModelImpl.FUNCTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FUNCTIONID = new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFunctionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID =
		new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartmentId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID =
		new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartmentId",
			new String[] { Long.class.getName() },
			EDFunctionDepartmentModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTID = new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartmentId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the e d function department in the entity cache if it is enabled.
	 *
	 * @param edFunctionDepartment the e d function department
	 */
	public void cacheResult(EDFunctionDepartment edFunctionDepartment) {
		EntityCacheUtil.putResult(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class,
			edFunctionDepartment.getPrimaryKey(), edFunctionDepartment);

		edFunctionDepartment.resetOriginalValues();
	}

	/**
	 * Caches the e d function departments in the entity cache if it is enabled.
	 *
	 * @param edFunctionDepartments the e d function departments
	 */
	public void cacheResult(List<EDFunctionDepartment> edFunctionDepartments) {
		for (EDFunctionDepartment edFunctionDepartment : edFunctionDepartments) {
			if (EntityCacheUtil.getResult(
						EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						EDFunctionDepartmentImpl.class,
						edFunctionDepartment.getPrimaryKey()) == null) {
				cacheResult(edFunctionDepartment);
			}
			else {
				edFunctionDepartment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e d function departments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EDFunctionDepartmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EDFunctionDepartmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e d function department.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EDFunctionDepartment edFunctionDepartment) {
		EntityCacheUtil.removeResult(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class, edFunctionDepartment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EDFunctionDepartment> edFunctionDepartments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EDFunctionDepartment edFunctionDepartment : edFunctionDepartments) {
			EntityCacheUtil.removeResult(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				EDFunctionDepartmentImpl.class,
				edFunctionDepartment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e d function department with the primary key. Does not add the e d function department to the database.
	 *
	 * @param id the primary key for the new e d function department
	 * @return the new e d function department
	 */
	public EDFunctionDepartment create(long id) {
		EDFunctionDepartment edFunctionDepartment = new EDFunctionDepartmentImpl();

		edFunctionDepartment.setNew(true);
		edFunctionDepartment.setPrimaryKey(id);

		return edFunctionDepartment;
	}

	/**
	 * Removes the e d function department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e d function department
	 * @return the e d function department that was removed
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment remove(long id)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the e d function department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e d function department
	 * @return the e d function department that was removed
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDFunctionDepartment remove(Serializable primaryKey)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EDFunctionDepartment edFunctionDepartment = (EDFunctionDepartment)session.get(EDFunctionDepartmentImpl.class,
					primaryKey);

			if (edFunctionDepartment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEDFunctionDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(edFunctionDepartment);
		}
		catch (NoSuchEDFunctionDepartmentException nsee) {
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
	protected EDFunctionDepartment removeImpl(
		EDFunctionDepartment edFunctionDepartment) throws SystemException {
		edFunctionDepartment = toUnwrappedModel(edFunctionDepartment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, edFunctionDepartment);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(edFunctionDepartment);

		return edFunctionDepartment;
	}

	@Override
	public EDFunctionDepartment updateImpl(
		com.vportal.portlet.edirectory.model.EDFunctionDepartment edFunctionDepartment,
		boolean merge) throws SystemException {
		edFunctionDepartment = toUnwrappedModel(edFunctionDepartment);

		boolean isNew = edFunctionDepartment.isNew();

		EDFunctionDepartmentModelImpl edFunctionDepartmentModelImpl = (EDFunctionDepartmentModelImpl)edFunctionDepartment;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, edFunctionDepartment, merge);

			edFunctionDepartment.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EDFunctionDepartmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((edFunctionDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edFunctionDepartmentModelImpl.getOriginalFunctionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNCTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID,
					args);

				args = new Object[] {
						Long.valueOf(edFunctionDepartmentModelImpl.getFunctionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FUNCTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FUNCTIONID,
					args);
			}

			if ((edFunctionDepartmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(edFunctionDepartmentModelImpl.getOriginalDepartmentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID,
					args);

				args = new Object[] {
						Long.valueOf(edFunctionDepartmentModelImpl.getDepartmentId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
			EDFunctionDepartmentImpl.class,
			edFunctionDepartment.getPrimaryKey(), edFunctionDepartment);

		return edFunctionDepartment;
	}

	protected EDFunctionDepartment toUnwrappedModel(
		EDFunctionDepartment edFunctionDepartment) {
		if (edFunctionDepartment instanceof EDFunctionDepartmentImpl) {
			return edFunctionDepartment;
		}

		EDFunctionDepartmentImpl edFunctionDepartmentImpl = new EDFunctionDepartmentImpl();

		edFunctionDepartmentImpl.setNew(edFunctionDepartment.isNew());
		edFunctionDepartmentImpl.setPrimaryKey(edFunctionDepartment.getPrimaryKey());

		edFunctionDepartmentImpl.setId(edFunctionDepartment.getId());
		edFunctionDepartmentImpl.setFunctionId(edFunctionDepartment.getFunctionId());
		edFunctionDepartmentImpl.setDepartmentId(edFunctionDepartment.getDepartmentId());

		return edFunctionDepartmentImpl;
	}

	/**
	 * Returns the e d function department with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e d function department
	 * @return the e d function department
	 * @throws com.liferay.portal.NoSuchModelException if a e d function department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDFunctionDepartment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the e d function department with the primary key or throws a {@link com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException} if it could not be found.
	 *
	 * @param id the primary key of the e d function department
	 * @return the e d function department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment findByPrimaryKey(long id)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		EDFunctionDepartment edFunctionDepartment = fetchByPrimaryKey(id);

		if (edFunctionDepartment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchEDFunctionDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return edFunctionDepartment;
	}

	/**
	 * Returns the e d function department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e d function department
	 * @return the e d function department, or <code>null</code> if a e d function department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EDFunctionDepartment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the e d function department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e d function department
	 * @return the e d function department, or <code>null</code> if a e d function department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment fetchByPrimaryKey(long id)
		throws SystemException {
		EDFunctionDepartment edFunctionDepartment = (EDFunctionDepartment)EntityCacheUtil.getResult(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
				EDFunctionDepartmentImpl.class, id);

		if (edFunctionDepartment == _nullEDFunctionDepartment) {
			return null;
		}

		if (edFunctionDepartment == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				edFunctionDepartment = (EDFunctionDepartment)session.get(EDFunctionDepartmentImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (edFunctionDepartment != null) {
					cacheResult(edFunctionDepartment);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(EDFunctionDepartmentModelImpl.ENTITY_CACHE_ENABLED,
						EDFunctionDepartmentImpl.class, id,
						_nullEDFunctionDepartment);
				}

				closeSession(session);
			}
		}

		return edFunctionDepartment;
	}

	/**
	 * Returns all the e d function departments where functionId = &#63;.
	 *
	 * @param functionId the function ID
	 * @return the matching e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findByFunctionId(long functionId)
		throws SystemException {
		return findByFunctionId(functionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d function departments where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param functionId the function ID
	 * @param start the lower bound of the range of e d function departments
	 * @param end the upper bound of the range of e d function departments (not inclusive)
	 * @return the range of matching e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findByFunctionId(long functionId,
		int start, int end) throws SystemException {
		return findByFunctionId(functionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d function departments where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param functionId the function ID
	 * @param start the lower bound of the range of e d function departments
	 * @param end the upper bound of the range of e d function departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findByFunctionId(long functionId,
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

		List<EDFunctionDepartment> list = (List<EDFunctionDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDFUNCTIONDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_FUNCTIONID_FUNCTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDFunctionDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(functionId);

				list = (List<EDFunctionDepartment>)QueryUtil.list(q,
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
	 * Returns the first e d function department in the ordered set where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param functionId the function ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d function department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a matching e d function department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment findByFunctionId_First(long functionId,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		List<EDFunctionDepartment> list = findByFunctionId(functionId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("functionId=");
			msg.append(functionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d function department in the ordered set where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param functionId the function ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d function department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a matching e d function department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment findByFunctionId_Last(long functionId,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		int count = countByFunctionId(functionId);

		List<EDFunctionDepartment> list = findByFunctionId(functionId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("functionId=");
			msg.append(functionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d function departments before and after the current e d function department in the ordered set where functionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d function department
	 * @param functionId the function ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d function department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment[] findByFunctionId_PrevAndNext(long id,
		long functionId, OrderByComparator orderByComparator)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		EDFunctionDepartment edFunctionDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDFunctionDepartment[] array = new EDFunctionDepartmentImpl[3];

			array[0] = getByFunctionId_PrevAndNext(session,
					edFunctionDepartment, functionId, orderByComparator, true);

			array[1] = edFunctionDepartment;

			array[2] = getByFunctionId_PrevAndNext(session,
					edFunctionDepartment, functionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EDFunctionDepartment getByFunctionId_PrevAndNext(
		Session session, EDFunctionDepartment edFunctionDepartment,
		long functionId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDFUNCTIONDEPARTMENT_WHERE);

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
			query.append(EDFunctionDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(functionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edFunctionDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDFunctionDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d function departments where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findByDepartmentId(long departmentId)
		throws SystemException {
		return findByDepartmentId(departmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d function departments where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of e d function departments
	 * @param end the upper bound of the range of e d function departments (not inclusive)
	 * @return the range of matching e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findByDepartmentId(long departmentId,
		int start, int end) throws SystemException {
		return findByDepartmentId(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d function departments where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of e d function departments
	 * @param end the upper bound of the range of e d function departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findByDepartmentId(long departmentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID;
			finderArgs = new Object[] { departmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID;
			finderArgs = new Object[] {
					departmentId,
					
					start, end, orderByComparator
				};
		}

		List<EDFunctionDepartment> list = (List<EDFunctionDepartment>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_EDFUNCTIONDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EDFunctionDepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				list = (List<EDFunctionDepartment>)QueryUtil.list(q,
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
	 * Returns the first e d function department in the ordered set where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e d function department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a matching e d function department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment findByDepartmentId_First(long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		List<EDFunctionDepartment> list = findByDepartmentId(departmentId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last e d function department in the ordered set where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e d function department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a matching e d function department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment findByDepartmentId_Last(long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		int count = countByDepartmentId(departmentId);

		List<EDFunctionDepartment> list = findByDepartmentId(departmentId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("departmentId=");
			msg.append(departmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEDFunctionDepartmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the e d function departments before and after the current e d function department in the ordered set where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current e d function department
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e d function department
	 * @throws com.vportal.portlet.edirectory.NoSuchEDFunctionDepartmentException if a e d function department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public EDFunctionDepartment[] findByDepartmentId_PrevAndNext(long id,
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchEDFunctionDepartmentException, SystemException {
		EDFunctionDepartment edFunctionDepartment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			EDFunctionDepartment[] array = new EDFunctionDepartmentImpl[3];

			array[0] = getByDepartmentId_PrevAndNext(session,
					edFunctionDepartment, departmentId, orderByComparator, true);

			array[1] = edFunctionDepartment;

			array[2] = getByDepartmentId_PrevAndNext(session,
					edFunctionDepartment, departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EDFunctionDepartment getByDepartmentId_PrevAndNext(
		Session session, EDFunctionDepartment edFunctionDepartment,
		long departmentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EDFUNCTIONDEPARTMENT_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

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
			query.append(EDFunctionDepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(edFunctionDepartment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EDFunctionDepartment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the e d function departments.
	 *
	 * @return the e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e d function departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e d function departments
	 * @param end the upper bound of the range of e d function departments (not inclusive)
	 * @return the range of e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e d function departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of e d function departments
	 * @param end the upper bound of the range of e d function departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public List<EDFunctionDepartment> findAll(int start, int end,
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

		List<EDFunctionDepartment> list = (List<EDFunctionDepartment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EDFUNCTIONDEPARTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EDFUNCTIONDEPARTMENT.concat(EDFunctionDepartmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<EDFunctionDepartment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<EDFunctionDepartment>)QueryUtil.list(q,
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
	 * Removes all the e d function departments where functionId = &#63; from the database.
	 *
	 * @param functionId the function ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByFunctionId(long functionId) throws SystemException {
		for (EDFunctionDepartment edFunctionDepartment : findByFunctionId(
				functionId)) {
			remove(edFunctionDepartment);
		}
	}

	/**
	 * Removes all the e d function departments where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDepartmentId(long departmentId)
		throws SystemException {
		for (EDFunctionDepartment edFunctionDepartment : findByDepartmentId(
				departmentId)) {
			remove(edFunctionDepartment);
		}
	}

	/**
	 * Removes all the e d function departments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (EDFunctionDepartment edFunctionDepartment : findAll()) {
			remove(edFunctionDepartment);
		}
	}

	/**
	 * Returns the number of e d function departments where functionId = &#63;.
	 *
	 * @param functionId the function ID
	 * @return the number of matching e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFunctionId(long functionId) throws SystemException {
		Object[] finderArgs = new Object[] { functionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FUNCTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDFUNCTIONDEPARTMENT_WHERE);

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
	 * Returns the number of e d function departments where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDepartmentId(long departmentId) throws SystemException {
		Object[] finderArgs = new Object[] { departmentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EDFUNCTIONDEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
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
	 * Returns the number of e d function departments.
	 *
	 * @return the number of e d function departments
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EDFUNCTIONDEPARTMENT);

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
	 * Initializes the e d function department persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.edirectory.model.EDFunctionDepartment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EDFunctionDepartment>> listenersList = new ArrayList<ModelListener<EDFunctionDepartment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EDFunctionDepartment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EDFunctionDepartmentImpl.class.getName());
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
	private static final String _SQL_SELECT_EDFUNCTIONDEPARTMENT = "SELECT edFunctionDepartment FROM EDFunctionDepartment edFunctionDepartment";
	private static final String _SQL_SELECT_EDFUNCTIONDEPARTMENT_WHERE = "SELECT edFunctionDepartment FROM EDFunctionDepartment edFunctionDepartment WHERE ";
	private static final String _SQL_COUNT_EDFUNCTIONDEPARTMENT = "SELECT COUNT(edFunctionDepartment) FROM EDFunctionDepartment edFunctionDepartment";
	private static final String _SQL_COUNT_EDFUNCTIONDEPARTMENT_WHERE = "SELECT COUNT(edFunctionDepartment) FROM EDFunctionDepartment edFunctionDepartment WHERE ";
	private static final String _FINDER_COLUMN_FUNCTIONID_FUNCTIONID_2 = "edFunctionDepartment.functionId = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2 = "edFunctionDepartment.departmentId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "edFunctionDepartment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EDFunctionDepartment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EDFunctionDepartment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EDFunctionDepartmentPersistenceImpl.class);
	private static EDFunctionDepartment _nullEDFunctionDepartment = new EDFunctionDepartmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EDFunctionDepartment> toCacheModel() {
				return _nullEDFunctionDepartmentCacheModel;
			}
		};

	private static CacheModel<EDFunctionDepartment> _nullEDFunctionDepartmentCacheModel =
		new CacheModel<EDFunctionDepartment>() {
			public EDFunctionDepartment toEntityModel() {
				return _nullEDFunctionDepartment;
			}
		};
}