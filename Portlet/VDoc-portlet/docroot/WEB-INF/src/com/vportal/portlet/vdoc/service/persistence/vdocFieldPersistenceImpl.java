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

import com.vportal.portlet.vdoc.NoSuchvdocFieldException;
import com.vportal.portlet.vdoc.model.impl.vdocFieldImpl;
import com.vportal.portlet.vdoc.model.impl.vdocFieldModelImpl;
import com.vportal.portlet.vdoc.model.vdocField;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vdoc field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MrEn
 * @see vdocFieldPersistence
 * @see vdocFieldUtil
 * @generated
 */
public class vdocFieldPersistenceImpl extends BasePersistenceImpl<vdocField>
	implements vdocFieldPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vdocFieldUtil} to access the vdoc field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = vdocFieldImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, vdocFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, vdocFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { String.class.getName() },
			vdocFieldModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, vdocFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, vdocFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] { Long.class.getName(), String.class.getName() },
			vdocFieldModelImpl.GROUPID_COLUMN_BITMASK |
			vdocFieldModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_P = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, vdocFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, vdocFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			vdocFieldModelImpl.GROUPID_COLUMN_BITMASK |
			vdocFieldModelImpl.LANGUAGE_COLUMN_BITMASK |
			vdocFieldModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_P = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, vdocFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, vdocFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vdoc field in the entity cache if it is enabled.
	 *
	 * @param vdocField the vdoc field
	 */
	public void cacheResult(vdocField vdocField) {
		EntityCacheUtil.putResult(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldImpl.class, vdocField.getPrimaryKey(), vdocField);

		vdocField.resetOriginalValues();
	}

	/**
	 * Caches the vdoc fields in the entity cache if it is enabled.
	 *
	 * @param vdocFields the vdoc fields
	 */
	public void cacheResult(List<vdocField> vdocFields) {
		for (vdocField vdocField : vdocFields) {
			if (EntityCacheUtil.getResult(
						vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
						vdocFieldImpl.class, vdocField.getPrimaryKey()) == null) {
				cacheResult(vdocField);
			}
			else {
				vdocField.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vdoc fields.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(vdocFieldImpl.class.getName());
		}

		EntityCacheUtil.clearCache(vdocFieldImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vdoc field.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(vdocField vdocField) {
		EntityCacheUtil.removeResult(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldImpl.class, vdocField.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<vdocField> vdocFields) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (vdocField vdocField : vdocFields) {
			EntityCacheUtil.removeResult(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
				vdocFieldImpl.class, vdocField.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vdoc field with the primary key. Does not add the vdoc field to the database.
	 *
	 * @param fieldId the primary key for the new vdoc field
	 * @return the new vdoc field
	 */
	public vdocField create(String fieldId) {
		vdocField vdocField = new vdocFieldImpl();

		vdocField.setNew(true);
		vdocField.setPrimaryKey(fieldId);

		return vdocField;
	}

	/**
	 * Removes the vdoc field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fieldId the primary key of the vdoc field
	 * @return the vdoc field that was removed
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField remove(String fieldId)
		throws NoSuchvdocFieldException, SystemException {
		return remove((Serializable)fieldId);
	}

	/**
	 * Removes the vdoc field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vdoc field
	 * @return the vdoc field that was removed
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocField remove(Serializable primaryKey)
		throws NoSuchvdocFieldException, SystemException {
		Session session = null;

		try {
			session = openSession();

			vdocField vdocField = (vdocField)session.get(vdocFieldImpl.class,
					primaryKey);

			if (vdocField == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchvdocFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vdocField);
		}
		catch (NoSuchvdocFieldException nsee) {
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
	protected vdocField removeImpl(vdocField vdocField)
		throws SystemException {
		vdocField = toUnwrappedModel(vdocField);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vdocField);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vdocField);

		return vdocField;
	}

	@Override
	public vdocField updateImpl(
		com.vportal.portlet.vdoc.model.vdocField vdocField, boolean merge)
		throws SystemException {
		vdocField = toUnwrappedModel(vdocField);

		boolean isNew = vdocField.isNew();

		vdocFieldModelImpl vdocFieldModelImpl = (vdocFieldModelImpl)vdocField;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vdocField, merge);

			vdocField.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !vdocFieldModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vdocFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vdocFieldModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] { vdocFieldModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((vdocFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vdocFieldModelImpl.getOriginalGroupId()),
						
						vdocFieldModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);

				args = new Object[] {
						Long.valueOf(vdocFieldModelImpl.getGroupId()),
						
						vdocFieldModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);
			}

			if ((vdocFieldModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vdocFieldModelImpl.getOriginalGroupId()),
						
						vdocFieldModelImpl.getOriginalLanguage(),
						
						vdocFieldModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P,
					args);

				args = new Object[] {
						Long.valueOf(vdocFieldModelImpl.getGroupId()),
						
						vdocFieldModelImpl.getLanguage(),
						
						vdocFieldModelImpl.getParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_P, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_P,
					args);
			}
		}

		EntityCacheUtil.putResult(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
			vdocFieldImpl.class, vdocField.getPrimaryKey(), vdocField);

		return vdocField;
	}

	protected vdocField toUnwrappedModel(vdocField vdocField) {
		if (vdocField instanceof vdocFieldImpl) {
			return vdocField;
		}

		vdocFieldImpl vdocFieldImpl = new vdocFieldImpl();

		vdocFieldImpl.setNew(vdocField.isNew());
		vdocFieldImpl.setPrimaryKey(vdocField.getPrimaryKey());

		vdocFieldImpl.setFieldId(vdocField.getFieldId());
		vdocFieldImpl.setGroupId(vdocField.getGroupId());
		vdocFieldImpl.setCompanyId(vdocField.getCompanyId());
		vdocFieldImpl.setUserId(vdocField.getUserId());
		vdocFieldImpl.setCreatedDate(vdocField.getCreatedDate());
		vdocFieldImpl.setModifiedDate(vdocField.getModifiedDate());
		vdocFieldImpl.setCreatedByUser(vdocField.getCreatedByUser());
		vdocFieldImpl.setModifiedByUser(vdocField.getModifiedByUser());
		vdocFieldImpl.setParentId(vdocField.getParentId());
		vdocFieldImpl.setName(vdocField.getName());
		vdocFieldImpl.setDescription(vdocField.getDescription());
		vdocFieldImpl.setLanguage(vdocField.getLanguage());
		vdocFieldImpl.setStatusField(vdocField.isStatusField());
		vdocFieldImpl.setPosition(vdocField.getPosition());
		vdocFieldImpl.setListparent(vdocField.getListparent());

		return vdocFieldImpl;
	}

	/**
	 * Returns the vdoc field with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vdoc field
	 * @return the vdoc field
	 * @throws com.liferay.portal.NoSuchModelException if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vdoc field with the primary key or throws a {@link com.vportal.portlet.vdoc.NoSuchvdocFieldException} if it could not be found.
	 *
	 * @param fieldId the primary key of the vdoc field
	 * @return the vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField findByPrimaryKey(String fieldId)
		throws NoSuchvdocFieldException, SystemException {
		vdocField vdocField = fetchByPrimaryKey(fieldId);

		if (vdocField == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + fieldId);
			}

			throw new NoSuchvdocFieldException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				fieldId);
		}

		return vdocField;
	}

	/**
	 * Returns the vdoc field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vdoc field
	 * @return the vdoc field, or <code>null</code> if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public vdocField fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vdoc field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fieldId the primary key of the vdoc field
	 * @return the vdoc field, or <code>null</code> if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField fetchByPrimaryKey(String fieldId)
		throws SystemException {
		vdocField vdocField = (vdocField)EntityCacheUtil.getResult(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
				vdocFieldImpl.class, fieldId);

		if (vdocField == _nullvdocField) {
			return null;
		}

		if (vdocField == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vdocField = (vdocField)session.get(vdocFieldImpl.class, fieldId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vdocField != null) {
					cacheResult(vdocField);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(vdocFieldModelImpl.ENTITY_CACHE_ENABLED,
						vdocFieldImpl.class, fieldId, _nullvdocField);
				}

				closeSession(session);
			}
		}

		return vdocField;
	}

	/**
	 * Returns all the vdoc fields where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByParentId(String parentId)
		throws SystemException {
		return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vdoc fields where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vdoc fields
	 * @param end the upper bound of the range of vdoc fields (not inclusive)
	 * @return the range of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByParentId(String parentId, int start, int end)
		throws SystemException {
		return findByParentId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc fields where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vdoc fields
	 * @param end the upper bound of the range of vdoc fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByParentId(String parentId, int start, int end,
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

		List<vdocField> list = (List<vdocField>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VDOCFIELD_WHERE);

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
				query.append(vdocFieldModelImpl.ORDER_BY_JPQL);
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

				list = (List<vdocField>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vdoc field in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField findByParentId_First(String parentId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		List<vdocField> list = findByParentId(parentId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocFieldException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vdoc field in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField findByParentId_Last(String parentId,
		OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		int count = countByParentId(parentId);

		List<vdocField> list = findByParentId(parentId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentId=");
			msg.append(parentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocFieldException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vdoc fields before and after the current vdoc field in the ordered set where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fieldId the primary key of the current vdoc field
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField[] findByParentId_PrevAndNext(String fieldId,
		String parentId, OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		vdocField vdocField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			vdocField[] array = new vdocFieldImpl[3];

			array[0] = getByParentId_PrevAndNext(session, vdocField, parentId,
					orderByComparator, true);

			array[1] = vdocField;

			array[2] = getByParentId_PrevAndNext(session, vdocField, parentId,
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

	protected vdocField getByParentId_PrevAndNext(Session session,
		vdocField vdocField, String parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VDOCFIELD_WHERE);

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
			query.append(vdocFieldModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vdocField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<vdocField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vdoc fields where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByG_L(long groupId, String language)
		throws SystemException {
		return findByG_L(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc fields where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vdoc fields
	 * @param end the upper bound of the range of vdoc fields (not inclusive)
	 * @return the range of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByG_L(long groupId, String language, int start,
		int end) throws SystemException {
		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc fields where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vdoc fields
	 * @param end the upper bound of the range of vdoc fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByG_L(long groupId, String language, int start,
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

		List<vdocField> list = (List<vdocField>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VDOCFIELD_WHERE);

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
				query.append(vdocFieldModelImpl.ORDER_BY_JPQL);
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

				list = (List<vdocField>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vdoc field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField findByG_L_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		List<vdocField> list = findByG_L(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocFieldException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vdoc field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField findByG_L_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		int count = countByG_L(groupId, language);

		List<vdocField> list = findByG_L(groupId, language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchvdocFieldException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vdoc fields before and after the current vdoc field in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fieldId the primary key of the current vdoc field
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField[] findByG_L_PrevAndNext(String fieldId, long groupId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		vdocField vdocField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			vdocField[] array = new vdocFieldImpl[3];

			array[0] = getByG_L_PrevAndNext(session, vdocField, groupId,
					language, orderByComparator, true);

			array[1] = vdocField;

			array[2] = getByG_L_PrevAndNext(session, vdocField, groupId,
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

	protected vdocField getByG_L_PrevAndNext(Session session,
		vdocField vdocField, long groupId, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VDOCFIELD_WHERE);

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
			query.append(vdocFieldModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vdocField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<vdocField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByG_L_P(long groupId, String language,
		String parentId) throws SystemException {
		return findByG_L_P(groupId, language, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vdoc fields
	 * @param end the upper bound of the range of vdoc fields (not inclusive)
	 * @return the range of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByG_L_P(long groupId, String language,
		String parentId, int start, int end) throws SystemException {
		return findByG_L_P(groupId, language, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of vdoc fields
	 * @param end the upper bound of the range of vdoc fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findByG_L_P(long groupId, String language,
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

		List<vdocField> list = (List<vdocField>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VDOCFIELD_WHERE);

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
				query.append(vdocFieldModelImpl.ORDER_BY_JPQL);
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

				list = (List<vdocField>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vdoc field in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField findByG_L_P_First(long groupId, String language,
		String parentId, OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		List<vdocField> list = findByG_L_P(groupId, language, parentId, 0, 1,
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

			throw new NoSuchvdocFieldException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vdoc field in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a matching vdoc field could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField findByG_L_P_Last(long groupId, String language,
		String parentId, OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		int count = countByG_L_P(groupId, language, parentId);

		List<vdocField> list = findByG_L_P(groupId, language, parentId,
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

			throw new NoSuchvdocFieldException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vdoc fields before and after the current vdoc field in the ordered set where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param fieldId the primary key of the current vdoc field
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vdoc field
	 * @throws com.vportal.portlet.vdoc.NoSuchvdocFieldException if a vdoc field with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public vdocField[] findByG_L_P_PrevAndNext(String fieldId, long groupId,
		String language, String parentId, OrderByComparator orderByComparator)
		throws NoSuchvdocFieldException, SystemException {
		vdocField vdocField = findByPrimaryKey(fieldId);

		Session session = null;

		try {
			session = openSession();

			vdocField[] array = new vdocFieldImpl[3];

			array[0] = getByG_L_P_PrevAndNext(session, vdocField, groupId,
					language, parentId, orderByComparator, true);

			array[1] = vdocField;

			array[2] = getByG_L_P_PrevAndNext(session, vdocField, groupId,
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

	protected vdocField getByG_L_P_PrevAndNext(Session session,
		vdocField vdocField, long groupId, String language, String parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VDOCFIELD_WHERE);

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
			query.append(vdocFieldModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vdocField);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<vdocField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vdoc fields.
	 *
	 * @return the vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vdoc fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vdoc fields
	 * @param end the upper bound of the range of vdoc fields (not inclusive)
	 * @return the range of vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vdoc fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vdoc fields
	 * @param end the upper bound of the range of vdoc fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public List<vdocField> findAll(int start, int end,
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

		List<vdocField> list = (List<vdocField>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VDOCFIELD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VDOCFIELD.concat(vdocFieldModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<vdocField>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<vdocField>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vdoc fields where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByParentId(String parentId) throws SystemException {
		for (vdocField vdocField : findByParentId(parentId)) {
			remove(vdocField);
		}
	}

	/**
	 * Removes all the vdoc fields where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L(long groupId, String language)
		throws SystemException {
		for (vdocField vdocField : findByG_L(groupId, language)) {
			remove(vdocField);
		}
	}

	/**
	 * Removes all the vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L_P(long groupId, String language, String parentId)
		throws SystemException {
		for (vdocField vdocField : findByG_L_P(groupId, language, parentId)) {
			remove(vdocField);
		}
	}

	/**
	 * Removes all the vdoc fields from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (vdocField vdocField : findAll()) {
			remove(vdocField);
		}
	}

	/**
	 * Returns the number of vdoc fields where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public int countByParentId(String parentId) throws SystemException {
		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VDOCFIELD_WHERE);

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
	 * Returns the number of vdoc fields where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VDOCFIELD_WHERE);

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
	 * Returns the number of vdoc fields where groupId = &#63; and language = &#63; and parentId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param parentId the parent ID
	 * @return the number of matching vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L_P(long groupId, String language, String parentId)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language, parentId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L_P,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VDOCFIELD_WHERE);

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
	 * Returns the number of vdoc fields.
	 *
	 * @return the number of vdoc fields
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VDOCFIELD);

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
	 * Initializes the vdoc field persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vdoc.model.vdocField")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<vdocField>> listenersList = new ArrayList<ModelListener<vdocField>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<vdocField>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(vdocFieldImpl.class.getName());
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
	private static final String _SQL_SELECT_VDOCFIELD = "SELECT vdocField FROM vdocField vdocField";
	private static final String _SQL_SELECT_VDOCFIELD_WHERE = "SELECT vdocField FROM vdocField vdocField WHERE ";
	private static final String _SQL_COUNT_VDOCFIELD = "SELECT COUNT(vdocField) FROM vdocField vdocField";
	private static final String _SQL_COUNT_VDOCFIELD_WHERE = "SELECT COUNT(vdocField) FROM vdocField vdocField WHERE ";
	private static final String _FINDER_COLUMN_PARENTID_PARENTID_1 = "vdocField.parentId IS NULL";
	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "vdocField.parentId = ?";
	private static final String _FINDER_COLUMN_PARENTID_PARENTID_3 = "(vdocField.parentId IS NULL OR vdocField.parentId = ?)";
	private static final String _FINDER_COLUMN_G_L_GROUPID_2 = "vdocField.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_1 = "vdocField.language IS NULL";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 = "vdocField.language = ?";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 = "(vdocField.language IS NULL OR vdocField.language = ?)";
	private static final String _FINDER_COLUMN_G_L_P_GROUPID_2 = "vdocField.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_1 = "vdocField.language IS NULL AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_2 = "vdocField.language = ? AND ";
	private static final String _FINDER_COLUMN_G_L_P_LANGUAGE_3 = "(vdocField.language IS NULL OR vdocField.language = ?) AND ";
	private static final String _FINDER_COLUMN_G_L_P_PARENTID_1 = "vdocField.parentId IS NULL";
	private static final String _FINDER_COLUMN_G_L_P_PARENTID_2 = "vdocField.parentId = ?";
	private static final String _FINDER_COLUMN_G_L_P_PARENTID_3 = "(vdocField.parentId IS NULL OR vdocField.parentId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vdocField.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No vdocField exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No vdocField exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(vdocFieldPersistenceImpl.class);
	private static vdocField _nullvdocField = new vdocFieldImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<vdocField> toCacheModel() {
				return _nullvdocFieldCacheModel;
			}
		};

	private static CacheModel<vdocField> _nullvdocFieldCacheModel = new CacheModel<vdocField>() {
			public vdocField toEntityModel() {
				return _nullvdocField;
			}
		};
}