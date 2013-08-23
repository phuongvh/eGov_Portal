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

import com.vportal.portlet.vcms.NoSuchVcmsArticleVersionException;
import com.vportal.portlet.vcms.model.VcmsArticleVersion;
import com.vportal.portlet.vcms.model.impl.VcmsArticleVersionImpl;
import com.vportal.portlet.vcms.model.impl.VcmsArticleVersionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms article version service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsArticleVersionPersistence
 * @see VcmsArticleVersionUtil
 * @generated
 */
public class VcmsArticleVersionPersistenceImpl extends BasePersistenceImpl<VcmsArticleVersion>
	implements VcmsArticleVersionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsArticleVersionUtil} to access the vcms article version persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsArticleVersionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLE = new FinderPath(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE =
		new FinderPath(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] { String.class.getName() },
			VcmsArticleVersionModelImpl.ARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLE = new FinderPath(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionModelImpl.FINDER_CACHE_ENABLED,
			VcmsArticleVersionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms article version in the entity cache if it is enabled.
	 *
	 * @param vcmsArticleVersion the vcms article version
	 */
	public void cacheResult(VcmsArticleVersion vcmsArticleVersion) {
		EntityCacheUtil.putResult(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionImpl.class, vcmsArticleVersion.getPrimaryKey(),
			vcmsArticleVersion);

		vcmsArticleVersion.resetOriginalValues();
	}

	/**
	 * Caches the vcms article versions in the entity cache if it is enabled.
	 *
	 * @param vcmsArticleVersions the vcms article versions
	 */
	public void cacheResult(List<VcmsArticleVersion> vcmsArticleVersions) {
		for (VcmsArticleVersion vcmsArticleVersion : vcmsArticleVersions) {
			if (EntityCacheUtil.getResult(
						VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
						VcmsArticleVersionImpl.class,
						vcmsArticleVersion.getPrimaryKey()) == null) {
				cacheResult(vcmsArticleVersion);
			}
			else {
				vcmsArticleVersion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms article versions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsArticleVersionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsArticleVersionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms article version.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsArticleVersion vcmsArticleVersion) {
		EntityCacheUtil.removeResult(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionImpl.class, vcmsArticleVersion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsArticleVersion> vcmsArticleVersions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsArticleVersion vcmsArticleVersion : vcmsArticleVersions) {
			EntityCacheUtil.removeResult(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
				VcmsArticleVersionImpl.class, vcmsArticleVersion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms article version with the primary key. Does not add the vcms article version to the database.
	 *
	 * @param articleVersionId the primary key for the new vcms article version
	 * @return the new vcms article version
	 */
	public VcmsArticleVersion create(long articleVersionId) {
		VcmsArticleVersion vcmsArticleVersion = new VcmsArticleVersionImpl();

		vcmsArticleVersion.setNew(true);
		vcmsArticleVersion.setPrimaryKey(articleVersionId);

		return vcmsArticleVersion;
	}

	/**
	 * Removes the vcms article version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleVersionId the primary key of the vcms article version
	 * @return the vcms article version that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleVersionException if a vcms article version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleVersion remove(long articleVersionId)
		throws NoSuchVcmsArticleVersionException, SystemException {
		return remove(Long.valueOf(articleVersionId));
	}

	/**
	 * Removes the vcms article version with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms article version
	 * @return the vcms article version that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleVersionException if a vcms article version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticleVersion remove(Serializable primaryKey)
		throws NoSuchVcmsArticleVersionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsArticleVersion vcmsArticleVersion = (VcmsArticleVersion)session.get(VcmsArticleVersionImpl.class,
					primaryKey);

			if (vcmsArticleVersion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsArticleVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsArticleVersion);
		}
		catch (NoSuchVcmsArticleVersionException nsee) {
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
	protected VcmsArticleVersion removeImpl(
		VcmsArticleVersion vcmsArticleVersion) throws SystemException {
		vcmsArticleVersion = toUnwrappedModel(vcmsArticleVersion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsArticleVersion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsArticleVersion);

		return vcmsArticleVersion;
	}

	@Override
	public VcmsArticleVersion updateImpl(
		com.vportal.portlet.vcms.model.VcmsArticleVersion vcmsArticleVersion,
		boolean merge) throws SystemException {
		vcmsArticleVersion = toUnwrappedModel(vcmsArticleVersion);

		boolean isNew = vcmsArticleVersion.isNew();

		VcmsArticleVersionModelImpl vcmsArticleVersionModelImpl = (VcmsArticleVersionModelImpl)vcmsArticleVersion;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsArticleVersion, merge);

			vcmsArticleVersion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsArticleVersionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsArticleVersionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsArticleVersionModelImpl.getOriginalArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);

				args = new Object[] { vcmsArticleVersionModelImpl.getArticleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
			VcmsArticleVersionImpl.class, vcmsArticleVersion.getPrimaryKey(),
			vcmsArticleVersion);

		return vcmsArticleVersion;
	}

	protected VcmsArticleVersion toUnwrappedModel(
		VcmsArticleVersion vcmsArticleVersion) {
		if (vcmsArticleVersion instanceof VcmsArticleVersionImpl) {
			return vcmsArticleVersion;
		}

		VcmsArticleVersionImpl vcmsArticleVersionImpl = new VcmsArticleVersionImpl();

		vcmsArticleVersionImpl.setNew(vcmsArticleVersion.isNew());
		vcmsArticleVersionImpl.setPrimaryKey(vcmsArticleVersion.getPrimaryKey());

		vcmsArticleVersionImpl.setArticleVersionId(vcmsArticleVersion.getArticleVersionId());
		vcmsArticleVersionImpl.setGroupId(vcmsArticleVersion.getGroupId());
		vcmsArticleVersionImpl.setCompanyId(vcmsArticleVersion.getCompanyId());
		vcmsArticleVersionImpl.setArticleId(vcmsArticleVersion.getArticleId());
		vcmsArticleVersionImpl.setCreatedByUser(vcmsArticleVersion.getCreatedByUser());
		vcmsArticleVersionImpl.setCreatedDate(vcmsArticleVersion.getCreatedDate());
		vcmsArticleVersionImpl.setTypeIds(vcmsArticleVersion.getTypeIds());
		vcmsArticleVersionImpl.setStatus(vcmsArticleVersion.getStatus());
		vcmsArticleVersionImpl.setVersionName(vcmsArticleVersion.getVersionName());
		vcmsArticleVersionImpl.setTitle(vcmsArticleVersion.getTitle());
		vcmsArticleVersionImpl.setLead(vcmsArticleVersion.getLead());
		vcmsArticleVersionImpl.setContent(vcmsArticleVersion.getContent());
		vcmsArticleVersionImpl.setHasImage(vcmsArticleVersion.isHasImage());
		vcmsArticleVersionImpl.setImageTitle(vcmsArticleVersion.getImageTitle());
		vcmsArticleVersionImpl.setImage(vcmsArticleVersion.getImage());
		vcmsArticleVersionImpl.setLanguage(vcmsArticleVersion.getLanguage());
		vcmsArticleVersionImpl.setUserHit(vcmsArticleVersion.getUserHit());
		vcmsArticleVersionImpl.setAuthor(vcmsArticleVersion.getAuthor());
		vcmsArticleVersionImpl.setSource(vcmsArticleVersion.getSource());
		vcmsArticleVersionImpl.setDiscussible(vcmsArticleVersion.isDiscussible());
		vcmsArticleVersionImpl.setHasAttachment(vcmsArticleVersion.isHasAttachment());
		vcmsArticleVersionImpl.setHasPoll(vcmsArticleVersion.isHasPoll());
		vcmsArticleVersionImpl.setPollId(vcmsArticleVersion.getPollId());
		vcmsArticleVersionImpl.setEffectiveDate(vcmsArticleVersion.getEffectiveDate());
		vcmsArticleVersionImpl.setExpireDate(vcmsArticleVersion.getExpireDate());
		vcmsArticleVersionImpl.setSticky(vcmsArticleVersion.isSticky());
		vcmsArticleVersionImpl.setStickyNeverExpired(vcmsArticleVersion.isStickyNeverExpired());
		vcmsArticleVersionImpl.setStickyExpireDate(vcmsArticleVersion.getStickyExpireDate());

		return vcmsArticleVersionImpl;
	}

	/**
	 * Returns the vcms article version with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms article version
	 * @return the vcms article version
	 * @throws com.liferay.portal.NoSuchModelException if a vcms article version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticleVersion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vcms article version with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsArticleVersionException} if it could not be found.
	 *
	 * @param articleVersionId the primary key of the vcms article version
	 * @return the vcms article version
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleVersionException if a vcms article version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleVersion findByPrimaryKey(long articleVersionId)
		throws NoSuchVcmsArticleVersionException, SystemException {
		VcmsArticleVersion vcmsArticleVersion = fetchByPrimaryKey(articleVersionId);

		if (vcmsArticleVersion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + articleVersionId);
			}

			throw new NoSuchVcmsArticleVersionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				articleVersionId);
		}

		return vcmsArticleVersion;
	}

	/**
	 * Returns the vcms article version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms article version
	 * @return the vcms article version, or <code>null</code> if a vcms article version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsArticleVersion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the vcms article version with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleVersionId the primary key of the vcms article version
	 * @return the vcms article version, or <code>null</code> if a vcms article version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleVersion fetchByPrimaryKey(long articleVersionId)
		throws SystemException {
		VcmsArticleVersion vcmsArticleVersion = (VcmsArticleVersion)EntityCacheUtil.getResult(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
				VcmsArticleVersionImpl.class, articleVersionId);

		if (vcmsArticleVersion == _nullVcmsArticleVersion) {
			return null;
		}

		if (vcmsArticleVersion == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsArticleVersion = (VcmsArticleVersion)session.get(VcmsArticleVersionImpl.class,
						Long.valueOf(articleVersionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsArticleVersion != null) {
					cacheResult(vcmsArticleVersion);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsArticleVersionModelImpl.ENTITY_CACHE_ENABLED,
						VcmsArticleVersionImpl.class, articleVersionId,
						_nullVcmsArticleVersion);
				}

				closeSession(session);
			}
		}

		return vcmsArticleVersion;
	}

	/**
	 * Returns all the vcms article versions where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching vcms article versions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleVersion> findByArticle(String articleId)
		throws SystemException {
		return findByArticle(articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms article versions where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms article versions
	 * @param end the upper bound of the range of vcms article versions (not inclusive)
	 * @return the range of matching vcms article versions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleVersion> findByArticle(String articleId, int start,
		int end) throws SystemException {
		return findByArticle(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms article versions where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms article versions
	 * @param end the upper bound of the range of vcms article versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms article versions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleVersion> findByArticle(String articleId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE;
			finderArgs = new Object[] { articleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLE;
			finderArgs = new Object[] { articleId, start, end, orderByComparator };
		}

		List<VcmsArticleVersion> list = (List<VcmsArticleVersion>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSARTICLEVERSION_WHERE);

			if (articleId == null) {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_1);
			}
			else {
				if (articleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsArticleVersionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (articleId != null) {
					qPos.add(articleId);
				}

				list = (List<VcmsArticleVersion>)QueryUtil.list(q,
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
	 * Returns the first vcms article version in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms article version
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleVersionException if a matching vcms article version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleVersion findByArticle_First(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleVersionException, SystemException {
		List<VcmsArticleVersion> list = findByArticle(articleId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleVersionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms article version in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms article version
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleVersionException if a matching vcms article version could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleVersion findByArticle_Last(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleVersionException, SystemException {
		int count = countByArticle(articleId);

		List<VcmsArticleVersion> list = findByArticle(articleId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsArticleVersionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms article versions before and after the current vcms article version in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleVersionId the primary key of the current vcms article version
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms article version
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsArticleVersionException if a vcms article version with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsArticleVersion[] findByArticle_PrevAndNext(
		long articleVersionId, String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsArticleVersionException, SystemException {
		VcmsArticleVersion vcmsArticleVersion = findByPrimaryKey(articleVersionId);

		Session session = null;

		try {
			session = openSession();

			VcmsArticleVersion[] array = new VcmsArticleVersionImpl[3];

			array[0] = getByArticle_PrevAndNext(session, vcmsArticleVersion,
					articleId, orderByComparator, true);

			array[1] = vcmsArticleVersion;

			array[2] = getByArticle_PrevAndNext(session, vcmsArticleVersion,
					articleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsArticleVersion getByArticle_PrevAndNext(Session session,
		VcmsArticleVersion vcmsArticleVersion, String articleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSARTICLEVERSION_WHERE);

		if (articleId == null) {
			query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_1);
		}
		else {
			if (articleId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
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
			query.append(VcmsArticleVersionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (articleId != null) {
			qPos.add(articleId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsArticleVersion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsArticleVersion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms article versions.
	 *
	 * @return the vcms article versions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleVersion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms article versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms article versions
	 * @param end the upper bound of the range of vcms article versions (not inclusive)
	 * @return the range of vcms article versions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleVersion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms article versions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms article versions
	 * @param end the upper bound of the range of vcms article versions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms article versions
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsArticleVersion> findAll(int start, int end,
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

		List<VcmsArticleVersion> list = (List<VcmsArticleVersion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSARTICLEVERSION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSARTICLEVERSION.concat(VcmsArticleVersionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsArticleVersion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsArticleVersion>)QueryUtil.list(q,
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
	 * Removes all the vcms article versions where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByArticle(String articleId) throws SystemException {
		for (VcmsArticleVersion vcmsArticleVersion : findByArticle(articleId)) {
			remove(vcmsArticleVersion);
		}
	}

	/**
	 * Removes all the vcms article versions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsArticleVersion vcmsArticleVersion : findAll()) {
			remove(vcmsArticleVersion);
		}
	}

	/**
	 * Returns the number of vcms article versions where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching vcms article versions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByArticle(String articleId) throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSARTICLEVERSION_WHERE);

			if (articleId == null) {
				query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_1);
			}
			else {
				if (articleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_ARTICLE_ARTICLEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (articleId != null) {
					qPos.add(articleId);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms article versions.
	 *
	 * @return the number of vcms article versions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSARTICLEVERSION);

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
	 * Initializes the vcms article version persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsArticleVersion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsArticleVersion>> listenersList = new ArrayList<ModelListener<VcmsArticleVersion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsArticleVersion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsArticleVersionImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSARTICLEVERSION = "SELECT vcmsArticleVersion FROM VcmsArticleVersion vcmsArticleVersion";
	private static final String _SQL_SELECT_VCMSARTICLEVERSION_WHERE = "SELECT vcmsArticleVersion FROM VcmsArticleVersion vcmsArticleVersion WHERE ";
	private static final String _SQL_COUNT_VCMSARTICLEVERSION = "SELECT COUNT(vcmsArticleVersion) FROM VcmsArticleVersion vcmsArticleVersion";
	private static final String _SQL_COUNT_VCMSARTICLEVERSION_WHERE = "SELECT COUNT(vcmsArticleVersion) FROM VcmsArticleVersion vcmsArticleVersion WHERE ";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_1 = "vcmsArticleVersion.articleId IS NULL";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_2 = "vcmsArticleVersion.articleId = ?";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_3 = "(vcmsArticleVersion.articleId IS NULL OR vcmsArticleVersion.articleId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsArticleVersion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsArticleVersion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsArticleVersion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsArticleVersionPersistenceImpl.class);
	private static VcmsArticleVersion _nullVcmsArticleVersion = new VcmsArticleVersionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsArticleVersion> toCacheModel() {
				return _nullVcmsArticleVersionCacheModel;
			}
		};

	private static CacheModel<VcmsArticleVersion> _nullVcmsArticleVersionCacheModel =
		new CacheModel<VcmsArticleVersion>() {
			public VcmsArticleVersion toEntityModel() {
				return _nullVcmsArticleVersion;
			}
		};
}