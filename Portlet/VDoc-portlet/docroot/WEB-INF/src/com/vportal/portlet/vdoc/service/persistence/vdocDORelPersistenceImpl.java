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

package com.vportal.portlet.vdoc.service.persistence;

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

import com.vportal.portlet.vdoc.NoSuchvdocDORelException;
import com.vportal.portlet.vdoc.model.impl.vdocDORelImpl;
import com.vportal.portlet.vdoc.model.impl.vdocDORelModelImpl;
import com.vportal.portlet.vdoc.model.vdocDORel;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vdoc d o rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocDORelPersistence
 * @see vdocDORelUtil
 * @generated
 */
public class vdocDORelPersistenceImpl extends BasePersistenceImpl<vdocDORel>
	implements vdocDORelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vdocDORelUtil} to access the vdoc d o rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = vdocDORelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENT = new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, vdocDORelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocument",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENT =
		new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, vdocDORelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocument",
			new String[] { String.class.getName() },
			vdocDORelModelImpl.DOCID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENT = new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocument",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ORG = new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, vdocDORelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrg",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG = new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, vdocDORelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrg",
			new String[] { String.class.getName() },
			vdocDORelModelImpl.ORGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORG = new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrg",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, vdocDORelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, vdocDORelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vdoc d o rel in the entity cache if it is enabled.
	 *
	 * @param vdocDORel the vdoc d o rel
	 */
	public void cacheResult(vdocDORel vdocDORel) {
		EntityCacheUtil.putResult(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelImpl.class, vdocDORel.getPrimaryKey(), vdocDORel);

		vdocDORel.resetOriginalValues();
	}

	/**
	 * Caches the vdoc d o rels in the entity cache if it is enabled.
	 *
	 * @param vdocDORels the vdoc d o rels
	 */
	public void cacheResult(List<vdocDORel> vdocDORels) {
		for (vdocDORel vdocDORel : vdocDORels) {
			if (EntityCacheUtil.getResult(
						vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
						vdocDORelImpl.class, vdocDORel.getPrimaryKey()) == null) {
				cacheResult(vdocDORel);
			}
			else {
				vdocDORel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vdoc d o rels.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(vdocDORelImpl.class.getName());
		}

		EntityCacheUtil.clearCache(vdocDORelImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vdoc d o rel.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(vdocDORel vdocDORel) {
		EntityCacheUtil.removeResult(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelImpl.class, vdocDORel.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<vdocDORel> vdocDORels) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (vdocDORel vdocDORel : vdocDORels) {
			EntityCacheUtil.removeResult(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
				vdocDORelImpl.class, vdocDORel.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vdoc d o rel with the primary key. Does not add the vdoc d o rel to the database.
	 *
	 * @param vdocDORelPK the primary key for the new vdoc d o rel
	 * @return the new vdoc d o rel
	 */
	public vdocDORel create(vdocDORelPK vdocDORelPK) {
		vdocDORel vdocDORel = new vdocDORelImpl();

		vdocDORel.setNew(true);
		vdocDORel.setPrimaryKey(vdocDORelPK);

		return vdocDORel;
	}

	/**
	 * Removes the vdoc d o rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vdocDORelPK the primary key of the vdoc d o rel
	 * @return the vdoc d o rel that was removed
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel remove(vdocDORelPK vdocDORelPK)
		throws NoSuchvdocDORelException, SystemException {
		return remove((Serializable)vdocDORelPK);
	}

	/**
	 * Removes the vdoc d o rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vdoc d o rel
	 * @return the vdoc d o rel that was removed
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocDORel remove(Serializable primaryKey)
		throws NoSuchvdocDORelException, SystemException {
		Session session = null;

		try {
			session = openSession();

			vdocDORel vdocDORel = (vdocDORel)session.get(vdocDORelImpl.class,
					primaryKey);

			if (vdocDORel == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchvdocDORelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vdocDORel);
		}
		catch (NoSuchvdocDORelException nsee) {
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
	protected vdocDORel removeImpl(vdocDORel vdocDORel)
		throws SystemException {
		vdocDORel = toUnwrappedModel(vdocDORel);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vdocDORel);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vdocDORel);

		return vdocDORel;
	}

	@Override
	public vdocDORel updateImpl(
		com.vportal.portlet.vdoc.model.vdocDORel vdocDORel, boolean merge)
		throws SystemException {
		vdocDORel = toUnwrappedModel(vdocDORel);

		boolean isNew = vdocDORel.isNew();

		vdocDORelModelImpl vdocDORelModelImpl = (vdocDORelModelImpl)vdocDORel;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vdocDORel, merge);

			vdocDORel.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !vdocDORelModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vdocDORelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vdocDORelModelImpl.getOriginalDocId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENT,
					args);

				args = new Object[] { vdocDORelModelImpl.getDocId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCUMENT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENT,
					args);
			}

			if ((vdocDORelModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vdocDORelModelImpl.getOriginalOrgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG,
					args);

				args = new Object[] { vdocDORelModelImpl.getOrgId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG,
					args);
			}
		}

		EntityCacheUtil.putResult(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
			vdocDORelImpl.class, vdocDORel.getPrimaryKey(), vdocDORel);

		return vdocDORel;
	}

	protected vdocDORel toUnwrappedModel(vdocDORel vdocDORel) {
		if (vdocDORel instanceof vdocDORelImpl) {
			return vdocDORel;
		}

		vdocDORelImpl vdocDORelImpl = new vdocDORelImpl();

		vdocDORelImpl.setNew(vdocDORel.isNew());
		vdocDORelImpl.setPrimaryKey(vdocDORel.getPrimaryKey());

		vdocDORelImpl.setDocId(vdocDORel.getDocId());
		vdocDORelImpl.setOrgId(vdocDORel.getOrgId());

		return vdocDORelImpl;
	}

	/**
	 * Returns the vdoc d o rel with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vdoc d o rel
	 * @return the vdoc d o rel
	 * @throws com.liferay.portal.NoSuchModelException if a vdoc d o rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocDORel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((vdocDORelPK)primaryKey);
	}

	/**
	 * Returns the vdoc d o rel with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocDORelException} if it could not be found.
	 *
	 * @param vdocDORelPK the primary key of the vdoc d o rel
	 * @return the vdoc d o rel
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel findByPrimaryKey(vdocDORelPK vdocDORelPK)
		throws NoSuchvdocDORelException, SystemException {
		vdocDORel vdocDORel = fetchByPrimaryKey(vdocDORelPK);

		if (vdocDORel == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + vdocDORelPK);
			}

			throw new NoSuchvdocDORelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				vdocDORelPK);
		}

		return vdocDORel;
	}

	/**
	 * Returns the vdoc d o rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vdoc d o rel
	 * @return the vdoc d o rel, or <code>null</code> if a vdoc d o rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocDORel fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((vdocDORelPK)primaryKey);
	}

	/**
	 * Returns the vdoc d o rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vdocDORelPK the primary key of the vdoc d o rel
	 * @return the vdoc d o rel, or <code>null</code> if a vdoc d o rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel fetchByPrimaryKey(vdocDORelPK vdocDORelPK)
		throws SystemException {
		vdocDORel vdocDORel = (vdocDORel)EntityCacheUtil.getResult(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
				vdocDORelImpl.class, vdocDORelPK);

		if (vdocDORel == _nullvdocDORel) {
			return null;
		}

		if (vdocDORel == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vdocDORel = (vdocDORel)session.get(vdocDORelImpl.class,
						vdocDORelPK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vdocDORel != null) {
					cacheResult(vdocDORel);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(vdocDORelModelImpl.ENTITY_CACHE_ENABLED,
						vdocDORelImpl.class, vdocDORelPK, _nullvdocDORel);
				}

				closeSession(session);
			}
		}

		return vdocDORel;
	}

	/**
	 * Returns all the vdoc d o rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the matching vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findByDocument(String docId)
		throws SystemException {
		return findByDocument(docId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc d o rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of vdoc d o rels
	 * @param end the upper bound of the range of vdoc d o rels (not inclusive)
	 * @return the range of matching vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findByDocument(String docId, int start, int end)
		throws SystemException {
		return findByDocument(docId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc d o rels where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param start the lower bound of the range of vdoc d o rels
	 * @param end the upper bound of the range of vdoc d o rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findByDocument(String docId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCUMENT;
			finderArgs = new Object[] { docId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCUMENT;
			finderArgs = new Object[] { docId, start, end, orderByComparator };
		}

		List<vdocDORel> list = (List<vdocDORel>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VDOCDOREL_WHERE);

			if (docId == null) {
				query.append(_FINDER_COLUMN_DOCUMENT_DOCID_1);
			}
			else {
				if (docId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DOCUMENT_DOCID_3);
				}
				else {
					query.append(_FINDER_COLUMN_DOCUMENT_DOCID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(vdocDORelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (docId != null) {
					qPos.add(docId);
				}

				list = (List<vdocDORel>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vdoc d o rel in the ordered set where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vdoc d o rel
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a matching vdoc d o rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel findByDocument_First(String docId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocDORelException, SystemException {
		List<vdocDORel> list = findByDocument(docId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("docId=");
			msg.append(docId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocDORelException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vdoc d o rel in the ordered set where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vdoc d o rel
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a matching vdoc d o rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel findByDocument_Last(String docId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocDORelException, SystemException {
		int count = countByDocument(docId);

		List<vdocDORel> list = findByDocument(docId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("docId=");
			msg.append(docId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocDORelException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vdoc d o rels before and after the current vdoc d o rel in the ordered set where docId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vdocDORelPK the primary key of the current vdoc d o rel
	 * @param docId the doc ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vdoc d o rel
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel[] findByDocument_PrevAndNext(vdocDORelPK vdocDORelPK,
		String docId, OrderByComparator orderByComparator)
		throws NoSuchvdocDORelException, SystemException {
		vdocDORel vdocDORel = findByPrimaryKey(vdocDORelPK);

		Session session = null;

		try {
			session = openSession();

			vdocDORel[] array = new vdocDORelImpl[3];

			array[0] = getByDocument_PrevAndNext(session, vdocDORel, docId,
					orderByComparator, true);

			array[1] = vdocDORel;

			array[2] = getByDocument_PrevAndNext(session, vdocDORel, docId,
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

	protected vdocDORel getByDocument_PrevAndNext(Session session,
		vdocDORel vdocDORel, String docId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VDOCDOREL_WHERE);

		if (docId == null) {
			query.append(_FINDER_COLUMN_DOCUMENT_DOCID_1);
		}
		else {
			if (docId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCUMENT_DOCID_3);
			}
			else {
				query.append(_FINDER_COLUMN_DOCUMENT_DOCID_2);
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
			query.append(vdocDORelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (docId != null) {
			qPos.add(docId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vdocDORel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<vdocDORel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vdoc d o rels where orgId = &#63;.
	 *
	 * @param orgId the org ID
	 * @return the matching vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findByOrg(String orgId) throws SystemException {
		return findByOrg(orgId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc d o rels where orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orgId the org ID
	 * @param start the lower bound of the range of vdoc d o rels
	 * @param end the upper bound of the range of vdoc d o rels (not inclusive)
	 * @return the range of matching vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findByOrg(String orgId, int start, int end)
		throws SystemException {
		return findByOrg(orgId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc d o rels where orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orgId the org ID
	 * @param start the lower bound of the range of vdoc d o rels
	 * @param end the upper bound of the range of vdoc d o rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findByOrg(String orgId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ORG;
			finderArgs = new Object[] { orgId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ORG;
			finderArgs = new Object[] { orgId, start, end, orderByComparator };
		}

		List<vdocDORel> list = (List<vdocDORel>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VDOCDOREL_WHERE);

			if (orgId == null) {
				query.append(_FINDER_COLUMN_ORG_ORGID_1);
			}
			else {
				if (orgId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ORG_ORGID_3);
				}
				else {
					query.append(_FINDER_COLUMN_ORG_ORGID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(vdocDORelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgId != null) {
					qPos.add(orgId);
				}

				list = (List<vdocDORel>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vdoc d o rel in the ordered set where orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vdoc d o rel
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a matching vdoc d o rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel findByOrg_First(String orgId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocDORelException, SystemException {
		List<vdocDORel> list = findByOrg(orgId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("orgId=");
			msg.append(orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocDORelException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vdoc d o rel in the ordered set where orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vdoc d o rel
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a matching vdoc d o rel could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel findByOrg_Last(String orgId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocDORelException, SystemException {
		int count = countByOrg(orgId);

		List<vdocDORel> list = findByOrg(orgId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("orgId=");
			msg.append(orgId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocDORelException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vdoc d o rels before and after the current vdoc d o rel in the ordered set where orgId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param vdocDORelPK the primary key of the current vdoc d o rel
	 * @param orgId the org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vdoc d o rel
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocDORelException if a vdoc d o rel with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocDORel[] findByOrg_PrevAndNext(vdocDORelPK vdocDORelPK,
		String orgId, OrderByComparator orderByComparator)
		throws NoSuchvdocDORelException, SystemException {
		vdocDORel vdocDORel = findByPrimaryKey(vdocDORelPK);

		Session session = null;

		try {
			session = openSession();

			vdocDORel[] array = new vdocDORelImpl[3];

			array[0] = getByOrg_PrevAndNext(session, vdocDORel, orgId,
					orderByComparator, true);

			array[1] = vdocDORel;

			array[2] = getByOrg_PrevAndNext(session, vdocDORel, orgId,
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

	protected vdocDORel getByOrg_PrevAndNext(Session session,
		vdocDORel vdocDORel, String orgId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VDOCDOREL_WHERE);

		if (orgId == null) {
			query.append(_FINDER_COLUMN_ORG_ORGID_1);
		}
		else {
			if (orgId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ORG_ORGID_3);
			}
			else {
				query.append(_FINDER_COLUMN_ORG_ORGID_2);
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
			query.append(vdocDORelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (orgId != null) {
			qPos.add(orgId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vdocDORel);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<vdocDORel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vdoc d o rels.
	 *
	 * @return the vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc d o rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vdoc d o rels
	 * @param end the upper bound of the range of vdoc d o rels (not inclusive)
	 * @return the range of vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc d o rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vdoc d o rels
	 * @param end the upper bound of the range of vdoc d o rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocDORel> findAll(int start, int end,
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

		List<vdocDORel> list = (List<vdocDORel>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VDOCDOREL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VDOCDOREL.concat(vdocDORelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<vdocDORel>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<vdocDORel>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vdoc d o rels where docId = &#63; from the database.
	 *
	 * @param docId the doc ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDocument(String docId) throws SystemException {
		for (vdocDORel vdocDORel : findByDocument(docId)) {
			remove(vdocDORel);
		}
	}

	/**
	 * Removes all the vdoc d o rels where orgId = &#63; from the database.
	 *
	 * @param orgId the org ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByOrg(String orgId) throws SystemException {
		for (vdocDORel vdocDORel : findByOrg(orgId)) {
			remove(vdocDORel);
		}
	}

	/**
	 * Removes all the vdoc d o rels from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (vdocDORel vdocDORel : findAll()) {
			remove(vdocDORel);
		}
	}

	/**
	 * Returns the number of vdoc d o rels where docId = &#63;.
	 *
	 * @param docId the doc ID
	 * @return the number of matching vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDocument(String docId) throws SystemException {
		Object[] finderArgs = new Object[] { docId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DOCUMENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VDOCDOREL_WHERE);

			if (docId == null) {
				query.append(_FINDER_COLUMN_DOCUMENT_DOCID_1);
			}
			else {
				if (docId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DOCUMENT_DOCID_3);
				}
				else {
					query.append(_FINDER_COLUMN_DOCUMENT_DOCID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (docId != null) {
					qPos.add(docId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vdoc d o rels where orgId = &#63;.
	 *
	 * @param orgId the org ID
	 * @return the number of matching vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public int countByOrg(String orgId) throws SystemException {
		Object[] finderArgs = new Object[] { orgId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VDOCDOREL_WHERE);

			if (orgId == null) {
				query.append(_FINDER_COLUMN_ORG_ORGID_1);
			}
			else {
				if (orgId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ORG_ORGID_3);
				}
				else {
					query.append(_FINDER_COLUMN_ORG_ORGID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (orgId != null) {
					qPos.add(orgId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORG, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vdoc d o rels.
	 *
	 * @return the number of vdoc d o rels
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VDOCDOREL);

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
	 * Initializes the vdoc d o rel persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vdoc.model.vdocDORel")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<vdocDORel>> listenersList = new ArrayList<ModelListener<vdocDORel>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<vdocDORel>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(vdocDORelImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = vdocDocumentPersistence.class)
	protected vdocDocumentPersistence vdocDocumentPersistence;
	@BeanReference(type = vdocDORelPersistence.class)
	protected vdocDORelPersistence vdocDORelPersistence;
	@BeanReference(type = vdocFieldPersistence.class)
	protected vdocFieldPersistence vdocFieldPersistence;
	@BeanReference(type = vdocLoggerPersistence.class)
	protected vdocLoggerPersistence vdocLoggerPersistence;
	@BeanReference(type = vdocOrgPersistence.class)
	protected vdocOrgPersistence vdocOrgPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_VDOCDOREL = "SELECT vdocDORel FROM vdocDORel vdocDORel";
	private static final String _SQL_SELECT_VDOCDOREL_WHERE = "SELECT vdocDORel FROM vdocDORel vdocDORel WHERE ";
	private static final String _SQL_COUNT_VDOCDOREL = "SELECT COUNT(vdocDORel) FROM vdocDORel vdocDORel";
	private static final String _SQL_COUNT_VDOCDOREL_WHERE = "SELECT COUNT(vdocDORel) FROM vdocDORel vdocDORel WHERE ";
	private static final String _FINDER_COLUMN_DOCUMENT_DOCID_1 = "vdocDORel.id.docId IS NULL";
	private static final String _FINDER_COLUMN_DOCUMENT_DOCID_2 = "vdocDORel.id.docId = ?";
	private static final String _FINDER_COLUMN_DOCUMENT_DOCID_3 = "(vdocDORel.id.docId IS NULL OR vdocDORel.id.docId = ?)";
	private static final String _FINDER_COLUMN_ORG_ORGID_1 = "vdocDORel.id.orgId IS NULL";
	private static final String _FINDER_COLUMN_ORG_ORGID_2 = "vdocDORel.id.orgId = ?";
	private static final String _FINDER_COLUMN_ORG_ORGID_3 = "(vdocDORel.id.orgId IS NULL OR vdocDORel.id.orgId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vdocDORel.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No vdocDORel exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No vdocDORel exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(vdocDORelPersistenceImpl.class);
	private static vdocDORel _nullvdocDORel = new vdocDORelImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<vdocDORel> toCacheModel() {
				return _nullvdocDORelCacheModel;
			}
		};

	private static CacheModel<vdocDORel> _nullvdocDORelCacheModel = new CacheModel<vdocDORel>() {
			public vdocDORel toEntityModel() {
				return _nullvdocDORel;
			}
		};
}