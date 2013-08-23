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

import com.vportal.portlet.vfaq.NoSuchFAQAnswerException;
import com.vportal.portlet.vfaq.model.FAQAnswer;
import com.vportal.portlet.vfaq.model.impl.FAQAnswerImpl;
import com.vportal.portlet.vfaq.model.impl.FAQAnswerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the f a q answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see FAQAnswerPersistence
 * @see FAQAnswerUtil
 * @generated
 */
public class FAQAnswerPersistenceImpl extends BasePersistenceImpl<FAQAnswer>
	implements FAQAnswerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FAQAnswerUtil} to access the f a q answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FAQAnswerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FAQAnswerModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGE = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLanguage",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE =
		new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLanguage",
			new String[] { String.class.getName() },
			FAQAnswerModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGE = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLanguage",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVED = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApproved",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED =
		new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByApproved",
			new String[] { Boolean.class.getName() },
			FAQAnswerModelImpl.APPROVED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPROVED = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByApproved",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByQuestionId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID =
		new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByQuestionId",
			new String[] { Long.class.getName() },
			FAQAnswerModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, FAQAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the f a q answer in the entity cache if it is enabled.
	 *
	 * @param faqAnswer the f a q answer
	 */
	public void cacheResult(FAQAnswer faqAnswer) {
		EntityCacheUtil.putResult(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerImpl.class, faqAnswer.getPrimaryKey(), faqAnswer);

		faqAnswer.resetOriginalValues();
	}

	/**
	 * Caches the f a q answers in the entity cache if it is enabled.
	 *
	 * @param faqAnswers the f a q answers
	 */
	public void cacheResult(List<FAQAnswer> faqAnswers) {
		for (FAQAnswer faqAnswer : faqAnswers) {
			if (EntityCacheUtil.getResult(
						FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
						FAQAnswerImpl.class, faqAnswer.getPrimaryKey()) == null) {
				cacheResult(faqAnswer);
			}
			else {
				faqAnswer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all f a q answers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FAQAnswerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FAQAnswerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the f a q answer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FAQAnswer faqAnswer) {
		EntityCacheUtil.removeResult(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerImpl.class, faqAnswer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FAQAnswer> faqAnswers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FAQAnswer faqAnswer : faqAnswers) {
			EntityCacheUtil.removeResult(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
				FAQAnswerImpl.class, faqAnswer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new f a q answer with the primary key. Does not add the f a q answer to the database.
	 *
	 * @param id the primary key for the new f a q answer
	 * @return the new f a q answer
	 */
	public FAQAnswer create(long id) {
		FAQAnswer faqAnswer = new FAQAnswerImpl();

		faqAnswer.setNew(true);
		faqAnswer.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		faqAnswer.setUuid(uuid);

		return faqAnswer;
	}

	/**
	 * Removes the f a q answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the f a q answer
	 * @return the f a q answer that was removed
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer remove(long id)
		throws NoSuchFAQAnswerException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the f a q answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the f a q answer
	 * @return the f a q answer that was removed
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQAnswer remove(Serializable primaryKey)
		throws NoSuchFAQAnswerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FAQAnswer faqAnswer = (FAQAnswer)session.get(FAQAnswerImpl.class,
					primaryKey);

			if (faqAnswer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFAQAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(faqAnswer);
		}
		catch (NoSuchFAQAnswerException nsee) {
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
	protected FAQAnswer removeImpl(FAQAnswer faqAnswer)
		throws SystemException {
		faqAnswer = toUnwrappedModel(faqAnswer);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, faqAnswer);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(faqAnswer);

		return faqAnswer;
	}

	@Override
	public FAQAnswer updateImpl(
		com.vportal.portlet.vfaq.model.FAQAnswer faqAnswer, boolean merge)
		throws SystemException {
		faqAnswer = toUnwrappedModel(faqAnswer);

		boolean isNew = faqAnswer.isNew();

		FAQAnswerModelImpl faqAnswerModelImpl = (FAQAnswerModelImpl)faqAnswer;

		if (Validator.isNull(faqAnswer.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			faqAnswer.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, faqAnswer, merge);

			faqAnswer.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FAQAnswerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((faqAnswerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						faqAnswerModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { faqAnswerModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((faqAnswerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						faqAnswerModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
					args);

				args = new Object[] { faqAnswerModelImpl.getLanguage() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGUAGE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE,
					args);
			}

			if ((faqAnswerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(faqAnswerModelImpl.getOriginalApproved())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED,
					args);

				args = new Object[] {
						Boolean.valueOf(faqAnswerModelImpl.getApproved())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPROVED, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED,
					args);
			}

			if ((faqAnswerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqAnswerModelImpl.getOriginalQuestionid())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);

				args = new Object[] {
						Long.valueOf(faqAnswerModelImpl.getQuestionid())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
			FAQAnswerImpl.class, faqAnswer.getPrimaryKey(), faqAnswer);

		return faqAnswer;
	}

	protected FAQAnswer toUnwrappedModel(FAQAnswer faqAnswer) {
		if (faqAnswer instanceof FAQAnswerImpl) {
			return faqAnswer;
		}

		FAQAnswerImpl faqAnswerImpl = new FAQAnswerImpl();

		faqAnswerImpl.setNew(faqAnswer.isNew());
		faqAnswerImpl.setPrimaryKey(faqAnswer.getPrimaryKey());

		faqAnswerImpl.setUuid(faqAnswer.getUuid());
		faqAnswerImpl.setId(faqAnswer.getId());
		faqAnswerImpl.setQuestionid(faqAnswer.getQuestionid());
		faqAnswerImpl.setContent(faqAnswer.getContent());
		faqAnswerImpl.setAnswerOrder(faqAnswer.getAnswerOrder());
		faqAnswerImpl.setAnsweredByUser(faqAnswer.getAnsweredByUser());
		faqAnswerImpl.setAnsweredDate(faqAnswer.getAnsweredDate());
		faqAnswerImpl.setModifiedByUser(faqAnswer.getModifiedByUser());
		faqAnswerImpl.setLanguage(faqAnswer.getLanguage());
		faqAnswerImpl.setModifiedDate(faqAnswer.getModifiedDate());
		faqAnswerImpl.setApproved(faqAnswer.isApproved());
		faqAnswerImpl.setApprovedByUser(faqAnswer.getApprovedByUser());
		faqAnswerImpl.setApprovedDate(faqAnswer.getApprovedDate());
		faqAnswerImpl.setUserId(faqAnswer.getUserId());
		faqAnswerImpl.setAttachName(faqAnswer.getAttachName());
		faqAnswerImpl.setFolderId(faqAnswer.getFolderId());

		return faqAnswerImpl;
	}

	/**
	 * Returns the f a q answer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q answer
	 * @return the f a q answer
	 * @throws com.liferay.portal.NoSuchModelException if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQAnswer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q answer with the primary key or throws a {@link com.vportal.portlet.vfaq.NoSuchFAQAnswerException} if it could not be found.
	 *
	 * @param id the primary key of the f a q answer
	 * @return the f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByPrimaryKey(long id)
		throws NoSuchFAQAnswerException, SystemException {
		FAQAnswer faqAnswer = fetchByPrimaryKey(id);

		if (faqAnswer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchFAQAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return faqAnswer;
	}

	/**
	 * Returns the f a q answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q answer
	 * @return the f a q answer, or <code>null</code> if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQAnswer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the f a q answer
	 * @return the f a q answer, or <code>null</code> if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer fetchByPrimaryKey(long id) throws SystemException {
		FAQAnswer faqAnswer = (FAQAnswer)EntityCacheUtil.getResult(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
				FAQAnswerImpl.class, id);

		if (faqAnswer == _nullFAQAnswer) {
			return null;
		}

		if (faqAnswer == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				faqAnswer = (FAQAnswer)session.get(FAQAnswerImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (faqAnswer != null) {
					cacheResult(faqAnswer);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FAQAnswerModelImpl.ENTITY_CACHE_ENABLED,
						FAQAnswerImpl.class, id, _nullFAQAnswer);
				}

				closeSession(session);
			}
		}

		return faqAnswer;
	}

	/**
	 * Returns all the f a q answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q answers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @return the range of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q answers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<FAQAnswer> list = (List<FAQAnswer>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQANSWER_WHERE);

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

			else {
				query.append(FAQAnswerModelImpl.ORDER_BY_JPQL);
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

				list = (List<FAQAnswer>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first f a q answer in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		List<FAQAnswer> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQAnswerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q answer in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		int count = countByUuid(uuid);

		List<FAQAnswer> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQAnswerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q answers before and after the current f a q answer in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q answer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		FAQAnswer faqAnswer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQAnswer[] array = new FAQAnswerImpl[3];

			array[0] = getByUuid_PrevAndNext(session, faqAnswer, uuid,
					orderByComparator, true);

			array[1] = faqAnswer;

			array[2] = getByUuid_PrevAndNext(session, faqAnswer, uuid,
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

	protected FAQAnswer getByUuid_PrevAndNext(Session session,
		FAQAnswer faqAnswer, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQANSWER_WHERE);

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

		else {
			query.append(FAQAnswerModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(faqAnswer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQAnswer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q answers where language = &#63;.
	 *
	 * @param language the language
	 * @return the matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByLanguage(String language)
		throws SystemException {
		return findByLanguage(language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the f a q answers where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @return the range of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByLanguage(String language, int start, int end)
		throws SystemException {
		return findByLanguage(language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q answers where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param language the language
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByLanguage(String language, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGE;
			finderArgs = new Object[] { language };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGE;
			finderArgs = new Object[] { language, start, end, orderByComparator };
		}

		List<FAQAnswer> list = (List<FAQAnswer>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQANSWER_WHERE);

			if (language == null) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQAnswerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (language != null) {
					qPos.add(language);
				}

				list = (List<FAQAnswer>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first f a q answer in the ordered set where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByLanguage_First(String language,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		List<FAQAnswer> list = findByLanguage(language, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQAnswerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q answer in the ordered set where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByLanguage_Last(String language,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		int count = countByLanguage(language);

		List<FAQAnswer> list = findByLanguage(language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQAnswerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q answers before and after the current f a q answer in the ordered set where language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q answer
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer[] findByLanguage_PrevAndNext(long id, String language,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		FAQAnswer faqAnswer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQAnswer[] array = new FAQAnswerImpl[3];

			array[0] = getByLanguage_PrevAndNext(session, faqAnswer, language,
					orderByComparator, true);

			array[1] = faqAnswer;

			array[2] = getByLanguage_PrevAndNext(session, faqAnswer, language,
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

	protected FAQAnswer getByLanguage_PrevAndNext(Session session,
		FAQAnswer faqAnswer, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQANSWER_WHERE);

		if (language == null) {
			query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
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
			query.append(FAQAnswerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (language != null) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqAnswer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQAnswer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q answers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByApproved(boolean approved)
		throws SystemException {
		return findByApproved(approved, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the f a q answers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @return the range of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByApproved(boolean approved, int start, int end)
		throws SystemException {
		return findByApproved(approved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q answers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByApproved(boolean approved, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPROVED;
			finderArgs = new Object[] { approved };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPROVED;
			finderArgs = new Object[] { approved, start, end, orderByComparator };
		}

		List<FAQAnswer> list = (List<FAQAnswer>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQANSWER_WHERE);

			query.append(_FINDER_COLUMN_APPROVED_APPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQAnswerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

				list = (List<FAQAnswer>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first f a q answer in the ordered set where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByApproved_First(boolean approved,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		List<FAQAnswer> list = findByApproved(approved, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("approved=");
			msg.append(approved);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQAnswerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q answer in the ordered set where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByApproved_Last(boolean approved,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		int count = countByApproved(approved);

		List<FAQAnswer> list = findByApproved(approved, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("approved=");
			msg.append(approved);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQAnswerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q answers before and after the current f a q answer in the ordered set where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q answer
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer[] findByApproved_PrevAndNext(long id, boolean approved,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		FAQAnswer faqAnswer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQAnswer[] array = new FAQAnswerImpl[3];

			array[0] = getByApproved_PrevAndNext(session, faqAnswer, approved,
					orderByComparator, true);

			array[1] = faqAnswer;

			array[2] = getByApproved_PrevAndNext(session, faqAnswer, approved,
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

	protected FAQAnswer getByApproved_PrevAndNext(Session session,
		FAQAnswer faqAnswer, boolean approved,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQANSWER_WHERE);

		query.append(_FINDER_COLUMN_APPROVED_APPROVED_2);

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
			query.append(FAQAnswerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(approved);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqAnswer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQAnswer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q answers where questionid = &#63;.
	 *
	 * @param questionid the questionid
	 * @return the matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByQuestionId(long questionid)
		throws SystemException {
		return findByQuestionId(questionid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q answers where questionid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionid the questionid
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @return the range of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByQuestionId(long questionid, int start, int end)
		throws SystemException {
		return findByQuestionId(questionid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q answers where questionid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionid the questionid
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findByQuestionId(long questionid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_QUESTIONID;
			finderArgs = new Object[] { questionid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_QUESTIONID;
			finderArgs = new Object[] { questionid, start, end, orderByComparator };
		}

		List<FAQAnswer> list = (List<FAQAnswer>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQANSWER_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQAnswerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionid);

				list = (List<FAQAnswer>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first f a q answer in the ordered set where questionid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionid the questionid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByQuestionId_First(long questionid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		List<FAQAnswer> list = findByQuestionId(questionid, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionid=");
			msg.append(questionid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQAnswerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q answer in the ordered set where questionid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param questionid the questionid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a matching f a q answer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer findByQuestionId_Last(long questionid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		int count = countByQuestionId(questionid);

		List<FAQAnswer> list = findByQuestionId(questionid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionid=");
			msg.append(questionid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQAnswerException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q answers before and after the current f a q answer in the ordered set where questionid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q answer
	 * @param questionid the questionid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q answer
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQAnswerException if a f a q answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQAnswer[] findByQuestionId_PrevAndNext(long id, long questionid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQAnswerException, SystemException {
		FAQAnswer faqAnswer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQAnswer[] array = new FAQAnswerImpl[3];

			array[0] = getByQuestionId_PrevAndNext(session, faqAnswer,
					questionid, orderByComparator, true);

			array[1] = faqAnswer;

			array[2] = getByQuestionId_PrevAndNext(session, faqAnswer,
					questionid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQAnswer getByQuestionId_PrevAndNext(Session session,
		FAQAnswer faqAnswer, long questionid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQANSWER_WHERE);

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

		else {
			query.append(FAQAnswerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqAnswer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQAnswer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q answers.
	 *
	 * @return the f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @return the range of f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q answers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q answers
	 * @param end the upper bound of the range of f a q answers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQAnswer> findAll(int start, int end,
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

		List<FAQAnswer> list = (List<FAQAnswer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FAQANSWER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAQANSWER.concat(FAQAnswerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FAQAnswer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FAQAnswer>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the f a q answers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (FAQAnswer faqAnswer : findByUuid(uuid)) {
			remove(faqAnswer);
		}
	}

	/**
	 * Removes all the f a q answers where language = &#63; from the database.
	 *
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLanguage(String language) throws SystemException {
		for (FAQAnswer faqAnswer : findByLanguage(language)) {
			remove(faqAnswer);
		}
	}

	/**
	 * Removes all the f a q answers where approved = &#63; from the database.
	 *
	 * @param approved the approved
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByApproved(boolean approved) throws SystemException {
		for (FAQAnswer faqAnswer : findByApproved(approved)) {
			remove(faqAnswer);
		}
	}

	/**
	 * Removes all the f a q answers where questionid = &#63; from the database.
	 *
	 * @param questionid the questionid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByQuestionId(long questionid) throws SystemException {
		for (FAQAnswer faqAnswer : findByQuestionId(questionid)) {
			remove(faqAnswer);
		}
	}

	/**
	 * Removes all the f a q answers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FAQAnswer faqAnswer : findAll()) {
			remove(faqAnswer);
		}
	}

	/**
	 * Returns the number of f a q answers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQANSWER_WHERE);

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
	 * Returns the number of f a q answers where language = &#63;.
	 *
	 * @param language the language
	 * @return the number of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLanguage(String language) throws SystemException {
		Object[] finderArgs = new Object[] { language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LANGUAGE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQANSWER_WHERE);

			if (language == null) {
				query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_LANGUAGE_LANGUAGE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LANGUAGE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q answers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the number of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByApproved(boolean approved) throws SystemException {
		Object[] finderArgs = new Object[] { approved };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPROVED,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQANSWER_WHERE);

			query.append(_FINDER_COLUMN_APPROVED_APPROVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approved);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPROVED,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q answers where questionid = &#63;.
	 *
	 * @param questionid the questionid
	 * @return the number of matching f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByQuestionId(long questionid) throws SystemException {
		Object[] finderArgs = new Object[] { questionid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUESTIONID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQANSWER_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionid);

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
	 * Returns the number of f a q answers.
	 *
	 * @return the number of f a q answers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAQANSWER);

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
	 * Initializes the f a q answer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vfaq.model.FAQAnswer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FAQAnswer>> listenersList = new ArrayList<ModelListener<FAQAnswer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FAQAnswer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FAQAnswerImpl.class.getName());
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
	private static final String _SQL_SELECT_FAQANSWER = "SELECT faqAnswer FROM FAQAnswer faqAnswer";
	private static final String _SQL_SELECT_FAQANSWER_WHERE = "SELECT faqAnswer FROM FAQAnswer faqAnswer WHERE ";
	private static final String _SQL_COUNT_FAQANSWER = "SELECT COUNT(faqAnswer) FROM FAQAnswer faqAnswer";
	private static final String _SQL_COUNT_FAQANSWER_WHERE = "SELECT COUNT(faqAnswer) FROM FAQAnswer faqAnswer WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "faqAnswer.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "faqAnswer.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(faqAnswer.uuid IS NULL OR faqAnswer.uuid = ?)";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_1 = "faqAnswer.language IS NULL";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_2 = "faqAnswer.language = ?";
	private static final String _FINDER_COLUMN_LANGUAGE_LANGUAGE_3 = "(faqAnswer.language IS NULL OR faqAnswer.language = ?)";
	private static final String _FINDER_COLUMN_APPROVED_APPROVED_2 = "faqAnswer.approved = ?";
	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "faqAnswer.questionid = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "faqAnswer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FAQAnswer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FAQAnswer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FAQAnswerPersistenceImpl.class);
	private static FAQAnswer _nullFAQAnswer = new FAQAnswerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FAQAnswer> toCacheModel() {
				return _nullFAQAnswerCacheModel;
			}
		};

	private static CacheModel<FAQAnswer> _nullFAQAnswerCacheModel = new CacheModel<FAQAnswer>() {
			public FAQAnswer toEntityModel() {
				return _nullFAQAnswer;
			}
		};
}