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

import com.vportal.portlet.vcms.NoSuchVcmsTypeException;
import com.vportal.portlet.vcms.model.VcmsType;
import com.vportal.portlet.vcms.model.impl.VcmsTypeImpl;
import com.vportal.portlet.vcms.model.impl.VcmsTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsTypePersistence
 * @see VcmsTypeUtil
 * @generated
 */
public class VcmsTypePersistenceImpl extends BasePersistenceImpl<VcmsType>
	implements VcmsTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsTypeUtil} to access the vcms type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_S_C = new FinderPath(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeModelImpl.FINDER_CACHE_ENABLED, VcmsTypeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByS_C",
			new String[] { Long.class.getName(), String.class.getName() },
			VcmsTypeModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsTypeModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_C = new FinderPath(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_C",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_L = new FinderPath(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeModelImpl.FINDER_CACHE_ENABLED, VcmsTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L = new FinderPath(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeModelImpl.FINDER_CACHE_ENABLED, VcmsTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_L",
			new String[] { Long.class.getName(), String.class.getName() },
			VcmsTypeModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsTypeModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_L = new FinderPath(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeModelImpl.FINDER_CACHE_ENABLED, VcmsTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeModelImpl.FINDER_CACHE_ENABLED, VcmsTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms type in the entity cache if it is enabled.
	 *
	 * @param vcmsType the vcms type
	 */
	public void cacheResult(VcmsType vcmsType) {
		EntityCacheUtil.putResult(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeImpl.class, vcmsType.getPrimaryKey(), vcmsType);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
			new Object[] { Long.valueOf(vcmsType.getGroupId()), vcmsType.getCode() },
			vcmsType);

		vcmsType.resetOriginalValues();
	}

	/**
	 * Caches the vcms types in the entity cache if it is enabled.
	 *
	 * @param vcmsTypes the vcms types
	 */
	public void cacheResult(List<VcmsType> vcmsTypes) {
		for (VcmsType vcmsType : vcmsTypes) {
			if (EntityCacheUtil.getResult(
						VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
						VcmsTypeImpl.class, vcmsType.getPrimaryKey()) == null) {
				cacheResult(vcmsType);
			}
			else {
				vcmsType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsType vcmsType) {
		EntityCacheUtil.removeResult(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeImpl.class, vcmsType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vcmsType);
	}

	@Override
	public void clearCache(List<VcmsType> vcmsTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsType vcmsType : vcmsTypes) {
			EntityCacheUtil.removeResult(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
				VcmsTypeImpl.class, vcmsType.getPrimaryKey());

			clearUniqueFindersCache(vcmsType);
		}
	}

	protected void clearUniqueFindersCache(VcmsType vcmsType) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_C,
			new Object[] { Long.valueOf(vcmsType.getGroupId()), vcmsType.getCode() });
	}

	/**
	 * Creates a new vcms type with the primary key. Does not add the vcms type to the database.
	 *
	 * @param typeId the primary key for the new vcms type
	 * @return the new vcms type
	 */
	public VcmsType create(String typeId) {
		VcmsType vcmsType = new VcmsTypeImpl();

		vcmsType.setNew(true);
		vcmsType.setPrimaryKey(typeId);

		return vcmsType;
	}

	/**
	 * Removes the vcms type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param typeId the primary key of the vcms type
	 * @return the vcms type that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTypeException if a vcms type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType remove(String typeId)
		throws NoSuchVcmsTypeException, SystemException {
		return remove((Serializable)typeId);
	}

	/**
	 * Removes the vcms type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms type
	 * @return the vcms type that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTypeException if a vcms type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsType remove(Serializable primaryKey)
		throws NoSuchVcmsTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsType vcmsType = (VcmsType)session.get(VcmsTypeImpl.class,
					primaryKey);

			if (vcmsType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsType);
		}
		catch (NoSuchVcmsTypeException nsee) {
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
	protected VcmsType removeImpl(VcmsType vcmsType) throws SystemException {
		vcmsType = toUnwrappedModel(vcmsType);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsType);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsType);

		return vcmsType;
	}

	@Override
	public VcmsType updateImpl(
		com.vportal.portlet.vcms.model.VcmsType vcmsType, boolean merge)
		throws SystemException {
		vcmsType = toUnwrappedModel(vcmsType);

		boolean isNew = vcmsType.isNew();

		VcmsTypeModelImpl vcmsTypeModelImpl = (VcmsTypeModelImpl)vcmsType;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsType, merge);

			vcmsType.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsTypeModelImpl.getOriginalGroupId()),
						
						vcmsTypeModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L,
					args);

				args = new Object[] {
						Long.valueOf(vcmsTypeModelImpl.getGroupId()),
						
						vcmsTypeModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
			VcmsTypeImpl.class, vcmsType.getPrimaryKey(), vcmsType);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
				new Object[] {
					Long.valueOf(vcmsType.getGroupId()),
					
				vcmsType.getCode()
				}, vcmsType);
		}
		else {
			if ((vcmsTypeModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_S_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsTypeModelImpl.getOriginalGroupId()),
						
						vcmsTypeModelImpl.getOriginalCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_C, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
					new Object[] {
						Long.valueOf(vcmsType.getGroupId()),
						
					vcmsType.getCode()
					}, vcmsType);
			}
		}

		return vcmsType;
	}

	protected VcmsType toUnwrappedModel(VcmsType vcmsType) {
		if (vcmsType instanceof VcmsTypeImpl) {
			return vcmsType;
		}

		VcmsTypeImpl vcmsTypeImpl = new VcmsTypeImpl();

		vcmsTypeImpl.setNew(vcmsType.isNew());
		vcmsTypeImpl.setPrimaryKey(vcmsType.getPrimaryKey());

		vcmsTypeImpl.setTypeId(vcmsType.getTypeId());
		vcmsTypeImpl.setGroupId(vcmsType.getGroupId());
		vcmsTypeImpl.setCompanyId(vcmsType.getCompanyId());
		vcmsTypeImpl.setCreatedDate(vcmsType.getCreatedDate());
		vcmsTypeImpl.setCreatedByUser(vcmsType.getCreatedByUser());
		vcmsTypeImpl.setModifiedDate(vcmsType.getModifiedDate());
		vcmsTypeImpl.setModifiedByUser(vcmsType.getModifiedByUser());
		vcmsTypeImpl.setCode(vcmsType.getCode());
		vcmsTypeImpl.setName(vcmsType.getName());
		vcmsTypeImpl.setDescription(vcmsType.getDescription());
		vcmsTypeImpl.setLanguage(vcmsType.getLanguage());

		return vcmsTypeImpl;
	}

	/**
	 * Returns the vcms type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms type
	 * @return the vcms type
	 * @throws com.liferay.portal.NoSuchModelException if a vcms type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms type with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsTypeException} if it could not be found.
	 *
	 * @param typeId the primary key of the vcms type
	 * @return the vcms type
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTypeException if a vcms type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType findByPrimaryKey(String typeId)
		throws NoSuchVcmsTypeException, SystemException {
		VcmsType vcmsType = fetchByPrimaryKey(typeId);

		if (vcmsType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + typeId);
			}

			throw new NoSuchVcmsTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				typeId);
		}

		return vcmsType;
	}

	/**
	 * Returns the vcms type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms type
	 * @return the vcms type, or <code>null</code> if a vcms type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param typeId the primary key of the vcms type
	 * @return the vcms type, or <code>null</code> if a vcms type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType fetchByPrimaryKey(String typeId) throws SystemException {
		VcmsType vcmsType = (VcmsType)EntityCacheUtil.getResult(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
				VcmsTypeImpl.class, typeId);

		if (vcmsType == _nullVcmsType) {
			return null;
		}

		if (vcmsType == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsType = (VcmsType)session.get(VcmsTypeImpl.class, typeId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsType != null) {
					cacheResult(vcmsType);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsTypeModelImpl.ENTITY_CACHE_ENABLED,
						VcmsTypeImpl.class, typeId, _nullVcmsType);
				}

				closeSession(session);
			}
		}

		return vcmsType;
	}

	/**
	 * Returns the vcms type where groupId = &#63; and code = &#63; or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsTypeException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @return the matching vcms type
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTypeException if a matching vcms type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType findByS_C(long groupId, String code)
		throws NoSuchVcmsTypeException, SystemException {
		VcmsType vcmsType = fetchByS_C(groupId, code);

		if (vcmsType == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVcmsTypeException(msg.toString());
		}

		return vcmsType;
	}

	/**
	 * Returns the vcms type where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @return the matching vcms type, or <code>null</code> if a matching vcms type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType fetchByS_C(long groupId, String code)
		throws SystemException {
		return fetchByS_C(groupId, code, true);
	}

	/**
	 * Returns the vcms type where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vcms type, or <code>null</code> if a matching vcms type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType fetchByS_C(long groupId, String code,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_S_C,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VCMSTYPE_WHERE);

			query.append(_FINDER_COLUMN_S_C_GROUPID_2);

			if (code == null) {
				query.append(_FINDER_COLUMN_S_C_CODE_1);
			}
			else {
				if (code.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_C_CODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_C_CODE_2);
				}
			}

			query.append(VcmsTypeModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (code != null) {
					qPos.add(code);
				}

				List<VcmsType> list = q.list();

				result = list;

				VcmsType vcmsType = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
						finderArgs, list);
				}
				else {
					vcmsType = list.get(0);

					cacheResult(vcmsType);

					if ((vcmsType.getGroupId() != groupId) ||
							(vcmsType.getCode() == null) ||
							!vcmsType.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S_C,
							finderArgs, vcmsType);
					}
				}

				return vcmsType;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S_C,
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
				return (VcmsType)result;
			}
		}
	}

	/**
	 * Returns all the vcms types where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsType> findByS_L(long groupId, String language)
		throws SystemException {
		return findByS_L(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms types where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms types
	 * @param end the upper bound of the range of vcms types (not inclusive)
	 * @return the range of matching vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsType> findByS_L(long groupId, String language, int start,
		int end) throws SystemException {
		return findByS_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms types where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of vcms types
	 * @param end the upper bound of the range of vcms types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsType> findByS_L(long groupId, String language, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_L;
			finderArgs = new Object[] { groupId, language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_S_L;
			finderArgs = new Object[] {
					groupId, language,
					
					start, end, orderByComparator
				};
		}

		List<VcmsType> list = (List<VcmsType>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSTYPE_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<VcmsType>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first vcms type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms type
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTypeException if a matching vcms type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType findByS_L_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsTypeException, SystemException {
		List<VcmsType> list = findByS_L(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms type
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTypeException if a matching vcms type could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType findByS_L_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsTypeException, SystemException {
		int count = countByS_L(groupId, language);

		List<VcmsType> list = findByS_L(groupId, language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsTypeException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms types before and after the current vcms type in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param typeId the primary key of the current vcms type
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms type
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsTypeException if a vcms type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsType[] findByS_L_PrevAndNext(String typeId, long groupId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchVcmsTypeException, SystemException {
		VcmsType vcmsType = findByPrimaryKey(typeId);

		Session session = null;

		try {
			session = openSession();

			VcmsType[] array = new VcmsTypeImpl[3];

			array[0] = getByS_L_PrevAndNext(session, vcmsType, groupId,
					language, orderByComparator, true);

			array[1] = vcmsType;

			array[2] = getByS_L_PrevAndNext(session, vcmsType, groupId,
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

	protected VcmsType getByS_L_PrevAndNext(Session session, VcmsType vcmsType,
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

		query.append(_SQL_SELECT_VCMSTYPE_WHERE);

		query.append(_FINDER_COLUMN_S_L_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_S_L_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
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
			query.append(VcmsTypeModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsType);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms types.
	 *
	 * @return the vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms types
	 * @param end the upper bound of the range of vcms types (not inclusive)
	 * @return the range of vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms types
	 * @param end the upper bound of the range of vcms types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsType> findAll(int start, int end,
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

		List<VcmsType> list = (List<VcmsType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSTYPE.concat(VcmsTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsType>)QueryUtil.list(q, getDialect(),
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
	 * Removes the vcms type where groupId = &#63; and code = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByS_C(long groupId, String code)
		throws NoSuchVcmsTypeException, SystemException {
		VcmsType vcmsType = findByS_C(groupId, code);

		remove(vcmsType);
	}

	/**
	 * Removes all the vcms types where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByS_L(long groupId, String language)
		throws SystemException {
		for (VcmsType vcmsType : findByS_L(groupId, language)) {
			remove(vcmsType);
		}
	}

	/**
	 * Removes all the vcms types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsType vcmsType : findAll()) {
			remove(vcmsType);
		}
	}

	/**
	 * Returns the number of vcms types where groupId = &#63; and code = &#63;.
	 *
	 * @param groupId the group ID
	 * @param code the code
	 * @return the number of matching vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public int countByS_C(long groupId, String code) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_S_C,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSTYPE_WHERE);

			query.append(_FINDER_COLUMN_S_C_GROUPID_2);

			if (code == null) {
				query.append(_FINDER_COLUMN_S_C_CODE_1);
			}
			else {
				if (code.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_C_CODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_C_CODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (code != null) {
					qPos.add(code);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms types where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public int countByS_L(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_S_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSTYPE_WHERE);

			query.append(_FINDER_COLUMN_S_L_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_S_L_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_S_L_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_S_L_LANGUAGE_2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S_L, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms types.
	 *
	 * @return the number of vcms types
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSTYPE);

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
	 * Initializes the vcms type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsType>> listenersList = new ArrayList<ModelListener<VcmsType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsTypeImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSTYPE = "SELECT vcmsType FROM VcmsType vcmsType";
	private static final String _SQL_SELECT_VCMSTYPE_WHERE = "SELECT vcmsType FROM VcmsType vcmsType WHERE ";
	private static final String _SQL_COUNT_VCMSTYPE = "SELECT COUNT(vcmsType) FROM VcmsType vcmsType";
	private static final String _SQL_COUNT_VCMSTYPE_WHERE = "SELECT COUNT(vcmsType) FROM VcmsType vcmsType WHERE ";
	private static final String _FINDER_COLUMN_S_C_GROUPID_2 = "vcmsType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_S_C_CODE_1 = "vcmsType.code IS NULL";
	private static final String _FINDER_COLUMN_S_C_CODE_2 = "vcmsType.code = ?";
	private static final String _FINDER_COLUMN_S_C_CODE_3 = "(vcmsType.code IS NULL OR vcmsType.code = ?)";
	private static final String _FINDER_COLUMN_S_L_GROUPID_2 = "vcmsType.groupId = ? AND ";
	private static final String _FINDER_COLUMN_S_L_LANGUAGE_1 = "vcmsType.language IS NULL";
	private static final String _FINDER_COLUMN_S_L_LANGUAGE_2 = "vcmsType.language = ?";
	private static final String _FINDER_COLUMN_S_L_LANGUAGE_3 = "(vcmsType.language IS NULL OR vcmsType.language = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsType exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsType exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsTypePersistenceImpl.class);
	private static VcmsType _nullVcmsType = new VcmsTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsType> toCacheModel() {
				return _nullVcmsTypeCacheModel;
			}
		};

	private static CacheModel<VcmsType> _nullVcmsTypeCacheModel = new CacheModel<VcmsType>() {
			public VcmsType toEntityModel() {
				return _nullVcmsType;
			}
		};
}