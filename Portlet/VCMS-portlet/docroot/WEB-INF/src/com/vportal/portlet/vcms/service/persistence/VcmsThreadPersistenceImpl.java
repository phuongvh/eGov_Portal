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

import com.vportal.portlet.vcms.NoSuchVcmsThreadException;
import com.vportal.portlet.vcms.model.VcmsThread;
import com.vportal.portlet.vcms.model.impl.VcmsThreadImpl;
import com.vportal.portlet.vcms.model.impl.VcmsThreadModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms thread service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsThreadPersistence
 * @see VcmsThreadUtil
 * @generated
 */
public class VcmsThreadPersistenceImpl extends BasePersistenceImpl<VcmsThread>
	implements VcmsThreadPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsThreadUtil} to access the vcms thread persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsThreadImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_P_L = new FinderPath(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadModelImpl.FINDER_CACHE_ENABLED, VcmsThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByP_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L = new FinderPath(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadModelImpl.FINDER_CACHE_ENABLED, VcmsThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByP_L",
			new String[] { Long.class.getName(), String.class.getName() },
			VcmsThreadModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsThreadModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_P_L = new FinderPath(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByP_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadModelImpl.FINDER_CACHE_ENABLED, VcmsThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadModelImpl.FINDER_CACHE_ENABLED, VcmsThreadImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms thread in the entity cache if it is enabled.
	 *
	 * @param vcmsThread the vcms thread
	 */
	public void cacheResult(VcmsThread vcmsThread) {
		EntityCacheUtil.putResult(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadImpl.class, vcmsThread.getPrimaryKey(), vcmsThread);

		vcmsThread.resetOriginalValues();
	}

	/**
	 * Caches the vcms threads in the entity cache if it is enabled.
	 *
	 * @param vcmsThreads the vcms threads
	 */
	public void cacheResult(List<VcmsThread> vcmsThreads) {
		for (VcmsThread vcmsThread : vcmsThreads) {
			if (EntityCacheUtil.getResult(
						VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
						VcmsThreadImpl.class, vcmsThread.getPrimaryKey()) == null) {
				cacheResult(vcmsThread);
			}
			else {
				vcmsThread.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms threads.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsThreadImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsThreadImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms thread.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsThread vcmsThread) {
		EntityCacheUtil.removeResult(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadImpl.class, vcmsThread.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsThread> vcmsThreads) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsThread vcmsThread : vcmsThreads) {
			EntityCacheUtil.removeResult(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
				VcmsThreadImpl.class, vcmsThread.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms thread with the primary key. Does not add the vcms thread to the database.
	 *
	 * @param threadId the primary key for the new vcms thread
	 * @return the new vcms thread
	 */
	public VcmsThread create(String threadId) {
		VcmsThread vcmsThread = new VcmsThreadImpl();

		vcmsThread.setNew(true);
		vcmsThread.setPrimaryKey(threadId);

		return vcmsThread;
	}

	/**
	 * Removes the vcms thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param threadId the primary key of the vcms thread
	 * @return the vcms thread that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsThreadException if a vcms thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsThread remove(String threadId)
		throws NoSuchVcmsThreadException, SystemException {
		return remove((Serializable)threadId);
	}

	/**
	 * Removes the vcms thread with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms thread
	 * @return the vcms thread that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsThreadException if a vcms thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsThread remove(Serializable primaryKey)
		throws NoSuchVcmsThreadException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsThread vcmsThread = (VcmsThread)session.get(VcmsThreadImpl.class,
					primaryKey);

			if (vcmsThread == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsThreadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsThread);
		}
		catch (NoSuchVcmsThreadException nsee) {
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
	protected VcmsThread removeImpl(VcmsThread vcmsThread)
		throws SystemException {
		vcmsThread = toUnwrappedModel(vcmsThread);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsThread);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsThread);

		return vcmsThread;
	}

	@Override
	public VcmsThread updateImpl(
		com.vportal.portlet.vcms.model.VcmsThread vcmsThread, boolean merge)
		throws SystemException {
		vcmsThread = toUnwrappedModel(vcmsThread);

		boolean isNew = vcmsThread.isNew();

		VcmsThreadModelImpl vcmsThreadModelImpl = (VcmsThreadModelImpl)vcmsThread;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsThread, merge);

			vcmsThread.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsThreadModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsThreadModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsThreadModelImpl.getOriginalGroupId()),
						
						vcmsThreadModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L,
					args);

				args = new Object[] {
						Long.valueOf(vcmsThreadModelImpl.getGroupId()),
						
						vcmsThreadModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_P_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
			VcmsThreadImpl.class, vcmsThread.getPrimaryKey(), vcmsThread);

		return vcmsThread;
	}

	protected VcmsThread toUnwrappedModel(VcmsThread vcmsThread) {
		if (vcmsThread instanceof VcmsThreadImpl) {
			return vcmsThread;
		}

		VcmsThreadImpl vcmsThreadImpl = new VcmsThreadImpl();

		vcmsThreadImpl.setNew(vcmsThread.isNew());
		vcmsThreadImpl.setPrimaryKey(vcmsThread.getPrimaryKey());

		vcmsThreadImpl.setThreadId(vcmsThread.getThreadId());
		vcmsThreadImpl.setGroupId(vcmsThread.getGroupId());
		vcmsThreadImpl.setCompanyId(vcmsThread.getCompanyId());
		vcmsThreadImpl.setCreatedDate(vcmsThread.getCreatedDate());
		vcmsThreadImpl.setCreatedByUser(vcmsThread.getCreatedByUser());
		vcmsThreadImpl.setModifiedDate(vcmsThread.getModifiedDate());
		vcmsThreadImpl.setModifiedByUser(vcmsThread.getModifiedByUser());
		vcmsThreadImpl.setTitle(vcmsThread.getTitle());
		vcmsThreadImpl.setDescription(vcmsThread.getDescription());
		vcmsThreadImpl.setHasImage(vcmsThread.isHasImage());
		vcmsThreadImpl.setImage(vcmsThread.getImage());
		vcmsThreadImpl.setLanguage(vcmsThread.getLanguage());

		return vcmsThreadImpl;
	}

	/**
	 * Returns the vcms thread with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms thread
	 * @return the vcms thread
	 * @throws com.liferay.portal.NoSuchModelException if a vcms thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsThread findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms thread with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsThreadException} if it could not be found.
	 *
	 * @param threadId the primary key of the vcms thread
	 * @return the vcms thread
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsThreadException if a vcms thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsThread findByPrimaryKey(String threadId)
		throws NoSuchVcmsThreadException, SystemException {
		VcmsThread vcmsThread = fetchByPrimaryKey(threadId);

		if (vcmsThread == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + threadId);
			}

			throw new NoSuchVcmsThreadException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				threadId);
		}

		return vcmsThread;
	}

	/**
	 * Returns the vcms thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms thread
	 * @return the vcms thread, or <code>null</code> if a vcms thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsThread fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms thread with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param threadId the primary key of the vcms thread
	 * @return the vcms thread, or <code>null</code> if a vcms thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsThread fetchByPrimaryKey(String threadId)
		throws SystemException {
		VcmsThread vcmsThread = (VcmsThread)EntityCacheUtil.getResult(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
				VcmsThreadImpl.class, threadId);

		if (vcmsThread == _nullVcmsThread) {
			return null;
		}

		if (vcmsThread == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsThread = (VcmsThread)session.get(VcmsThreadImpl.class,
						threadId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsThread != null) {
					cacheResult(vcmsThread);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsThreadModelImpl.ENTITY_CACHE_ENABLED,
						VcmsThreadImpl.class, threadId, _nullVcmsThread);
				}

				closeSession(session);
			}
		}

		return vcmsThread;
	}

	/**
	 * Returns all the vcms threads where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching vcms threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsThread> findByP_L(long groupId, String language)
		throws SystemException {
		return findByP_L(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms threads where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms threads
	 * @param end the upper bound of the range of vcms threads (not inclusive)
	 * @return the range of matching vcms threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsThread> findByP_L(long groupId, String language, int start,
		int end) throws SystemException {
		return findByP_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms threads where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms threads
	 * @param end the upper bound of the range of vcms threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsThread> findByP_L(long groupId, String language, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_P_L;
			finderArgs = new Object[] { groupId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_P_L;
			finderArgs = new Object[] {
					groupId, language,
					
					start, end, orderByComparator
				};
		}

		List<VcmsThread> list = (List<VcmsThread>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSTHREAD_WHERE);

			query.append(_FINDER_COLUMN_P_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_P_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_L_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsThreadModelImpl.ORDER_BY_JPQL);
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

				list = (List<VcmsThread>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms thread in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms thread
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsThreadException if a matching vcms thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsThread findByP_L_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsThreadException, SystemException {
		List<VcmsThread> list = findByP_L(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsThreadException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms thread in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms thread
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsThreadException if a matching vcms thread could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsThread findByP_L_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsThreadException, SystemException {
		int count = countByP_L(groupId, language);

		List<VcmsThread> list = findByP_L(groupId, language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsThreadException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms threads before and after the current vcms thread in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param threadId the primary key of the current vcms thread
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms thread
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsThreadException if a vcms thread with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsThread[] findByP_L_PrevAndNext(String threadId, long groupId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsThreadException, SystemException {
		VcmsThread vcmsThread = findByPrimaryKey(threadId);

		Session session = null;

		try {
			session = openSession();

			VcmsThread[] array = new VcmsThreadImpl[3];

			array[0] = getByP_L_PrevAndNext(session, vcmsThread, groupId,
					language, orderByComparator, true);

			array[1] = vcmsThread;

			array[2] = getByP_L_PrevAndNext(session, vcmsThread, groupId,
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

	protected VcmsThread getByP_L_PrevAndNext(Session session,
		VcmsThread vcmsThread, long groupId, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSTHREAD_WHERE);

		query.append(_FINDER_COLUMN_P_L_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_P_L_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_P_L_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_P_L_LANGUAGE_2);
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
			query.append(VcmsThreadModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsThread);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsThread> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms threads.
	 *
	 * @return the vcms threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsThread> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms threads
	 * @param end the upper bound of the range of vcms threads (not inclusive)
	 * @return the range of vcms threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsThread> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms threads.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms threads
	 * @param end the upper bound of the range of vcms threads (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms threads
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsThread> findAll(int start, int end,
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

		List<VcmsThread> list = (List<VcmsThread>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSTHREAD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSTHREAD.concat(VcmsThreadModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsThread>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsThread>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vcms threads where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByP_L(long groupId, String language)
		throws SystemException {
		for (VcmsThread vcmsThread : findByP_L(groupId, language)) {
			remove(vcmsThread);
		}
	}

	/**
	 * Removes all the vcms threads from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsThread vcmsThread : findAll()) {
			remove(vcmsThread);
		}
	}

	/**
	 * Returns the number of vcms threads where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching vcms threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countByP_L(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_P_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSTHREAD_WHERE);

			query.append(_FINDER_COLUMN_P_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_P_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_P_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_P_L_LANGUAGE_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_P_L, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms threads.
	 *
	 * @return the number of vcms threads
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSTHREAD);

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
	 * Initializes the vcms thread persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsThread")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsThread>> listenersList = new ArrayList<ModelListener<VcmsThread>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsThread>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsThreadImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSTHREAD = "SELECT vcmsThread FROM VcmsThread vcmsThread";
	private static final String _SQL_SELECT_VCMSTHREAD_WHERE = "SELECT vcmsThread FROM VcmsThread vcmsThread WHERE ";
	private static final String _SQL_COUNT_VCMSTHREAD = "SELECT COUNT(vcmsThread) FROM VcmsThread vcmsThread";
	private static final String _SQL_COUNT_VCMSTHREAD_WHERE = "SELECT COUNT(vcmsThread) FROM VcmsThread vcmsThread WHERE ";
	private static final String _FINDER_COLUMN_P_L_GROUPID_2 = "vcmsThread.groupId = ? AND ";
	private static final String _FINDER_COLUMN_P_L_LANGUAGE_1 = "vcmsThread.language IS NULL";
	private static final String _FINDER_COLUMN_P_L_LANGUAGE_2 = "vcmsThread.language = ?";
	private static final String _FINDER_COLUMN_P_L_LANGUAGE_3 = "(vcmsThread.language IS NULL OR vcmsThread.language = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsThread.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsThread exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsThread exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsThreadPersistenceImpl.class);
	private static VcmsThread _nullVcmsThread = new VcmsThreadImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsThread> toCacheModel() {
				return _nullVcmsThreadCacheModel;
			}
		};

	private static CacheModel<VcmsThread> _nullVcmsThreadCacheModel = new CacheModel<VcmsThread>() {
			public VcmsThread toEntityModel() {
				return _nullVcmsThread;
			}
		};
}