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

import com.vportal.portlet.vdoc.NoSuchvdocOrgException;
import com.vportal.portlet.vdoc.model.impl.vdocOrgImpl;
import com.vportal.portlet.vdoc.model.impl.vdocOrgModelImpl;
import com.vportal.portlet.vdoc.model.vdocOrg;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vdoc org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocOrgPersistence
 * @see vdocOrgUtil
 * @generated
 */
public class vdocOrgPersistenceImpl extends BasePersistenceImpl<vdocOrg>
	implements vdocOrgPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vdocOrgUtil} to access the vdoc org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = vdocOrgImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, vdocOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, vdocOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { String.class.getName() },
			vdocOrgModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, vdocOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, vdocOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] { Long.class.getName(), String.class.getName() },
			vdocOrgModelImpl.GROUPID_COLUMN_BITMASK |
			vdocOrgModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_P = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, vdocOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, vdocOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			vdocOrgModelImpl.GROUPID_COLUMN_BITMASK |
			vdocOrgModelImpl.LANGUAGE_COLUMN_BITMASK |
			vdocOrgModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_P = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, vdocOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, vdocOrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vdoc org in the entity cache if it is enabled.
	 *
	 * @param vdocOrg the vdoc org
	 */
	public void cacheResult(vdocOrg vdocOrg) {
		EntityCacheUtil.putResult(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgImpl.class, vdocOrg.getPrimaryKey(), vdocOrg);

		vdocOrg.resetOriginalValues();
	}

	/**
	 * Caches the vdoc orgs in the entity cache if it is enabled.
	 *
	 * @param vdocOrgs the vdoc orgs
	 */
	public void cacheResult(List<vdocOrg> vdocOrgs) {
		for (vdocOrg vdocOrg : vdocOrgs) {
			if (EntityCacheUtil.getResult(
						vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
						vdocOrgImpl.class, vdocOrg.getPrimaryKey()) == null) {
				cacheResult(vdocOrg);
			}
			else {
				vdocOrg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vdoc orgs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(vdocOrgImpl.class.getName());
		}

		EntityCacheUtil.clearCache(vdocOrgImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vdoc org.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(vdocOrg vdocOrg) {
		EntityCacheUtil.removeResult(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgImpl.class, vdocOrg.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<vdocOrg> vdocOrgs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (vdocOrg vdocOrg : vdocOrgs) {
			EntityCacheUtil.removeResult(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
				vdocOrgImpl.class, vdocOrg.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vdoc org with the primary key. Does not add the vdoc org to the database.
	 *
	 * @param orgId the primary key for the new vdoc org
	 * @return the new vdoc org
	 */
	public vdocOrg create(String orgId) {
		vdocOrg vdocOrg = new vdocOrgImpl();

		vdocOrg.setNew(true);
		vdocOrg.setPrimaryKey(orgId);

		return vdocOrg;
	}

	/**
	 * Removes the vdoc org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgId the primary key of the vdoc org
	 * @return the vdoc org that was removed
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg remove(String orgId)
		throws NoSuchvdocOrgException, SystemException {
		return remove((Serializable)orgId);
	}

	/**
	 * Removes the vdoc org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vdoc org
	 * @return the vdoc org that was removed
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocOrg remove(Serializable primaryKey)
		throws NoSuchvdocOrgException, SystemException {
		Session session = null;

		try {
			session = openSession();

			vdocOrg vdocOrg = (vdocOrg)session.get(vdocOrgImpl.class, primaryKey);

			if (vdocOrg == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchvdocOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vdocOrg);
		}
		catch (NoSuchvdocOrgException nsee) {
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
	protected vdocOrg removeImpl(vdocOrg vdocOrg) throws SystemException {
		vdocOrg = toUnwrappedModel(vdocOrg);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vdocOrg);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vdocOrg);

		return vdocOrg;
	}

	@Override
	public vdocOrg updateImpl(com.vportal.portlet.vdoc.model.vdocOrg vdocOrg,
		boolean merge) throws SystemException {
		vdocOrg = toUnwrappedModel(vdocOrg);

		boolean isNew = vdocOrg.isNew();

		vdocOrgModelImpl vdocOrgModelImpl = (vdocOrgModelImpl)vdocOrg;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vdocOrg, merge);

			vdocOrg.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !vdocOrgModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vdocOrgModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vdocOrgModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] { vdocOrgModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((vdocOrgModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vdocOrgModelImpl.getOriginalGroupId()),
						
						vdocOrgModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);

				args = new Object[] {
						Long.valueOf(vdocOrgModelImpl.getGroupId()),
						
						vdocOrgModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);
			}

			if ((vdocOrgModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vdocOrgModelImpl.getOriginalGroupId()),
						
						vdocOrgModelImpl.getOriginalLanguage(),
						
						vdocOrgModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P,
					args);

				args = new Object[] {
						Long.valueOf(vdocOrgModelImpl.getGroupId()),
						
						vdocOrgModelImpl.getLanguage(),
						
						vdocOrgModelImpl.getParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P,
					args);
			}
		}

		EntityCacheUtil.putResult(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
			vdocOrgImpl.class, vdocOrg.getPrimaryKey(), vdocOrg);

		return vdocOrg;
	}

	protected vdocOrg toUnwrappedModel(vdocOrg vdocOrg) {
		if (vdocOrg instanceof vdocOrgImpl) {
			return vdocOrg;
		}

		vdocOrgImpl vdocOrgImpl = new vdocOrgImpl();

		vdocOrgImpl.setNew(vdocOrg.isNew());
		vdocOrgImpl.setPrimaryKey(vdocOrg.getPrimaryKey());

		vdocOrgImpl.setOrgId(vdocOrg.getOrgId());
		vdocOrgImpl.setGroupId(vdocOrg.getGroupId());
		vdocOrgImpl.setCompanyId(vdocOrg.getCompanyId());
		vdocOrgImpl.setUserId(vdocOrg.getUserId());
		vdocOrgImpl.setCreatedDate(vdocOrg.getCreatedDate());
		vdocOrgImpl.setModifiedDate(vdocOrg.getModifiedDate());
		vdocOrgImpl.setCreatedByUser(vdocOrg.getCreatedByUser());
		vdocOrgImpl.setModifiedByUser(vdocOrg.getModifiedByUser());
		vdocOrgImpl.setParentId(vdocOrg.getParentId());
		vdocOrgImpl.setName(vdocOrg.getName());
		vdocOrgImpl.setDescription(vdocOrg.getDescription());
		vdocOrgImpl.setAddress(vdocOrg.getAddress());
		vdocOrgImpl.setPhone(vdocOrg.getPhone());
		vdocOrgImpl.setFax(vdocOrg.getFax());
		vdocOrgImpl.setLanguage(vdocOrg.getLanguage());
		vdocOrgImpl.setStatusOrg(vdocOrg.isStatusOrg());
		vdocOrgImpl.setPosition(vdocOrg.getPosition());
		vdocOrgImpl.setListparent(vdocOrg.getListparent());

		return vdocOrgImpl;
	}

	/**
	 * Returns the vdoc org with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vdoc org
	 * @return the vdoc org
	 * @throws com.liferay.portal.NoSuchModelException if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocOrg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vdoc org with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocOrgException} if it could not be found.
	 *
	 * @param orgId the primary key of the vdoc org
	 * @return the vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg findByPrimaryKey(String orgId)
		throws NoSuchvdocOrgException, SystemException {
		vdocOrg vdocOrg = fetchByPrimaryKey(orgId);

		if (vdocOrg == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + orgId);
			}

			throw new NoSuchvdocOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				orgId);
		}

		return vdocOrg;
	}

	/**
	 * Returns the vdoc org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vdoc org
	 * @return the vdoc org, or <code>null</code> if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocOrg fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vdoc org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orgId the primary key of the vdoc org
	 * @return the vdoc org, or <code>null</code> if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg fetchByPrimaryKey(String orgId) throws SystemException {
		vdocOrg vdocOrg = (vdocOrg)EntityCacheUtil.getResult(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
				vdocOrgImpl.class, orgId);

		if (vdocOrg == _nullvdocOrg) {
			return null;
		}

		if (vdocOrg == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vdocOrg = (vdocOrg)session.get(vdocOrgImpl.class, orgId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vdocOrg != null) {
					cacheResult(vdocOrg);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(vdocOrgModelImpl.ENTITY_CACHE_ENABLED,
						vdocOrgImpl.class, orgId, _nullvdocOrg);
				}

				closeSession(session);
			}
		}

		return vdocOrg;
	}

	/**
	 * Returns all the vdoc orgs where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByParentId(String parentId)
		throws SystemException {
		return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vdoc orgs where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vdoc orgs
	 * @param end the upper bound of the range of vdoc orgs (not inclusive)
	 * @return the range of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByParentId(String parentId, int start, int end)
		throws SystemException {
		return findByParentId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc orgs where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vdoc orgs
	 * @param end the upper bound of the range of vdoc orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByParentId(String parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<vdocOrg> list = (List<vdocOrg>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VDOCORG_WHERE);

			if (parentId == null) {
				query.append(_FINDER_COLUMN_PARENTID_PARENTID_1);
			}
			else {
				if (parentId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENTID_PARENTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(vdocOrgModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (parentId != null) {
					qPos.add(parentId);
				}

				list = (List<vdocOrg>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first vdoc org in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg findByParentId_First(String parentId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		List<vdocOrg> list = findByParentId(parentId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vdoc org in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg findByParentId_Last(String parentId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		int count = countByParentId(parentId);

		List<vdocOrg> list = findByParentId(parentId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vdoc orgs before and after the current vdoc org in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orgId the primary key of the current vdoc org
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg[] findByParentId_PrevAndNext(String orgId, String parentId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		vdocOrg vdocOrg = findByPrimaryKey(orgId);

		Session session = null;

		try {
			session = openSession();

			vdocOrg[] array = new vdocOrgImpl[3];

			array[0] = getByParentId_PrevAndNext(session, vdocOrg, parentId,
					orderByComparator, true);

			array[1] = vdocOrg;

			array[2] = getByParentId_PrevAndNext(session, vdocOrg, parentId,
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

	protected vdocOrg getByParentId_PrevAndNext(Session session,
		vdocOrg vdocOrg, String parentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VDOCORG_WHERE);

		if (parentId == null) {
			query.append(_FINDER_COLUMN_PARENTID_PARENTID_1);
		}
		else {
			if (parentId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PARENTID_PARENTID_3);
			}
			else {
				query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);
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
			query.append(vdocOrgModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (parentId != null) {
			qPos.add(parentId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vdocOrg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<vdocOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vdoc orgs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByG_L(long groupId, String language)
		throws SystemException {
		return findByG_L(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vdoc orgs
	 * @param end the upper bound of the range of vdoc orgs (not inclusive)
	 * @return the range of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByG_L(long groupId, String language, int start,
		int end) throws SystemException {
		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc orgs where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vdoc orgs
	 * @param end the upper bound of the range of vdoc orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByG_L(long groupId, String language, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L;
			finderArgs = new Object[] { groupId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L;
			finderArgs = new Object[] {
					groupId, language,
					
					start, end, orderByComparator
				};
		}

		List<vdocOrg> list = (List<vdocOrg>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VDOCORG_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(vdocOrgModelImpl.ORDER_BY_JPQL);
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

				list = (List<vdocOrg>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first vdoc org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg findByG_L_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		List<vdocOrg> list = findByG_L(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vdoc org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg findByG_L_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		int count = countByG_L(groupId, language);

		List<vdocOrg> list = findByG_L(groupId, language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vdoc orgs before and after the current vdoc org in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orgId the primary key of the current vdoc org
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg[] findByG_L_PrevAndNext(String orgId, long groupId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		vdocOrg vdocOrg = findByPrimaryKey(orgId);

		Session session = null;

		try {
			session = openSession();

			vdocOrg[] array = new vdocOrgImpl[3];

			array[0] = getByG_L_PrevAndNext(session, vdocOrg, groupId,
					language, orderByComparator, true);

			array[1] = vdocOrg;

			array[2] = getByG_L_PrevAndNext(session, vdocOrg, groupId,
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

	protected vdocOrg getByG_L_PrevAndNext(Session session, vdocOrg vdocOrg,
		long groupId, String language, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VDOCORG_WHERE);

		query.append(_FINDER_COLUMN_G_L_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_G_L_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
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
			query.append(vdocOrgModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vdocOrg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<vdocOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByG_L_P(long groupId, String language,
		String parentId) throws SystemException {
		return findByG_L_P(groupId, language, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vdoc orgs
	 * @param end the upper bound of the range of vdoc orgs (not inclusive)
	 * @return the range of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByG_L_P(long groupId, String language,
		String parentId, int start, int end) throws SystemException {
		return findByG_L_P(groupId, language, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vdoc orgs
	 * @param end the upper bound of the range of vdoc orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findByG_L_P(long groupId, String language,
		String parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P;
			finderArgs = new Object[] { groupId, language, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_P;
			finderArgs = new Object[] {
					groupId, language, parentId,
					
					start, end, orderByComparator
				};
		}

		List<vdocOrg> list = (List<vdocOrg>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VDOCORG_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
				}
			}

			if (parentId == null) {
				query.append(_FINDER_COLUMN_G_L_P_PARENTID_1);
			}
			else {
				if (parentId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_P_PARENTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(vdocOrgModelImpl.ORDER_BY_JPQL);
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

				if (parentId != null) {
					qPos.add(parentId);
				}

				list = (List<vdocOrg>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first vdoc org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg findByG_L_P_First(long groupId, String language,
		String parentId, OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		List<vdocOrg> list = findByG_L_P(groupId, language, parentId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vdoc org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a matching vdoc org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg findByG_L_P_Last(long groupId, String language,
		String parentId, OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		int count = countByG_L_P(groupId, language, parentId);

		List<vdocOrg> list = findByG_L_P(groupId, language, parentId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocOrgException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vdoc orgs before and after the current vdoc org in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param orgId the primary key of the current vdoc org
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vdoc org
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocOrgException if a vdoc org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocOrg[] findByG_L_P_PrevAndNext(String orgId, long groupId,
		String language, String parentId, OrderByComparator orderByComparator)
		throws NoSuchvdocOrgException, SystemException {
		vdocOrg vdocOrg = findByPrimaryKey(orgId);

		Session session = null;

		try {
			session = openSession();

			vdocOrg[] array = new vdocOrgImpl[3];

			array[0] = getByG_L_P_PrevAndNext(session, vdocOrg, groupId,
					language, parentId, orderByComparator, true);

			array[1] = vdocOrg;

			array[2] = getByG_L_P_PrevAndNext(session, vdocOrg, groupId,
					language, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected vdocOrg getByG_L_P_PrevAndNext(Session session, vdocOrg vdocOrg,
		long groupId, String language, String parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VDOCORG_WHERE);

		query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
			}
		}

		if (parentId == null) {
			query.append(_FINDER_COLUMN_G_L_P_PARENTID_1);
		}
		else {
			if (parentId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_P_PARENTID_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);
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
			query.append(vdocOrgModelImpl.ORDER_BY_JPQL);
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

		if (parentId != null) {
			qPos.add(parentId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vdocOrg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<vdocOrg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vdoc orgs.
	 *
	 * @return the vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vdoc orgs
	 * @param end the upper bound of the range of vdoc orgs (not inclusive)
	 * @return the range of vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc orgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vdoc orgs
	 * @param end the upper bound of the range of vdoc orgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocOrg> findAll(int start, int end,
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

		List<vdocOrg> list = (List<vdocOrg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VDOCORG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VDOCORG.concat(vdocOrgModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<vdocOrg>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<vdocOrg>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vdoc orgs where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentId(String parentId) throws SystemException {
		for (vdocOrg vdocOrg : findByParentId(parentId)) {
			remove(vdocOrg);
		}
	}

	/**
	 * Removes all the vdoc orgs where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L(long groupId, String language)
		throws SystemException {
		for (vdocOrg vdocOrg : findByG_L(groupId, language)) {
			remove(vdocOrg);
		}
	}

	/**
	 * Removes all the vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L_P(long groupId, String language, String parentId)
		throws SystemException {
		for (vdocOrg vdocOrg : findByG_L_P(groupId, language, parentId)) {
			remove(vdocOrg);
		}
	}

	/**
	 * Removes all the vdoc orgs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (vdocOrg vdocOrg : findAll()) {
			remove(vdocOrg);
		}
	}

	/**
	 * Returns the number of vdoc orgs where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentId(String parentId) throws SystemException {
		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VDOCORG_WHERE);

			if (parentId == null) {
				query.append(_FINDER_COLUMN_PARENTID_PARENTID_1);
			}
			else {
				if (parentId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PARENTID_PARENTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (parentId != null) {
					qPos.add(parentId);
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
	 * Returns the number of vdoc orgs where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VDOCORG_WHERE);

			query.append(_FINDER_COLUMN_G_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_LANGUAGE_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_L, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vdoc orgs where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the number of matching vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L_P(long groupId, String language, String parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VDOCORG_WHERE);

			query.append(_FINDER_COLUMN_G_L_P_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_P_LANGUAGE_2);
				}
			}

			if (parentId == null) {
				query.append(_FINDER_COLUMN_G_L_P_PARENTID_1);
			}
			else {
				if (parentId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_P_PARENTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_P_PARENTID_2);
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

				if (parentId != null) {
					qPos.add(parentId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_L_P,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vdoc orgs.
	 *
	 * @return the number of vdoc orgs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VDOCORG);

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
	 * Initializes the vdoc org persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vdoc.model.vdocOrg")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<vdocOrg>> listenersList = new ArrayList<ModelListener<vdocOrg>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<vdocOrg>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(vdocOrgImpl.class.getName());
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
	private static final String _SQL_SELECT_VDOCORG = "SELECT vdocOrg FROM vdocOrg vdocOrg";
	private static final String _SQL_SELECT_VDOCORG_WHERE = "SELECT vdocOrg FROM vdocOrg vdocOrg WHERE ";
	private static final String _SQL_COUNT_VDOCORG = "SELECT COUNT(vdocOrg) FROM vdocOrg vdocOrg";
	private static final String _SQL_COUNT_VDOCORG_WHERE = "SELECT COUNT(vdocOrg) FROM vdocOrg vdocOrg WHERE ";
	private static final String _FINDER_COLUMN_PARENTID_PARENTID_1 = "vdocOrg.parentId IS NULL";
	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "vdocOrg.parentId = ?";
	private static final String _FINDER_COLUMN_PARENTID_PARENTID_3 = "(vdocOrg.parentId IS NULL OR vdocOrg.parentId = ?)";
	private static final String _FINDER_COLUMN_G_L_GROUPID_2 = "vdocOrg.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_1 = "vdocOrg.language IS NULL";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 = "vdocOrg.language = ?";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 = "(vdocOrg.language IS NULL OR vdocOrg.language = ?)";
	private static final String _FINDER_COLUMN_G_L_P_GROUPID_2 = "vdocOrg.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_1 = "vdocOrg.language IS NULL AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_2 = "vdocOrg.language = ? AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_3 = "(vdocOrg.language IS NULL OR vdocOrg.language = ?) AND ";
	private static final String _FINDER_COLUMN_G_L_P_PARENTID_1 = "vdocOrg.parentId IS NULL";
	private static final String _FINDER_COLUMN_G_L_P_PARENTID_2 = "vdocOrg.parentId = ?";
	private static final String _FINDER_COLUMN_G_L_P_PARENTID_3 = "(vdocOrg.parentId IS NULL OR vdocOrg.parentId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vdocOrg.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No vdocOrg exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No vdocOrg exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(vdocOrgPersistenceImpl.class);
	private static vdocOrg _nullvdocOrg = new vdocOrgImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<vdocOrg> toCacheModel() {
				return _nullvdocOrgCacheModel;
			}
		};

	private static CacheModel<vdocOrg> _nullvdocOrgCacheModel = new CacheModel<vdocOrg>() {
			public vdocOrg toEntityModel() {
				return _nullvdocOrg;
			}
		};
}