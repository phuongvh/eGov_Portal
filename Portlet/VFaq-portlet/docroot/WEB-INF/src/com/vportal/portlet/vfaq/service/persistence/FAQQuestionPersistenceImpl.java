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

import com.vportal.portlet.vfaq.NoSuchFAQQuestionException;
import com.vportal.portlet.vfaq.model.FAQQuestion;
import com.vportal.portlet.vfaq.model.impl.FAQQuestionImpl;
import com.vportal.portlet.vfaq.model.impl.FAQQuestionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the f a q question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DucNN
 * @see FAQQuestionPersistence
 * @see FAQQuestionUtil
 * @generated
 */
public class FAQQuestionPersistenceImpl extends BasePersistenceImpl<FAQQuestion>
	implements FAQQuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FAQQuestionUtil} to access the f a q question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FAQQuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FAQQuestionModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			FAQQuestionModelImpl.UUID_COLUMN_BITMASK |
			FAQQuestionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			FAQQuestionModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_T",
			new String[] { Long.class.getName(), String.class.getName() },
			FAQQuestionModelImpl.GROUPID_COLUMN_BITMASK |
			FAQQuestionModelImpl.QUESTIONTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_T = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_T",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_A",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_A",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			FAQQuestionModelImpl.GROUPID_COLUMN_BITMASK |
			FAQQuestionModelImpl.APPROVED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_A = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_A",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L",
			new String[] { Long.class.getName(), String.class.getName() },
			FAQQuestionModelImpl.GROUPID_COLUMN_BITMASK |
			FAQQuestionModelImpl.LANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_A = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_L_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_L_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			FAQQuestionModelImpl.GROUPID_COLUMN_BITMASK |
			FAQQuestionModelImpl.LANGUAGE_COLUMN_BITMASK |
			FAQQuestionModelImpl.APPROVED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_L_A = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_L_A",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});
	public static final FinderPath FINDER_PATH_FETCH_BY_G_Q = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_Q",
			new String[] { Long.class.getName(), Long.class.getName() },
			FAQQuestionModelImpl.GROUPID_COLUMN_BITMASK |
			FAQQuestionModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_Q = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_Q",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, FAQQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the f a q question in the entity cache if it is enabled.
	 *
	 * @param faqQuestion the f a q question
	 */
	public void cacheResult(FAQQuestion faqQuestion) {
		EntityCacheUtil.putResult(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionImpl.class, faqQuestion.getPrimaryKey(), faqQuestion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				faqQuestion.getUuid(), Long.valueOf(faqQuestion.getGroupId())
			}, faqQuestion);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_Q,
			new Object[] {
				Long.valueOf(faqQuestion.getGroupId()),
				Long.valueOf(faqQuestion.getId())
			}, faqQuestion);

		faqQuestion.resetOriginalValues();
	}

	/**
	 * Caches the f a q questions in the entity cache if it is enabled.
	 *
	 * @param faqQuestions the f a q questions
	 */
	public void cacheResult(List<FAQQuestion> faqQuestions) {
		for (FAQQuestion faqQuestion : faqQuestions) {
			if (EntityCacheUtil.getResult(
						FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
						FAQQuestionImpl.class, faqQuestion.getPrimaryKey()) == null) {
				cacheResult(faqQuestion);
			}
			else {
				faqQuestion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all f a q questions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FAQQuestionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FAQQuestionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the f a q question.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FAQQuestion faqQuestion) {
		EntityCacheUtil.removeResult(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionImpl.class, faqQuestion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(faqQuestion);
	}

	@Override
	public void clearCache(List<FAQQuestion> faqQuestions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FAQQuestion faqQuestion : faqQuestions) {
			EntityCacheUtil.removeResult(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
				FAQQuestionImpl.class, faqQuestion.getPrimaryKey());

			clearUniqueFindersCache(faqQuestion);
		}
	}

	protected void clearUniqueFindersCache(FAQQuestion faqQuestion) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				faqQuestion.getUuid(), Long.valueOf(faqQuestion.getGroupId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_Q,
			new Object[] {
				Long.valueOf(faqQuestion.getGroupId()),
				Long.valueOf(faqQuestion.getId())
			});
	}

	/**
	 * Creates a new f a q question with the primary key. Does not add the f a q question to the database.
	 *
	 * @param id the primary key for the new f a q question
	 * @return the new f a q question
	 */
	public FAQQuestion create(long id) {
		FAQQuestion faqQuestion = new FAQQuestionImpl();

		faqQuestion.setNew(true);
		faqQuestion.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		faqQuestion.setUuid(uuid);

		return faqQuestion;
	}

	/**
	 * Removes the f a q question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the f a q question
	 * @return the f a q question that was removed
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion remove(long id)
		throws NoSuchFAQQuestionException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the f a q question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the f a q question
	 * @return the f a q question that was removed
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQQuestion remove(Serializable primaryKey)
		throws NoSuchFAQQuestionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FAQQuestion faqQuestion = (FAQQuestion)session.get(FAQQuestionImpl.class,
					primaryKey);

			if (faqQuestion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFAQQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(faqQuestion);
		}
		catch (NoSuchFAQQuestionException nsee) {
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
	protected FAQQuestion removeImpl(FAQQuestion faqQuestion)
		throws SystemException {
		faqQuestion = toUnwrappedModel(faqQuestion);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, faqQuestion);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(faqQuestion);

		return faqQuestion;
	}

	@Override
	public FAQQuestion updateImpl(
		com.vportal.portlet.vfaq.model.FAQQuestion faqQuestion, boolean merge)
		throws SystemException {
		faqQuestion = toUnwrappedModel(faqQuestion);

		boolean isNew = faqQuestion.isNew();

		FAQQuestionModelImpl faqQuestionModelImpl = (FAQQuestionModelImpl)faqQuestion;

		if (Validator.isNull(faqQuestion.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			faqQuestion.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, faqQuestion, merge);

			faqQuestion.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FAQQuestionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((faqQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						faqQuestionModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { faqQuestionModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((faqQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((faqQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getOriginalGroupId()),
						
						faqQuestionModelImpl.getOriginalQuestionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);

				args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getGroupId()),
						
						faqQuestionModelImpl.getQuestionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T,
					args);
			}

			if ((faqQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getOriginalGroupId()),
						Boolean.valueOf(faqQuestionModelImpl.getOriginalApproved())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
					args);

				args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getGroupId()),
						Boolean.valueOf(faqQuestionModelImpl.getApproved())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
					args);
			}

			if ((faqQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getOriginalGroupId()),
						
						faqQuestionModelImpl.getOriginalLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);

				args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getGroupId()),
						
						faqQuestionModelImpl.getLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L,
					args);
			}

			if ((faqQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getOriginalGroupId()),
						
						faqQuestionModelImpl.getOriginalLanguage(),
						Boolean.valueOf(faqQuestionModelImpl.getOriginalApproved())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A,
					args);

				args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getGroupId()),
						
						faqQuestionModelImpl.getLanguage(),
						Boolean.valueOf(faqQuestionModelImpl.getApproved())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_L_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A,
					args);
			}
		}

		EntityCacheUtil.putResult(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
			FAQQuestionImpl.class, faqQuestion.getPrimaryKey(), faqQuestion);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] {
					faqQuestion.getUuid(),
					Long.valueOf(faqQuestion.getGroupId())
				}, faqQuestion);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_Q,
				new Object[] {
					Long.valueOf(faqQuestion.getGroupId()),
					Long.valueOf(faqQuestion.getId())
				}, faqQuestion);
		}
		else {
			if ((faqQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						faqQuestionModelImpl.getOriginalUuid(),
						Long.valueOf(faqQuestionModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
					new Object[] {
						faqQuestion.getUuid(),
						Long.valueOf(faqQuestion.getGroupId())
					}, faqQuestion);
			}

			if ((faqQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_Q.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(faqQuestionModelImpl.getOriginalGroupId()),
						Long.valueOf(faqQuestionModelImpl.getOriginalId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_Q, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_Q, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_Q,
					new Object[] {
						Long.valueOf(faqQuestion.getGroupId()),
						Long.valueOf(faqQuestion.getId())
					}, faqQuestion);
			}
		}

		return faqQuestion;
	}

	protected FAQQuestion toUnwrappedModel(FAQQuestion faqQuestion) {
		if (faqQuestion instanceof FAQQuestionImpl) {
			return faqQuestion;
		}

		FAQQuestionImpl faqQuestionImpl = new FAQQuestionImpl();

		faqQuestionImpl.setNew(faqQuestion.isNew());
		faqQuestionImpl.setPrimaryKey(faqQuestion.getPrimaryKey());

		faqQuestionImpl.setUuid(faqQuestion.getUuid());
		faqQuestionImpl.setId(faqQuestion.getId());
		faqQuestionImpl.setTitle(faqQuestion.getTitle());
		faqQuestionImpl.setContent(faqQuestion.getContent());
		faqQuestionImpl.setLanguage(faqQuestion.getLanguage());
		faqQuestionImpl.setQuestionOrder(faqQuestion.getQuestionOrder());
		faqQuestionImpl.setSentDate(faqQuestion.getSentDate());
		faqQuestionImpl.setSentByUser(faqQuestion.getSentByUser());
		faqQuestionImpl.setSenderEmail(faqQuestion.getSenderEmail());
		faqQuestionImpl.setQuestionType(faqQuestion.getQuestionType());
		faqQuestionImpl.setModifiedByUser(faqQuestion.getModifiedByUser());
		faqQuestionImpl.setModifiedDate(faqQuestion.getModifiedDate());
		faqQuestionImpl.setHitCount(faqQuestion.getHitCount());
		faqQuestionImpl.setApproved(faqQuestion.isApproved());
		faqQuestionImpl.setGroupId(faqQuestion.getGroupId());
		faqQuestionImpl.setUserId(faqQuestion.getUserId());

		return faqQuestionImpl;
	}

	/**
	 * Returns the f a q question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q question
	 * @return the f a q question
	 * @throws com.liferay.portal.NoSuchModelException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQQuestion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q question with the primary key or throws a {@link com.vportal.portlet.vfaq.NoSuchFAQQuestionException} if it could not be found.
	 *
	 * @param id the primary key of the f a q question
	 * @return the f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByPrimaryKey(long id)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = fetchByPrimaryKey(id);

		if (faqQuestion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchFAQQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return faqQuestion;
	}

	/**
	 * Returns the f a q question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the f a q question
	 * @return the f a q question, or <code>null</code> if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FAQQuestion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the f a q question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the f a q question
	 * @return the f a q question, or <code>null</code> if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion fetchByPrimaryKey(long id) throws SystemException {
		FAQQuestion faqQuestion = (FAQQuestion)EntityCacheUtil.getResult(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
				FAQQuestionImpl.class, id);

		if (faqQuestion == _nullFAQQuestion) {
			return null;
		}

		if (faqQuestion == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				faqQuestion = (FAQQuestion)session.get(FAQQuestionImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (faqQuestion != null) {
					cacheResult(faqQuestion);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FAQQuestionModelImpl.ENTITY_CACHE_ENABLED,
						FAQQuestionImpl.class, id, _nullFAQQuestion);
				}

				closeSession(session);
			}
		}

		return faqQuestion;
	}

	/**
	 * Returns all the f a q questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q questions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @return the range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q questions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByUuid(String uuid, int start, int end,
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

		List<FAQQuestion> list = (List<FAQQuestion>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQQUESTION_WHERE);

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
				query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
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

				list = (List<FAQQuestion>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first f a q question in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		List<FAQQuestion> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q question in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		int count = countByUuid(uuid);

		List<FAQQuestion> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q questions before and after the current f a q question in the ordered set where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q question
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion[] findByUuid_PrevAndNext(long id, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQQuestion[] array = new FAQQuestionImpl[3];

			array[0] = getByUuid_PrevAndNext(session, faqQuestion, uuid,
					orderByComparator, true);

			array[1] = faqQuestion;

			array[2] = getByUuid_PrevAndNext(session, faqQuestion, uuid,
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

	protected FAQQuestion getByUuid_PrevAndNext(Session session,
		FAQQuestion faqQuestion, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQQUESTION_WHERE);

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
			query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(faqQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the f a q question where uuid = &#63; and groupId = &#63; or throws a {@link com.vportal.portlet.vfaq.NoSuchFAQQuestionException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByUUID_G(String uuid, long groupId)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = fetchByUUID_G(uuid, groupId);

		if (faqQuestion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFAQQuestionException(msg.toString());
		}

		return faqQuestion;
	}

	/**
	 * Returns the f a q question where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching f a q question, or <code>null</code> if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the f a q question where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching f a q question, or <code>null</code> if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FAQQUESTION_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<FAQQuestion> list = q.list();

				result = list;

				FAQQuestion faqQuestion = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					faqQuestion = list.get(0);

					cacheResult(faqQuestion);

					if ((faqQuestion.getUuid() == null) ||
							!faqQuestion.getUuid().equals(uuid) ||
							(faqQuestion.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, faqQuestion);
					}
				}

				return faqQuestion;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
				return (FAQQuestion)result;
			}
		}
	}

	/**
	 * Returns all the f a q questions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q questions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @return the range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q questions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<FAQQuestion> list = (List<FAQQuestion>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<FAQQuestion>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first f a q question in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		List<FAQQuestion> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q question in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		int count = countByGroupId(groupId);

		List<FAQQuestion> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q questions before and after the current f a q question in the ordered set where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q question
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion[] findByGroupId_PrevAndNext(long id, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQQuestion[] array = new FAQQuestionImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, faqQuestion, groupId,
					orderByComparator, true);

			array[1] = faqQuestion;

			array[2] = getByGroupId_PrevAndNext(session, faqQuestion, groupId,
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

	protected FAQQuestion getByGroupId_PrevAndNext(Session session,
		FAQQuestion faqQuestion, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQQUESTION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q questions where groupId = &#63; and questionType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param questionType the question type
	 * @return the matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_T(long groupId, String questionType)
		throws SystemException {
		return findByG_T(groupId, questionType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q questions where groupId = &#63; and questionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param questionType the question type
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @return the range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_T(long groupId, String questionType,
		int start, int end) throws SystemException {
		return findByG_T(groupId, questionType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q questions where groupId = &#63; and questionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param questionType the question type
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_T(long groupId, String questionType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] { groupId, questionType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_T;
			finderArgs = new Object[] {
					groupId, questionType,
					
					start, end, orderByComparator
				};
		}

		List<FAQQuestion> list = (List<FAQQuestion>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			if (questionType == null) {
				query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_1);
			}
			else {
				if (questionType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (questionType != null) {
					qPos.add(questionType);
				}

				list = (List<FAQQuestion>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first f a q question in the ordered set where groupId = &#63; and questionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param questionType the question type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_T_First(long groupId, String questionType,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		List<FAQQuestion> list = findByG_T(groupId, questionType, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", questionType=");
			msg.append(questionType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q question in the ordered set where groupId = &#63; and questionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param questionType the question type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_T_Last(long groupId, String questionType,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		int count = countByG_T(groupId, questionType);

		List<FAQQuestion> list = findByG_T(groupId, questionType, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", questionType=");
			msg.append(questionType);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q questions before and after the current f a q question in the ordered set where groupId = &#63; and questionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q question
	 * @param groupId the group ID
	 * @param questionType the question type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion[] findByG_T_PrevAndNext(long id, long groupId,
		String questionType, OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQQuestion[] array = new FAQQuestionImpl[3];

			array[0] = getByG_T_PrevAndNext(session, faqQuestion, groupId,
					questionType, orderByComparator, true);

			array[1] = faqQuestion;

			array[2] = getByG_T_PrevAndNext(session, faqQuestion, groupId,
					questionType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQQuestion getByG_T_PrevAndNext(Session session,
		FAQQuestion faqQuestion, long groupId, String questionType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQQUESTION_WHERE);

		query.append(_FINDER_COLUMN_G_T_GROUPID_2);

		if (questionType == null) {
			query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_1);
		}
		else {
			if (questionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_2);
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
			query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (questionType != null) {
			qPos.add(questionType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q questions where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @return the matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_A(long groupId, boolean approved)
		throws SystemException {
		return findByG_A(groupId, approved, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q questions where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @return the range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_A(long groupId, boolean approved,
		int start, int end) throws SystemException {
		return findByG_A(groupId, approved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q questions where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_A(long groupId, boolean approved,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A;
			finderArgs = new Object[] { groupId, approved };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A;
			finderArgs = new Object[] {
					groupId, approved,
					
					start, end, orderByComparator
				};
		}

		List<FAQQuestion> list = (List<FAQQuestion>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_APPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(approved);

				list = (List<FAQQuestion>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first f a q question in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_A_First(long groupId, boolean approved,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		List<FAQQuestion> list = findByG_A(groupId, approved, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", approved=");
			msg.append(approved);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q question in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_A_Last(long groupId, boolean approved,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		int count = countByG_A(groupId, approved);

		List<FAQQuestion> list = findByG_A(groupId, approved, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", approved=");
			msg.append(approved);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q questions before and after the current f a q question in the ordered set where groupId = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q question
	 * @param groupId the group ID
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion[] findByG_A_PrevAndNext(long id, long groupId,
		boolean approved, OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQQuestion[] array = new FAQQuestionImpl[3];

			array[0] = getByG_A_PrevAndNext(session, faqQuestion, groupId,
					approved, orderByComparator, true);

			array[1] = faqQuestion;

			array[2] = getByG_A_PrevAndNext(session, faqQuestion, groupId,
					approved, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQQuestion getByG_A_PrevAndNext(Session session,
		FAQQuestion faqQuestion, long groupId, boolean approved,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQQUESTION_WHERE);

		query.append(_FINDER_COLUMN_G_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_A_APPROVED_2);

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
			query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(approved);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q questions where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_L(long groupId, String language)
		throws SystemException {
		return findByG_L(groupId, language, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q questions where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @return the range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_L(long groupId, String language,
		int start, int end) throws SystemException {
		return findByG_L(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q questions where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_L(long groupId, String language,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<FAQQuestion> list = (List<FAQQuestion>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQQUESTION_WHERE);

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
				query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
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

				list = (List<FAQQuestion>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first f a q question in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_L_First(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		List<FAQQuestion> list = findByG_L(groupId, language, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q question in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_L_Last(long groupId, String language,
		OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		int count = countByG_L(groupId, language);

		List<FAQQuestion> list = findByG_L(groupId, language, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q questions before and after the current f a q question in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q question
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion[] findByG_L_PrevAndNext(long id, long groupId,
		String language, OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQQuestion[] array = new FAQQuestionImpl[3];

			array[0] = getByG_L_PrevAndNext(session, faqQuestion, groupId,
					language, orderByComparator, true);

			array[1] = faqQuestion;

			array[2] = getByG_L_PrevAndNext(session, faqQuestion, groupId,
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

	protected FAQQuestion getByG_L_PrevAndNext(Session session,
		FAQQuestion faqQuestion, long groupId, String language,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQQUESTION_WHERE);

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
			query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(faqQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the f a q questions where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @return the matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_L_A(long groupId, String language,
		boolean approved) throws SystemException {
		return findByG_L_A(groupId, language, approved, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q questions where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @return the range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_L_A(long groupId, String language,
		boolean approved, int start, int end) throws SystemException {
		return findByG_L_A(groupId, language, approved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q questions where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findByG_L_A(long groupId, String language,
		boolean approved, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_L_A;
			finderArgs = new Object[] { groupId, language, approved };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_L_A;
			finderArgs = new Object[] {
					groupId, language, approved,
					
					start, end, orderByComparator
				};
		}

		List<FAQQuestion> list = (List<FAQQuestion>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_G_L_A_APPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
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

				qPos.add(approved);

				list = (List<FAQQuestion>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first f a q question in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_L_A_First(long groupId, String language,
		boolean approved, OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		List<FAQQuestion> list = findByG_L_A(groupId, language, approved, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", approved=");
			msg.append(approved);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last f a q question in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_L_A_Last(long groupId, String language,
		boolean approved, OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		int count = countByG_L_A(groupId, language, approved);

		List<FAQQuestion> list = findByG_L_A(groupId, language, approved,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", language=");
			msg.append(language);

			msg.append(", approved=");
			msg.append(approved);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFAQQuestionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the f a q questions before and after the current f a q question in the ordered set where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current f a q question
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a f a q question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion[] findByG_L_A_PrevAndNext(long id, long groupId,
		String language, boolean approved, OrderByComparator orderByComparator)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			FAQQuestion[] array = new FAQQuestionImpl[3];

			array[0] = getByG_L_A_PrevAndNext(session, faqQuestion, groupId,
					language, approved, orderByComparator, true);

			array[1] = faqQuestion;

			array[2] = getByG_L_A_PrevAndNext(session, faqQuestion, groupId,
					language, approved, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FAQQuestion getByG_L_A_PrevAndNext(Session session,
		FAQQuestion faqQuestion, long groupId, String language,
		boolean approved, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAQQUESTION_WHERE);

		query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

		if (language == null) {
			query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_1);
		}
		else {
			if (language.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_3);
			}
			else {
				query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_2);
			}
		}

		query.append(_FINDER_COLUMN_G_L_A_APPROVED_2);

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
			query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);
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

		qPos.add(approved);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(faqQuestion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FAQQuestion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the f a q question where groupId = &#63; and id = &#63; or throws a {@link com.vportal.portlet.vfaq.NoSuchFAQQuestionException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @return the matching f a q question
	 * @throws com.vportal.portlet.vfaq.NoSuchFAQQuestionException if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion findByG_Q(long groupId, long id)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = fetchByG_Q(groupId, id);

		if (faqQuestion == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFAQQuestionException(msg.toString());
		}

		return faqQuestion;
	}

	/**
	 * Returns the f a q question where groupId = &#63; and id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @return the matching f a q question, or <code>null</code> if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion fetchByG_Q(long groupId, long id)
		throws SystemException {
		return fetchByG_Q(groupId, id, true);
	}

	/**
	 * Returns the f a q question where groupId = &#63; and id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching f a q question, or <code>null</code> if a matching f a q question could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FAQQuestion fetchByG_Q(long groupId, long id,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_G_Q,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_G_Q_GROUPID_2);

			query.append(_FINDER_COLUMN_G_Q_ID_2);

			query.append(FAQQuestionModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(id);

				List<FAQQuestion> list = q.list();

				result = list;

				FAQQuestion faqQuestion = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_Q,
						finderArgs, list);
				}
				else {
					faqQuestion = list.get(0);

					cacheResult(faqQuestion);

					if ((faqQuestion.getGroupId() != groupId) ||
							(faqQuestion.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_G_Q,
							finderArgs, faqQuestion);
					}
				}

				return faqQuestion;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_G_Q,
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
				return (FAQQuestion)result;
			}
		}
	}

	/**
	 * Returns all the f a q questions.
	 *
	 * @return the f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the f a q questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @return the range of f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the f a q questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of f a q questions
	 * @param end the upper bound of the range of f a q questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public List<FAQQuestion> findAll(int start, int end,
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

		List<FAQQuestion> list = (List<FAQQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FAQQUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAQQUESTION.concat(FAQQuestionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FAQQuestion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FAQQuestion>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the f a q questions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (FAQQuestion faqQuestion : findByUuid(uuid)) {
			remove(faqQuestion);
		}
	}

	/**
	 * Removes the f a q question where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUUID_G(String uuid, long groupId)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = findByUUID_G(uuid, groupId);

		remove(faqQuestion);
	}

	/**
	 * Removes all the f a q questions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (FAQQuestion faqQuestion : findByGroupId(groupId)) {
			remove(faqQuestion);
		}
	}

	/**
	 * Removes all the f a q questions where groupId = &#63; and questionType = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param questionType the question type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_T(long groupId, String questionType)
		throws SystemException {
		for (FAQQuestion faqQuestion : findByG_T(groupId, questionType)) {
			remove(faqQuestion);
		}
	}

	/**
	 * Removes all the f a q questions where groupId = &#63; and approved = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_A(long groupId, boolean approved)
		throws SystemException {
		for (FAQQuestion faqQuestion : findByG_A(groupId, approved)) {
			remove(faqQuestion);
		}
	}

	/**
	 * Removes all the f a q questions where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L(long groupId, String language)
		throws SystemException {
		for (FAQQuestion faqQuestion : findByG_L(groupId, language)) {
			remove(faqQuestion);
		}
	}

	/**
	 * Removes all the f a q questions where groupId = &#63; and language = &#63; and approved = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_L_A(long groupId, String language, boolean approved)
		throws SystemException {
		for (FAQQuestion faqQuestion : findByG_L_A(groupId, language, approved)) {
			remove(faqQuestion);
		}
	}

	/**
	 * Removes the f a q question where groupId = &#63; and id = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_Q(long groupId, long id)
		throws NoSuchFAQQuestionException, SystemException {
		FAQQuestion faqQuestion = findByG_Q(groupId, id);

		remove(faqQuestion);
	}

	/**
	 * Removes all the f a q questions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FAQQuestion faqQuestion : findAll()) {
			remove(faqQuestion);
		}
	}

	/**
	 * Returns the number of f a q questions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQQUESTION_WHERE);

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
	 * Returns the number of f a q questions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAQQUESTION_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q questions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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
	 * Returns the number of f a q questions where groupId = &#63; and questionType = &#63;.
	 *
	 * @param groupId the group ID
	 * @param questionType the question type
	 * @return the number of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_T(long groupId, String questionType)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, questionType };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_T,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_G_T_GROUPID_2);

			if (questionType == null) {
				query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_1);
			}
			else {
				if (questionType.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_T_QUESTIONTYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (questionType != null) {
					qPos.add(questionType);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_T, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q questions where groupId = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param approved the approved
	 * @return the number of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_A(long groupId, boolean approved)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, approved };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_APPROVED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_A, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q questions where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L(long groupId, String language)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAQQUESTION_WHERE);

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
	 * Returns the number of f a q questions where groupId = &#63; and language = &#63; and approved = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param approved the approved
	 * @return the number of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_L_A(long groupId, String language, boolean approved)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, language, approved };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_L_A,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_G_L_A_GROUPID_2);

			if (language == null) {
				query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_1);
			}
			else {
				if (language.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_3);
				}
				else {
					query.append(_FINDER_COLUMN_G_L_A_LANGUAGE_2);
				}
			}

			query.append(_FINDER_COLUMN_G_L_A_APPROVED_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_L_A,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q questions where groupId = &#63; and id = &#63;.
	 *
	 * @param groupId the group ID
	 * @param id the ID
	 * @return the number of matching f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_Q(long groupId, long id) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, id };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_Q,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAQQUESTION_WHERE);

			query.append(_FINDER_COLUMN_G_Q_GROUPID_2);

			query.append(_FINDER_COLUMN_G_Q_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(id);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_Q, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of f a q questions.
	 *
	 * @return the number of f a q questions
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAQQUESTION);

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
	 * Initializes the f a q question persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vfaq.model.FAQQuestion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FAQQuestion>> listenersList = new ArrayList<ModelListener<FAQQuestion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FAQQuestion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FAQQuestionImpl.class.getName());
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
	private static final String _SQL_SELECT_FAQQUESTION = "SELECT faqQuestion FROM FAQQuestion faqQuestion";
	private static final String _SQL_SELECT_FAQQUESTION_WHERE = "SELECT faqQuestion FROM FAQQuestion faqQuestion WHERE ";
	private static final String _SQL_COUNT_FAQQUESTION = "SELECT COUNT(faqQuestion) FROM FAQQuestion faqQuestion";
	private static final String _SQL_COUNT_FAQQUESTION_WHERE = "SELECT COUNT(faqQuestion) FROM FAQQuestion faqQuestion WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "faqQuestion.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "faqQuestion.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(faqQuestion.uuid IS NULL OR faqQuestion.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "faqQuestion.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "faqQuestion.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(faqQuestion.uuid IS NULL OR faqQuestion.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "faqQuestion.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "faqQuestion.groupId = ?";
	private static final String _FINDER_COLUMN_G_T_GROUPID_2 = "faqQuestion.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_T_QUESTIONTYPE_1 = "faqQuestion.questionType IS NULL";
	private static final String _FINDER_COLUMN_G_T_QUESTIONTYPE_2 = "faqQuestion.questionType = ?";
	private static final String _FINDER_COLUMN_G_T_QUESTIONTYPE_3 = "(faqQuestion.questionType IS NULL OR faqQuestion.questionType = ?)";
	private static final String _FINDER_COLUMN_G_A_GROUPID_2 = "faqQuestion.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_APPROVED_2 = "faqQuestion.approved = ?";
	private static final String _FINDER_COLUMN_G_L_GROUPID_2 = "faqQuestion.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_1 = "faqQuestion.language IS NULL";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_2 = "faqQuestion.language = ?";
	private static final String _FINDER_COLUMN_G_L_LANGUAGE_3 = "(faqQuestion.language IS NULL OR faqQuestion.language = ?)";
	private static final String _FINDER_COLUMN_G_L_A_GROUPID_2 = "faqQuestion.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_L_A_LANGUAGE_1 = "faqQuestion.language IS NULL AND ";
	private static final String _FINDER_COLUMN_G_L_A_LANGUAGE_2 = "faqQuestion.language = ? AND ";
	private static final String _FINDER_COLUMN_G_L_A_LANGUAGE_3 = "(faqQuestion.language IS NULL OR faqQuestion.language = ?) AND ";
	private static final String _FINDER_COLUMN_G_L_A_APPROVED_2 = "faqQuestion.approved = ?";
	private static final String _FINDER_COLUMN_G_Q_GROUPID_2 = "faqQuestion.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_Q_ID_2 = "faqQuestion.id = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "faqQuestion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FAQQuestion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FAQQuestion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FAQQuestionPersistenceImpl.class);
	private static FAQQuestion _nullFAQQuestion = new FAQQuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FAQQuestion> toCacheModel() {
				return _nullFAQQuestionCacheModel;
			}
		};

	private static CacheModel<FAQQuestion> _nullFAQQuestionCacheModel = new CacheModel<FAQQuestion>() {
			public FAQQuestion toEntityModel() {
				return _nullFAQQuestion;
			}
		};
}