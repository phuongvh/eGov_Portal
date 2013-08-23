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
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.vportal.portlet.vcms.NoSuchVcmsLoggerException;
import com.vportal.portlet.vcms.model.VcmsLogger;
import com.vportal.portlet.vcms.model.impl.VcmsLoggerImpl;
import com.vportal.portlet.vcms.model.impl.VcmsLoggerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the vcms logger service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsLoggerPersistence
 * @see VcmsLoggerUtil
 * @generated
 */
public class VcmsLoggerPersistenceImpl extends BasePersistenceImpl<VcmsLogger>
	implements VcmsLoggerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsLoggerUtil} to access the vcms logger persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsLoggerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_D = new FinderPath(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerModelImpl.FINDER_CACHE_ENABLED, VcmsLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_D",
			new String[] {
				String.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D = new FinderPath(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerModelImpl.FINDER_CACHE_ENABLED, VcmsLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_D",
			new String[] { String.class.getName(), Date.class.getName() },
			VcmsLoggerModelImpl.CREATEDBYUSER_COLUMN_BITMASK |
			VcmsLoggerModelImpl.CREATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_D = new FinderPath(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_D",
			new String[] { String.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerModelImpl.FINDER_CACHE_ENABLED, VcmsLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerModelImpl.FINDER_CACHE_ENABLED, VcmsLoggerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms logger in the entity cache if it is enabled.
	 *
	 * @param vcmsLogger the vcms logger
	 */
	public void cacheResult(VcmsLogger vcmsLogger) {
		EntityCacheUtil.putResult(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerImpl.class, vcmsLogger.getPrimaryKey(), vcmsLogger);

		vcmsLogger.resetOriginalValues();
	}

	/**
	 * Caches the vcms loggers in the entity cache if it is enabled.
	 *
	 * @param vcmsLoggers the vcms loggers
	 */
	public void cacheResult(List<VcmsLogger> vcmsLoggers) {
		for (VcmsLogger vcmsLogger : vcmsLoggers) {
			if (EntityCacheUtil.getResult(
						VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
						VcmsLoggerImpl.class, vcmsLogger.getPrimaryKey()) == null) {
				cacheResult(vcmsLogger);
			}
			else {
				vcmsLogger.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms loggers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsLoggerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsLoggerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms logger.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsLogger vcmsLogger) {
		EntityCacheUtil.removeResult(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerImpl.class, vcmsLogger.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsLogger> vcmsLoggers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsLogger vcmsLogger : vcmsLoggers) {
			EntityCacheUtil.removeResult(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
				VcmsLoggerImpl.class, vcmsLogger.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms logger with the primary key. Does not add the vcms logger to the database.
	 *
	 * @param loggerId the primary key for the new vcms logger
	 * @return the new vcms logger
	 */
	public VcmsLogger create(String loggerId) {
		VcmsLogger vcmsLogger = new VcmsLoggerImpl();

		vcmsLogger.setNew(true);
		vcmsLogger.setPrimaryKey(loggerId);

		return vcmsLogger;
	}

	/**
	 * Removes the vcms logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the vcms logger
	 * @return the vcms logger that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger remove(String loggerId)
		throws NoSuchVcmsLoggerException, SystemException {
		return remove((Serializable)loggerId);
	}

	/**
	 * Removes the vcms logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms logger
	 * @return the vcms logger that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsLogger remove(Serializable primaryKey)
		throws NoSuchVcmsLoggerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsLogger vcmsLogger = (VcmsLogger)session.get(VcmsLoggerImpl.class,
					primaryKey);

			if (vcmsLogger == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsLoggerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsLogger);
		}
		catch (NoSuchVcmsLoggerException nsee) {
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
	protected VcmsLogger removeImpl(VcmsLogger vcmsLogger)
		throws SystemException {
		vcmsLogger = toUnwrappedModel(vcmsLogger);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsLogger);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsLogger);

		return vcmsLogger;
	}

	@Override
	public VcmsLogger updateImpl(
		com.vportal.portlet.vcms.model.VcmsLogger vcmsLogger, boolean merge)
		throws SystemException {
		vcmsLogger = toUnwrappedModel(vcmsLogger);

		boolean isNew = vcmsLogger.isNew();

		VcmsLoggerModelImpl vcmsLoggerModelImpl = (VcmsLoggerModelImpl)vcmsLogger;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsLogger, merge);

			vcmsLogger.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsLoggerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsLoggerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsLoggerModelImpl.getOriginalCreatedByUser(),
						
						vcmsLoggerModelImpl.getOriginalCreatedDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D,
					args);

				args = new Object[] {
						vcmsLoggerModelImpl.getCreatedByUser(),
						
						vcmsLoggerModelImpl.getCreatedDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_U_D, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
			VcmsLoggerImpl.class, vcmsLogger.getPrimaryKey(), vcmsLogger);

		return vcmsLogger;
	}

	protected VcmsLogger toUnwrappedModel(VcmsLogger vcmsLogger) {
		if (vcmsLogger instanceof VcmsLoggerImpl) {
			return vcmsLogger;
		}

		VcmsLoggerImpl vcmsLoggerImpl = new VcmsLoggerImpl();

		vcmsLoggerImpl.setNew(vcmsLogger.isNew());
		vcmsLoggerImpl.setPrimaryKey(vcmsLogger.getPrimaryKey());

		vcmsLoggerImpl.setLoggerId(vcmsLogger.getLoggerId());
		vcmsLoggerImpl.setGroupId(vcmsLogger.getGroupId());
		vcmsLoggerImpl.setCompanyId(vcmsLogger.getCompanyId());
		vcmsLoggerImpl.setCreatedDate(vcmsLogger.getCreatedDate());
		vcmsLoggerImpl.setCreatedByUser(vcmsLogger.getCreatedByUser());
		vcmsLoggerImpl.setContent(vcmsLogger.getContent());

		return vcmsLoggerImpl;
	}

	/**
	 * Returns the vcms logger with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms logger
	 * @return the vcms logger
	 * @throws com.liferay.portal.NoSuchModelException if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsLogger findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms logger with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsLoggerException} if it could not be found.
	 *
	 * @param loggerId the primary key of the vcms logger
	 * @return the vcms logger
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger findByPrimaryKey(String loggerId)
		throws NoSuchVcmsLoggerException, SystemException {
		VcmsLogger vcmsLogger = fetchByPrimaryKey(loggerId);

		if (vcmsLogger == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + loggerId);
			}

			throw new NoSuchVcmsLoggerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				loggerId);
		}

		return vcmsLogger;
	}

	/**
	 * Returns the vcms logger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms logger
	 * @return the vcms logger, or <code>null</code> if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsLogger fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms logger with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loggerId the primary key of the vcms logger
	 * @return the vcms logger, or <code>null</code> if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger fetchByPrimaryKey(String loggerId)
		throws SystemException {
		VcmsLogger vcmsLogger = (VcmsLogger)EntityCacheUtil.getResult(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
				VcmsLoggerImpl.class, loggerId);

		if (vcmsLogger == _nullVcmsLogger) {
			return null;
		}

		if (vcmsLogger == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsLogger = (VcmsLogger)session.get(VcmsLoggerImpl.class,
						loggerId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsLogger != null) {
					cacheResult(vcmsLogger);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsLoggerModelImpl.ENTITY_CACHE_ENABLED,
						VcmsLoggerImpl.class, loggerId, _nullVcmsLogger);
				}

				closeSession(session);
			}
		}

		return vcmsLogger;
	}

	/**
	 * Returns all the vcms loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @return the matching vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsLogger> findByU_D(String createdByUser, Date createdDate)
		throws SystemException {
		return findByU_D(createdByUser, createdDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param start the lower bound of the range of vcms loggers
	 * @param end the upper bound of the range of vcms loggers (not inclusive)
	 * @return the range of matching vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsLogger> findByU_D(String createdByUser, Date createdDate,
		int start, int end) throws SystemException {
		return findByU_D(createdByUser, createdDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param start the lower bound of the range of vcms loggers
	 * @param end the upper bound of the range of vcms loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsLogger> findByU_D(String createdByUser, Date createdDate,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_D;
			finderArgs = new Object[] { createdByUser, createdDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_D;
			finderArgs = new Object[] {
					createdByUser, createdDate,
					
					start, end, orderByComparator
				};
		}

		List<VcmsLogger> list = (List<VcmsLogger>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSLOGGER_WHERE);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_2);
				}
			}

			if (createdDate == null) {
				query.append(_FINDER_COLUMN_U_D_CREATEDDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_U_D_CREATEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsLoggerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
				}

				list = (List<VcmsLogger>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms logger
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a matching vcms logger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger findByU_D_First(String createdByUser, Date createdDate,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsLoggerException, SystemException {
		List<VcmsLogger> list = findByU_D(createdByUser, createdDate, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createdByUser=");
			msg.append(createdByUser);

			msg.append(", createdDate=");
			msg.append(createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsLoggerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms logger
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a matching vcms logger could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger findByU_D_Last(String createdByUser, Date createdDate,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsLoggerException, SystemException {
		int count = countByU_D(createdByUser, createdDate);

		List<VcmsLogger> list = findByU_D(createdByUser, createdDate,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("createdByUser=");
			msg.append(createdByUser);

			msg.append(", createdDate=");
			msg.append(createdDate);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsLoggerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms loggers before and after the current vcms logger in the ordered set where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param loggerId the primary key of the current vcms logger
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms logger
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsLoggerException if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger[] findByU_D_PrevAndNext(String loggerId,
		String createdByUser, Date createdDate,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsLoggerException, SystemException {
		VcmsLogger vcmsLogger = findByPrimaryKey(loggerId);

		Session session = null;

		try {
			session = openSession();

			VcmsLogger[] array = new VcmsLoggerImpl[3];

			array[0] = getByU_D_PrevAndNext(session, vcmsLogger, createdByUser,
					createdDate, orderByComparator, true);

			array[1] = vcmsLogger;

			array[2] = getByU_D_PrevAndNext(session, vcmsLogger, createdByUser,
					createdDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsLogger getByU_D_PrevAndNext(Session session,
		VcmsLogger vcmsLogger, String createdByUser, Date createdDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSLOGGER_WHERE);

		if (createdByUser == null) {
			query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_1);
		}
		else {
			if (createdByUser.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_3);
			}
			else {
				query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_2);
			}
		}

		if (createdDate == null) {
			query.append(_FINDER_COLUMN_U_D_CREATEDDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_U_D_CREATEDDATE_2);
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
			query.append(VcmsLoggerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (createdByUser != null) {
			qPos.add(createdByUser);
		}

		if (createdDate != null) {
			qPos.add(CalendarUtil.getTimestamp(createdDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsLogger);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsLogger> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms loggers.
	 *
	 * @return the vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsLogger> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms loggers
	 * @param end the upper bound of the range of vcms loggers (not inclusive)
	 * @return the range of vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsLogger> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms loggers
	 * @param end the upper bound of the range of vcms loggers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsLogger> findAll(int start, int end,
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

		List<VcmsLogger> list = (List<VcmsLogger>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSLOGGER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSLOGGER.concat(VcmsLoggerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsLogger>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsLogger>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vcms loggers where createdByUser = &#63; and createdDate = &#63; from the database.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByU_D(String createdByUser, Date createdDate)
		throws SystemException {
		for (VcmsLogger vcmsLogger : findByU_D(createdByUser, createdDate)) {
			remove(vcmsLogger);
		}
	}

	/**
	 * Removes all the vcms loggers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsLogger vcmsLogger : findAll()) {
			remove(vcmsLogger);
		}
	}

	/**
	 * Returns the number of vcms loggers where createdByUser = &#63; and createdDate = &#63;.
	 *
	 * @param createdByUser the created by user
	 * @param createdDate the created date
	 * @return the number of matching vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByU_D(String createdByUser, Date createdDate)
		throws SystemException {
		Object[] finderArgs = new Object[] { createdByUser, createdDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_U_D,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSLOGGER_WHERE);

			if (createdByUser == null) {
				query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_1);
			}
			else {
				if (createdByUser.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_3);
				}
				else {
					query.append(_FINDER_COLUMN_U_D_CREATEDBYUSER_2);
				}
			}

			if (createdDate == null) {
				query.append(_FINDER_COLUMN_U_D_CREATEDDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_U_D_CREATEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createdByUser != null) {
					qPos.add(createdByUser);
				}

				if (createdDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createdDate));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_U_D, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms loggers.
	 *
	 * @return the number of vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSLOGGER);

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
	 * Initializes the vcms logger persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsLogger")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsLogger>> listenersList = new ArrayList<ModelListener<VcmsLogger>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsLogger>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsLoggerImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSLOGGER = "SELECT vcmsLogger FROM VcmsLogger vcmsLogger";
	private static final String _SQL_SELECT_VCMSLOGGER_WHERE = "SELECT vcmsLogger FROM VcmsLogger vcmsLogger WHERE ";
	private static final String _SQL_COUNT_VCMSLOGGER = "SELECT COUNT(vcmsLogger) FROM VcmsLogger vcmsLogger";
	private static final String _SQL_COUNT_VCMSLOGGER_WHERE = "SELECT COUNT(vcmsLogger) FROM VcmsLogger vcmsLogger WHERE ";
	private static final String _FINDER_COLUMN_U_D_CREATEDBYUSER_1 = "vcmsLogger.createdByUser IS NULL AND ";
	private static final String _FINDER_COLUMN_U_D_CREATEDBYUSER_2 = "vcmsLogger.createdByUser = ? AND ";
	private static final String _FINDER_COLUMN_U_D_CREATEDBYUSER_3 = "(vcmsLogger.createdByUser IS NULL OR vcmsLogger.createdByUser = ?) AND ";
	private static final String _FINDER_COLUMN_U_D_CREATEDDATE_1 = "vcmsLogger.createdDate IS NULL";
	private static final String _FINDER_COLUMN_U_D_CREATEDDATE_2 = "vcmsLogger.createdDate = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsLogger.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsLogger exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsLogger exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsLoggerPersistenceImpl.class);
	private static VcmsLogger _nullVcmsLogger = new VcmsLoggerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsLogger> toCacheModel() {
				return _nullVcmsLoggerCacheModel;
			}
		};

	private static CacheModel<VcmsLogger> _nullVcmsLoggerCacheModel = new CacheModel<VcmsLogger>() {
			public VcmsLogger toEntityModel() {
				return _nullVcmsLogger;
			}
		};
}