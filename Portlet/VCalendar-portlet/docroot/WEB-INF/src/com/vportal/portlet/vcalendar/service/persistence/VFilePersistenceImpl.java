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

import com.vportal.portlet.vcalendar.NoSuchVFileException;
import com.vportal.portlet.vcalendar.model.VFile;
import com.vportal.portlet.vcalendar.model.impl.VFileImpl;
import com.vportal.portlet.vcalendar.model.impl.VFileModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the v file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LongLH
 * @see VFilePersistence
 * @see VFileUtil
 * @generated
 */
public class VFilePersistenceImpl extends BasePersistenceImpl<VFile>
	implements VFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VFileUtil} to access the v file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileModelImpl.FINDER_CACHE_ENABLED, VFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupID",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileModelImpl.FINDER_CACHE_ENABLED, VFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupID",
			new String[] { Long.class.getName() },
			VFileModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupID",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileModelImpl.FINDER_CACHE_ENABLED, VFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileModelImpl.FINDER_CACHE_ENABLED, VFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the v file in the entity cache if it is enabled.
	 *
	 * @param vFile the v file
	 */
	public void cacheResult(VFile vFile) {
		EntityCacheUtil.putResult(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileImpl.class, vFile.getPrimaryKey(), vFile);

		vFile.resetOriginalValues();
	}

	/**
	 * Caches the v files in the entity cache if it is enabled.
	 *
	 * @param vFiles the v files
	 */
	public void cacheResult(List<VFile> vFiles) {
		for (VFile vFile : vFiles) {
			if (EntityCacheUtil.getResult(VFileModelImpl.ENTITY_CACHE_ENABLED,
						VFileImpl.class, vFile.getPrimaryKey()) == null) {
				cacheResult(vFile);
			}
			else {
				vFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all v files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the v file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VFile vFile) {
		EntityCacheUtil.removeResult(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileImpl.class, vFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VFile> vFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VFile vFile : vFiles) {
			EntityCacheUtil.removeResult(VFileModelImpl.ENTITY_CACHE_ENABLED,
				VFileImpl.class, vFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new v file with the primary key. Does not add the v file to the database.
	 *
	 * @param fileId the primary key for the new v file
	 * @return the new v file
	 */
	public VFile create(long fileId) {
		VFile vFile = new VFileImpl();

		vFile.setNew(true);
		vFile.setPrimaryKey(fileId);

		return vFile;
	}

	/**
	 * Removes the v file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileId the primary key of the v file
	 * @return the v file that was removed
	 * @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a v file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VFile remove(long fileId)
		throws NoSuchVFileException, SystemException {
		return remove(Long.valueOf(fileId));
	}

	/**
	 * Removes the v file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the v file
	 * @return the v file that was removed
	 * @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a v file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VFile remove(Serializable primaryKey)
		throws NoSuchVFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VFile vFile = (VFile)session.get(VFileImpl.class, primaryKey);

			if (vFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vFile);
		}
		catch (NoSuchVFileException nsee) {
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
	protected VFile removeImpl(VFile vFile) throws SystemException {
		vFile = toUnwrappedModel(vFile);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vFile);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vFile);

		return vFile;
	}

	@Override
	public VFile updateImpl(com.vportal.portlet.vcalendar.model.VFile vFile,
		boolean merge) throws SystemException {
		vFile = toUnwrappedModel(vFile);

		boolean isNew = vFile.isNew();

		VFileModelImpl vFileModelImpl = (VFileModelImpl)vFile;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vFile, merge);

			vFile.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VFileModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vFileModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vFileModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(vFileModelImpl.getStatus()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(VFileModelImpl.ENTITY_CACHE_ENABLED,
			VFileImpl.class, vFile.getPrimaryKey(), vFile);

		return vFile;
	}

	protected VFile toUnwrappedModel(VFile vFile) {
		if (vFile instanceof VFileImpl) {
			return vFile;
		}

		VFileImpl vFileImpl = new VFileImpl();

		vFileImpl.setNew(vFile.isNew());
		vFileImpl.setPrimaryKey(vFile.getPrimaryKey());

		vFileImpl.setFileId(vFile.getFileId());
		vFileImpl.setFullname(vFile.getFullname());
		vFileImpl.setPhone(vFile.getPhone());
		vFileImpl.setAddress(vFile.getAddress());
		vFileImpl.setBirthday(vFile.getBirthday());
		vFileImpl.setPosition(vFile.getPosition());
		vFileImpl.setStatus(vFile.getStatus());

		return vFileImpl;
	}

	/**
	 * Returns the v file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the v file
	 * @return the v file
	 * @throws com.liferay.portal.NoSuchModelException if a v file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v file with the primary key or throws a {@link com.vportal.portlet.vcalendar.NoSuchVFileException} if it could not be found.
	 *
	 * @param fileId the primary key of the v file
	 * @return the v file
	 * @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a v file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VFile findByPrimaryKey(long fileId)
		throws NoSuchVFileException, SystemException {
		VFile vFile = fetchByPrimaryKey(fileId);

		if (vFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + fileId);
			}

			throw new NoSuchVFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				fileId);
		}

		return vFile;
	}

	/**
	 * Returns the v file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the v file
	 * @return the v file, or <code>null</code> if a v file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the v file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileId the primary key of the v file
	 * @return the v file, or <code>null</code> if a v file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VFile fetchByPrimaryKey(long fileId) throws SystemException {
		VFile vFile = (VFile)EntityCacheUtil.getResult(VFileModelImpl.ENTITY_CACHE_ENABLED,
				VFileImpl.class, fileId);

		if (vFile == _nullVFile) {
			return null;
		}

		if (vFile == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vFile = (VFile)session.get(VFileImpl.class, Long.valueOf(fileId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vFile != null) {
					cacheResult(vFile);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VFileModelImpl.ENTITY_CACHE_ENABLED,
						VFileImpl.class, fileId, _nullVFile);
				}

				closeSession(session);
			}
		}

		return vFile;
	}

	/**
	 * Returns all the v files where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching v files
	 * @throws SystemException if a system exception occurred
	 */
	public List<VFile> findByGroupID(long status) throws SystemException {
		return findByGroupID(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v files where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of v files
	 * @param end the upper bound of the range of v files (not inclusive)
	 * @return the range of matching v files
	 * @throws SystemException if a system exception occurred
	 */
	public List<VFile> findByGroupID(long status, int start, int end)
		throws SystemException {
		return findByGroupID(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the v files where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of v files
	 * @param end the upper bound of the range of v files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching v files
	 * @throws SystemException if a system exception occurred
	 */
	public List<VFile> findByGroupID(long status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<VFile> list = (List<VFile>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VFILE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VFileModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<VFile>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first v file in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching v file
	 * @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a matching v file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VFile findByGroupID_First(long status,
		OrderByComparator orderByComparator)
		throws NoSuchVFileException, SystemException {
		List<VFile> list = findByGroupID(status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVFileException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last v file in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching v file
	 * @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a matching v file could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VFile findByGroupID_Last(long status,
		OrderByComparator orderByComparator)
		throws NoSuchVFileException, SystemException {
		int count = countByGroupID(status);

		List<VFile> list = findByGroupID(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVFileException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the v files before and after the current v file in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fileId the primary key of the current v file
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next v file
	 * @throws com.vportal.portlet.vcalendar.NoSuchVFileException if a v file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VFile[] findByGroupID_PrevAndNext(long fileId, long status,
		OrderByComparator orderByComparator)
		throws NoSuchVFileException, SystemException {
		VFile vFile = findByPrimaryKey(fileId);

		Session session = null;

		try {
			session = openSession();

			VFile[] array = new VFileImpl[3];

			array[0] = getByGroupID_PrevAndNext(session, vFile, status,
					orderByComparator, true);

			array[1] = vFile;

			array[2] = getByGroupID_PrevAndNext(session, vFile, status,
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

	protected VFile getByGroupID_PrevAndNext(Session session, VFile vFile,
		long status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VFILE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_STATUS_2);

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
			query.append(VFileModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vFile);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VFile> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the v files.
	 *
	 * @return the v files
	 * @throws SystemException if a system exception occurred
	 */
	public List<VFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the v files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v files
	 * @param end the upper bound of the range of v files (not inclusive)
	 * @return the range of v files
	 * @throws SystemException if a system exception occurred
	 */
	public List<VFile> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the v files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of v files
	 * @param end the upper bound of the range of v files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of v files
	 * @throws SystemException if a system exception occurred
	 */
	public List<VFile> findAll(int start, int end,
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

		List<VFile> list = (List<VFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VFILE.concat(VFileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VFile>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VFile>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the v files where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupID(long status) throws SystemException {
		for (VFile vFile : findByGroupID(status)) {
			remove(vFile);
		}
	}

	/**
	 * Removes all the v files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VFile vFile : findAll()) {
			remove(vFile);
		}
	}

	/**
	 * Returns the number of v files where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching v files
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupID(long status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VFILE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of v files.
	 *
	 * @return the number of v files
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VFILE);

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
	 * Initializes the v file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcalendar.model.VFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VFile>> listenersList = new ArrayList<ModelListener<VFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = VCalPersistence.class)
	protected VCalPersistence vCalPersistence;
	@BeanReference(type = VFilePersistence.class)
	protected VFilePersistence vFilePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VFILE = "SELECT vFile FROM VFile vFile";
	private static final String _SQL_SELECT_VFILE_WHERE = "SELECT vFile FROM VFile vFile WHERE ";
	private static final String _SQL_COUNT_VFILE = "SELECT COUNT(vFile) FROM VFile vFile";
	private static final String _SQL_COUNT_VFILE_WHERE = "SELECT COUNT(vFile) FROM VFile vFile WHERE ";
	private static final String _FINDER_COLUMN_GROUPID_STATUS_2 = "vFile.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VFile exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VFile exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VFilePersistenceImpl.class);
	private static VFile _nullVFile = new VFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VFile> toCacheModel() {
				return _nullVFileCacheModel;
			}
		};

	private static CacheModel<VFile> _nullVFileCacheModel = new CacheModel<VFile>() {
			public VFile toEntityModel() {
				return _nullVFile;
			}
		};
}