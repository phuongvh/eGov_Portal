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

package com.vportal.portlet.vfaq.service.persistence;

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

import com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException;
import com.vportal.portlet.vfaq.model.FAQCategoryQuestion;
import com.vportal.portlet.vfaq.model.impl.FAQCategoryQuestionImpl;
import com.vportal.portlet.vfaq.model.impl.FAQCategoryQuestionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the f a q category question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see FAQCategoryQuestionPersistence
 * @see FAQCategoryQuestionUtil
 * @generated
 */
public class FAQCategoryQuestionPersistenceImpl extends BasePersistenceImpl<FAQCategoryQuestion>
	implements FAQCategoryQuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FAQCategoryQuestionUtil} to access the f a q category question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FAQCategoryQuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FAQCategoryQuestionModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionId",
			new String[] { Long.class.getName() },
			FAQCategoryQuestionModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
			new String[] { Long.class.getName() },
			FAQCategoryQuestionModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the f a q category question in the entity cache if it is enabled.
	 *
	 * @param faqCategoryQuestion the f a q category question
	 */
	public void cacheResult(FAQCategoryQuestion faqCategoryQuestion) {
		EntityCacheUtil.putResult(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class, faqCategoryQuestion.getPrimaryKey(),
			faqCategoryQuestion);

		faqCategoryQuestion.resetOriginalValues();
	}

	/**
	 * Caches the f a q category questions in the entity cache if it is enabled.
	 *
	 * @param faqCategoryQuestions the f a q category questions
	 */
	public void cacheResult(List<FAQCategoryQuestion> faqCategoryQuestions) {
		for (FAQCategoryQuestion faqCategoryQuestion : faqCategoryQuestions) {
			if (EntityCacheUtil.getResult(
						FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
						FAQCategoryQuestionImpl.class,
						faqCategoryQuestion.getPrimaryKey()) == null) {
				cacheResult(faqCategoryQuestion);
			}
			else {
				faqCategoryQuestion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all f a q category questions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FAQCategoryQuestionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FAQCategoryQuestionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the f a q category question.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FAQCategoryQuestion faqCategoryQuestion) {
		EntityCacheUtil.removeResult(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class, faqCategoryQuestion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FAQCategoryQuestion> faqCategoryQuestions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FAQCategoryQuestion faqCategoryQuestion : faqCategoryQuestions) {
			EntityCacheUtil.removeResult(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
				FAQCategoryQuestionImpl.class,
				faqCategoryQuestion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new f a q category question with the primary key. Does not add the f a q category question to the database.
	 *
	 * @param id the primary key for the new f a q category question
	 * @return the new f a q category question
	 */
	public FAQCategoryQuestion create(long id) {
		FAQCategoryQuestion faqCategoryQuestion = new FAQCategoryQuestionImpl();

		faqCategoryQuestion.setNew(true);
		faqCategoryQuestion.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		faqCategoryQuestion.setUuid(uuid);

		return faqCategoryQuestion;
	}

	/**
	 * Removes the f a q category question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the f a q category question
	 * @return the f a q category question that was removed
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion remove(long id)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the f a q category question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the f a q category question
	 * @return the f a q category question that was removed
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQCategoryQuestion remove(Serializable primaryKey)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FAQCategoryQuestion faqCategoryQuestion = (FAQCategoryQuestion)session.get(FAQCategoryQuestionImpl.class,
					primaryKey);

			if (faqCategoryQuestion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFAQCategoryQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(faqCategoryQuestion);
		}
		catch (NoSuchFAQCategoryQuestionException nsee) {
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
	protected FAQCategoryQuestion removeImpl(
		FAQCategoryQuestion faqCategoryQuestion) throws SystemException {
		faqCategoryQuestion = toUnwrappedModel(faqCategoryQuestion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, faqCategoryQuestion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(faqCategoryQuestion);

		return faqCategoryQuestion;
	}

	@Override
	public FAQCategoryQuestion updateImpl(
		com.vportal.portlet.vfaq.model.FAQCategoryQuestion faqCategoryQuestion,
		boolean merge) throws SystemException {
		faqCategoryQuestion = toUnwrappedModel(faqCategoryQuestion);

		boolean isNew = faqCategoryQuestion.isNew();

		FAQCategoryQuestionModelImpl faqCategoryQuestionModelImpl = (FAQCategoryQuestionModelImpl)faqCategoryQuestion;

		if (Validator.isNull(faqCategoryQuestion.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			faqCategoryQuestion.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, faqCategoryQuestion, merge);

			faqCategoryQuestion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FAQCategoryQuestionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((faqCategoryQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						faqCategoryQuestionModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { faqCategoryQuestionModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((faqCategoryQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqCategoryQuestionModelImpl.getOriginalQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);

				args = new Object[] {
						Long.valueOf(faqCategoryQuestionModelImpl.getQuestionId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);
			}

			if ((faqCategoryQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqCategoryQuestionModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);

				args = new Object[] {
						Long.valueOf(faqCategoryQuestionModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQCategoryQuestionImpl.class, faqCategoryQuestion.getPrimaryKey(),
			faqCategoryQuestion);

		return faqCategoryQuestion;
	}

	protected FAQCategoryQuestion toUnwrappedModel(
		FAQCategoryQuestion faqCategoryQuestion) {
		if (faqCategoryQuestion instanceof FAQCategoryQuestionImpl) {
			return faqCategoryQuestion;
		}

		FAQCategoryQuestionImpl faqCategoryQuestionImpl = new FAQCategoryQuestionImpl();

		faqCategoryQuestionImpl.setNew(faqCategoryQuestion.isNew());
		faqCategoryQuestionImpl.setPrimaryKey(faqCategoryQuestion.getPrimaryKey());

		faqCategoryQuestionImpl.setUuid(faqCategoryQuestion.getUuid());
		faqCategoryQuestionImpl.setId(faqCategoryQuestion.getId());
		faqCategoryQuestionImpl.setQuestionId(faqCategoryQuestion.getQuestionId());
		faqCategoryQuestionImpl.setCategoryId(faqCategoryQuestion.getCategoryId());

		return faqCategoryQuestionImpl;
	}

	/**
	 * Returns the f a q category question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q category question
	 * @return the f a q category question
	 * @throws com.liferay.portal.NoSuchModelException if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQCategoryQuestion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q category question with the primary key or throws a {@link com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException} if it could not be found.
	 *
	 * @param id the primary key of the f a q category question
	 * @return the f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion findByPrimaryKey(long id)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		FAQCategoryQuestion faqCategoryQuestion = fetchByPrimaryKey(id);

		if (faqCategoryQuestion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchFAQCategoryQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return faqCategoryQuestion;
	}

	/**
	 * Returns the f a q category question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q category question
	 * @return the f a q category question, or <code>null</code> if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQCategoryQuestion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q category question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the f a q category question
	 * @return the f a q category question, or <code>null</code> if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion fetchByPrimaryKey(long id)
		throws SystemException {
		FAQCategoryQuestion faqCategoryQuestion = (FAQCategoryQuestion)EntityCacheUtil.getResult(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
				FAQCategoryQuestionImpl.class, id);

		if (faqCategoryQuestion == _nullFAQCategoryQuestion) {
			return null;
		}

		if (faqCategoryQuestion == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				faqCategoryQuestion = (FAQCategoryQuestion)session.get(FAQCategoryQuestionImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (faqCategoryQuestion != null) {
					cacheResult(faqCategoryQuestion);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FAQCategoryQuestionModelImpl.ENTITY_CACHE_ENABLED,
						FAQCategoryQuestionImpl.class, id,
						_nullFAQCategoryQuestion);
				}

				closeSession(session);
			}
		}

		return faqCategoryQuestion;
	}

	/**
	 * Returns all the f a q category questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q category questions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q category questions
	 * @param end the upper bound of the range of f a q category questions (not inclusive)
	 * @return the range of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q category questions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q category questions
	 * @param end the upper bound of the range of f a q category questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<FAQCategoryQuestion> list = (List<FAQCategoryQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_FAQCATEGORYQUESTION_WHERE);

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

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<FAQCategoryQuestion>)QueryUtil.list(q,
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
	 * Returns the first f a q category question in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a matching f a q category question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		List<FAQCategoryQuestion> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q category question in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a matching f a q category question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		int count = countByUuid(uuid);

		List<FAQCategoryQuestion> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q category questions before and after the current f a q category question in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q category question
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		FAQCategoryQuestion faqCategoryQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQCategoryQuestion[] array = new FAQCategoryQuestionImpl[3];

			array[0] = getByUuid_PrevAndNext(session, faqCategoryQuestion,
					uuid, orderByComparator, true);

			array[1] = faqCategoryQuestion;

			array[2] = getByUuid_PrevAndNext(session, faqCategoryQuestion,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQCategoryQuestion getByUuid_PrevAndNext(Session session,
		FAQCategoryQuestion faqCategoryQuestion, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQCATEGORYQUESTION_WHERE);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqCategoryQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQCategoryQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q category questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByQuestionId(long questionId)
		throws SystemException {
		return findByQuestionId(questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q category questions where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of f a q category questions
	 * @param end the upper bound of the range of f a q category questions (not inclusive)
	 * @return the range of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByQuestionId(long questionId,
		int start, int end) throws SystemException {
		return findByQuestionId(questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q category questions where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of f a q category questions
	 * @param end the upper bound of the range of f a q category questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByQuestionId(long questionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID;
			finderArgs = new Object[] { questionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID;
			finderArgs = new Object[] { questionId, start, end, orderByComparator };
		}

		List<FAQCategoryQuestion> list = (List<FAQCategoryQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_FAQCATEGORYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				list = (List<FAQCategoryQuestion>)QueryUtil.list(q,
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
	 * Returns the first f a q category question in the ordered set where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a matching f a q category question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion findByQuestionId_First(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		List<FAQCategoryQuestion> list = findByQuestionId(questionId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q category question in the ordered set where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a matching f a q category question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion findByQuestionId_Last(long questionId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		int count = countByQuestionId(questionId);

		List<FAQCategoryQuestion> list = findByQuestionId(questionId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q category questions before and after the current f a q category question in the ordered set where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q category question
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion[] findByQuestionId_PrevAndNext(long id,
		long questionId, OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		FAQCategoryQuestion faqCategoryQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQCategoryQuestion[] array = new FAQCategoryQuestionImpl[3];

			array[0] = getByQuestionId_PrevAndNext(session,
					faqCategoryQuestion, questionId, orderByComparator, true);

			array[1] = faqCategoryQuestion;

			array[2] = getByQuestionId_PrevAndNext(session,
					faqCategoryQuestion, questionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQCategoryQuestion getByQuestionId_PrevAndNext(Session session,
		FAQCategoryQuestion faqCategoryQuestion, long questionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQCATEGORYQUESTION_WHERE);

		query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqCategoryQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQCategoryQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q category questions where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByCategoryId(long categoryId)
		throws SystemException {
		return findByCategoryId(categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q category questions where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of f a q category questions
	 * @param end the upper bound of the range of f a q category questions (not inclusive)
	 * @return the range of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByCategoryId(long categoryId,
		int start, int end) throws SystemException {
		return findByCategoryId(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q category questions where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of f a q category questions
	 * @param end the upper bound of the range of f a q category questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findByCategoryId(long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<FAQCategoryQuestion> list = (List<FAQCategoryQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_FAQCATEGORYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<FAQCategoryQuestion>)QueryUtil.list(q,
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
	 * Returns the first f a q category question in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a matching f a q category question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion findByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		List<FAQCategoryQuestion> list = findByCategoryId(categoryId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q category question in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a matching f a q category question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion findByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		int count = countByCategoryId(categoryId);

		List<FAQCategoryQuestion> list = findByCategoryId(categoryId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQCategoryQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q category questions before and after the current f a q category question in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q category question
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q category question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQCategoryQuestionException if a f a q category question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQCategoryQuestion[] findByCategoryId_PrevAndNext(long id,
		long categoryId, OrderByComparator orderByComparator)
		throws NoSuchFAQCategoryQuestionException, SystemException {
		FAQCategoryQuestion faqCategoryQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQCategoryQuestion[] array = new FAQCategoryQuestionImpl[3];

			array[0] = getByCategoryId_PrevAndNext(session,
					faqCategoryQuestion, categoryId, orderByComparator, true);

			array[1] = faqCategoryQuestion;

			array[2] = getByCategoryId_PrevAndNext(session,
					faqCategoryQuestion, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQCategoryQuestion getByCategoryId_PrevAndNext(Session session,
		FAQCategoryQuestion faqCategoryQuestion, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQCATEGORYQUESTION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqCategoryQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQCategoryQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q category questions.
	 *
	 * @return the f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q category questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q category questions
	 * @param end the upper bound of the range of f a q category questions (not inclusive)
	 * @return the range of f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q category questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q category questions
	 * @param end the upper bound of the range of f a q category questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQCategoryQuestion> findAll(int start, int end,
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

		List<FAQCategoryQuestion> list = (List<FAQCategoryQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FAQCATEGORYQUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAQCATEGORYQUESTION;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FAQCategoryQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FAQCategoryQuestion>)QueryUtil.list(q,
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
	 * Removes all the f a q category questions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (FAQCategoryQuestion faqCategoryQuestion : findByUuid(uuid)) {
			remove(faqCategoryQuestion);
		}
	}

	/**
	 * Removes all the f a q category questions where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionId(long questionId) throws SystemException {
		for (FAQCategoryQuestion faqCategoryQuestion : findByQuestionId(
				questionId)) {
			remove(faqCategoryQuestion);
		}
	}

	/**
	 * Removes all the f a q category questions where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryId(long categoryId) throws SystemException {
		for (FAQCategoryQuestion faqCategoryQuestion : findByCategoryId(
				categoryId)) {
			remove(faqCategoryQuestion);
		}
	}

	/**
	 * Removes all the f a q category questions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FAQCategoryQuestion faqCategoryQuestion : findAll()) {
			remove(faqCategoryQuestion);
		}
	}

	/**
	 * Returns the number of f a q category questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQCATEGORYQUESTION_WHERE);

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
	 * Returns the number of f a q category questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionId(long questionId) throws SystemException {
		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQCATEGORYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q category questions where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryId(long categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQCATEGORYQUESTION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q category questions.
	 *
	 * @return the number of f a q category questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAQCATEGORYQUESTION);

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
	 * Initializes the f a q category question persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vfaq.model.FAQCategoryQuestion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FAQCategoryQuestion>> listenersList = new ArrayList<ModelListener<FAQCategoryQuestion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FAQCategoryQuestion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FAQCategoryQuestionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = FAQAnswerPersistence.class)
	protected FAQAnswerPersistence faqAnswerPersistence;
	@BeanReference(type = FAQCategoryPersistence.class)
	protected FAQCategoryPersistence faqCategoryPersistence;
	@BeanReference(type = FAQCategoryQuestionPersistence.class)
	protected FAQCategoryQuestionPersistence faqCategoryQuestionPersistence;
	@BeanReference(type = FAQCommentPersistence.class)
	protected FAQCommentPersistence faqCommentPersistence;
	@BeanReference(type = FAQQuestionPersistence.class)
	protected FAQQuestionPersistence faqQuestionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_FAQCATEGORYQUESTION = "SELECT faqCategoryQuestion FROM FAQCategoryQuestion faqCategoryQuestion";
	private static final String _SQL_SELECT_FAQCATEGORYQUESTION_WHERE = "SELECT faqCategoryQuestion FROM FAQCategoryQuestion faqCategoryQuestion WHERE ";
	private static final String _SQL_COUNT_FAQCATEGORYQUESTION = "SELECT COUNT(faqCategoryQuestion) FROM FAQCategoryQuestion faqCategoryQuestion";
	private static final String _SQL_COUNT_FAQCATEGORYQUESTION_WHERE = "SELECT COUNT(faqCategoryQuestion) FROM FAQCategoryQuestion faqCategoryQuestion WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "faqCategoryQuestion.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "faqCategoryQuestion.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(faqCategoryQuestion.uuid IS NULL OR faqCategoryQuestion.uuid = ?)";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "faqCategoryQuestion.questionId = ?";
	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "faqCategoryQuestion.categoryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "faqCategoryQuestion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FAQCategoryQuestion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FAQCategoryQuestion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FAQCategoryQuestionPersistenceImpl.class);
	private static FAQCategoryQuestion _nullFAQCategoryQuestion = new FAQCategoryQuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FAQCategoryQuestion> toCacheModel() {
				return _nullFAQCategoryQuestionCacheModel;
			}
		};

	private static CacheModel<FAQCategoryQuestion> _nullFAQCategoryQuestionCacheModel =
		new CacheModel<FAQCategoryQuestion>() {
			public FAQCategoryQuestion toEntityModel() {
				return _nullFAQCategoryQuestion;
			}
		};
}