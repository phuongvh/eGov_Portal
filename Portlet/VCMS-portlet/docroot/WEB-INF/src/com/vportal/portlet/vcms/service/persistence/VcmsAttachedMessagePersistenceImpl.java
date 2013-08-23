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

import com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException;
import com.vportal.portlet.vcms.model.VcmsAttachedMessage;
import com.vportal.portlet.vcms.model.impl.VcmsAttachedMessageImpl;
import com.vportal.portlet.vcms.model.impl.VcmsAttachedMessageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vcms attached message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hai
 * @see VcmsAttachedMessagePersistence
 * @see VcmsAttachedMessageUtil
 * @generated
 */
public class VcmsAttachedMessagePersistenceImpl extends BasePersistenceImpl<VcmsAttachedMessage>
	implements VcmsAttachedMessagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VcmsAttachedMessageUtil} to access the vcms attached message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VcmsAttachedMessageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLE = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE =
		new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticle",
			new String[] { String.class.getName() },
			VcmsAttachedMessageModelImpl.ARTICLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLE = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNREAD = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnRead",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNREAD =
		new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnRead",
			new String[] { Boolean.class.getName() },
			VcmsAttachedMessageModelImpl.READMESSAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNREAD = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnRead",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A_R = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByA_R",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA_R",
			new String[] { String.class.getName(), Boolean.class.getName() },
			VcmsAttachedMessageModelImpl.ARTICLEID_COLUMN_BITMASK |
			VcmsAttachedMessageModelImpl.READMESSAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_R = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_R",
			new String[] { String.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_R = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_R",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_R",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			VcmsAttachedMessageModelImpl.GROUPID_COLUMN_BITMASK |
			VcmsAttachedMessageModelImpl.READMESSAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_R = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_R",
			new String[] { Long.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the vcms attached message in the entity cache if it is enabled.
	 *
	 * @param vcmsAttachedMessage the vcms attached message
	 */
	public void cacheResult(VcmsAttachedMessage vcmsAttachedMessage) {
		EntityCacheUtil.putResult(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class, vcmsAttachedMessage.getPrimaryKey(),
			vcmsAttachedMessage);

		vcmsAttachedMessage.resetOriginalValues();
	}

	/**
	 * Caches the vcms attached messages in the entity cache if it is enabled.
	 *
	 * @param vcmsAttachedMessages the vcms attached messages
	 */
	public void cacheResult(List<VcmsAttachedMessage> vcmsAttachedMessages) {
		for (VcmsAttachedMessage vcmsAttachedMessage : vcmsAttachedMessages) {
			if (EntityCacheUtil.getResult(
						VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
						VcmsAttachedMessageImpl.class,
						vcmsAttachedMessage.getPrimaryKey()) == null) {
				cacheResult(vcmsAttachedMessage);
			}
			else {
				vcmsAttachedMessage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vcms attached messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VcmsAttachedMessageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VcmsAttachedMessageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vcms attached message.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VcmsAttachedMessage vcmsAttachedMessage) {
		EntityCacheUtil.removeResult(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class, vcmsAttachedMessage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VcmsAttachedMessage> vcmsAttachedMessages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VcmsAttachedMessage vcmsAttachedMessage : vcmsAttachedMessages) {
			EntityCacheUtil.removeResult(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
				VcmsAttachedMessageImpl.class,
				vcmsAttachedMessage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vcms attached message with the primary key. Does not add the vcms attached message to the database.
	 *
	 * @param messageId the primary key for the new vcms attached message
	 * @return the new vcms attached message
	 */
	public VcmsAttachedMessage create(String messageId) {
		VcmsAttachedMessage vcmsAttachedMessage = new VcmsAttachedMessageImpl();

		vcmsAttachedMessage.setNew(true);
		vcmsAttachedMessage.setPrimaryKey(messageId);

		return vcmsAttachedMessage;
	}

	/**
	 * Removes the vcms attached message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the vcms attached message
	 * @return the vcms attached message that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage remove(String messageId)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		return remove((Serializable)messageId);
	}

	/**
	 * Removes the vcms attached message with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vcms attached message
	 * @return the vcms attached message that was removed
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsAttachedMessage remove(Serializable primaryKey)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VcmsAttachedMessage vcmsAttachedMessage = (VcmsAttachedMessage)session.get(VcmsAttachedMessageImpl.class,
					primaryKey);

			if (vcmsAttachedMessage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVcmsAttachedMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vcmsAttachedMessage);
		}
		catch (NoSuchVcmsAttachedMessageException nsee) {
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
	protected VcmsAttachedMessage removeImpl(
		VcmsAttachedMessage vcmsAttachedMessage) throws SystemException {
		vcmsAttachedMessage = toUnwrappedModel(vcmsAttachedMessage);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, vcmsAttachedMessage);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(vcmsAttachedMessage);

		return vcmsAttachedMessage;
	}

	@Override
	public VcmsAttachedMessage updateImpl(
		com.vportal.portlet.vcms.model.VcmsAttachedMessage vcmsAttachedMessage,
		boolean merge) throws SystemException {
		vcmsAttachedMessage = toUnwrappedModel(vcmsAttachedMessage);

		boolean isNew = vcmsAttachedMessage.isNew();

		VcmsAttachedMessageModelImpl vcmsAttachedMessageModelImpl = (VcmsAttachedMessageModelImpl)vcmsAttachedMessage;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, vcmsAttachedMessage, merge);

			vcmsAttachedMessage.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VcmsAttachedMessageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vcmsAttachedMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsAttachedMessageModelImpl.getOriginalArticleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);

				args = new Object[] { vcmsAttachedMessageModelImpl.getArticleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ARTICLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLE,
					args);
			}

			if ((vcmsAttachedMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNREAD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(vcmsAttachedMessageModelImpl.getOriginalReadMessage())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNREAD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNREAD,
					args);

				args = new Object[] {
						Boolean.valueOf(vcmsAttachedMessageModelImpl.getReadMessage())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNREAD, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNREAD,
					args);
			}

			if ((vcmsAttachedMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vcmsAttachedMessageModelImpl.getOriginalArticleId(),
						Boolean.valueOf(vcmsAttachedMessageModelImpl.getOriginalReadMessage())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R,
					args);

				args = new Object[] {
						vcmsAttachedMessageModelImpl.getArticleId(),
						Boolean.valueOf(vcmsAttachedMessageModelImpl.getReadMessage())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R,
					args);
			}

			if ((vcmsAttachedMessageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(vcmsAttachedMessageModelImpl.getOriginalGroupId()),
						Boolean.valueOf(vcmsAttachedMessageModelImpl.getOriginalReadMessage())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R,
					args);

				args = new Object[] {
						Long.valueOf(vcmsAttachedMessageModelImpl.getGroupId()),
						Boolean.valueOf(vcmsAttachedMessageModelImpl.getReadMessage())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R,
					args);
			}
		}

		EntityCacheUtil.putResult(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
			VcmsAttachedMessageImpl.class, vcmsAttachedMessage.getPrimaryKey(),
			vcmsAttachedMessage);

		return vcmsAttachedMessage;
	}

	protected VcmsAttachedMessage toUnwrappedModel(
		VcmsAttachedMessage vcmsAttachedMessage) {
		if (vcmsAttachedMessage instanceof VcmsAttachedMessageImpl) {
			return vcmsAttachedMessage;
		}

		VcmsAttachedMessageImpl vcmsAttachedMessageImpl = new VcmsAttachedMessageImpl();

		vcmsAttachedMessageImpl.setNew(vcmsAttachedMessage.isNew());
		vcmsAttachedMessageImpl.setPrimaryKey(vcmsAttachedMessage.getPrimaryKey());

		vcmsAttachedMessageImpl.setMessageId(vcmsAttachedMessage.getMessageId());
		vcmsAttachedMessageImpl.setGroupId(vcmsAttachedMessage.getGroupId());
		vcmsAttachedMessageImpl.setCompanyId(vcmsAttachedMessage.getCompanyId());
		vcmsAttachedMessageImpl.setCreatedDate(vcmsAttachedMessage.getCreatedDate());
		vcmsAttachedMessageImpl.setCreatedByUser(vcmsAttachedMessage.getCreatedByUser());
		vcmsAttachedMessageImpl.setArticleId(vcmsAttachedMessage.getArticleId());
		vcmsAttachedMessageImpl.setContent(vcmsAttachedMessage.getContent());
		vcmsAttachedMessageImpl.setReadMessage(vcmsAttachedMessage.isReadMessage());

		return vcmsAttachedMessageImpl;
	}

	/**
	 * Returns the vcms attached message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms attached message
	 * @return the vcms attached message
	 * @throws com.liferay.portal.NoSuchModelException if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsAttachedMessage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms attached message with the primary key or throws a {@link com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException} if it could not be found.
	 *
	 * @param messageId the primary key of the vcms attached message
	 * @return the vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByPrimaryKey(String messageId)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		VcmsAttachedMessage vcmsAttachedMessage = fetchByPrimaryKey(messageId);

		if (vcmsAttachedMessage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + messageId);
			}

			throw new NoSuchVcmsAttachedMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				messageId);
		}

		return vcmsAttachedMessage;
	}

	/**
	 * Returns the vcms attached message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vcms attached message
	 * @return the vcms attached message, or <code>null</code> if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VcmsAttachedMessage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the vcms attached message with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the vcms attached message
	 * @return the vcms attached message, or <code>null</code> if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage fetchByPrimaryKey(String messageId)
		throws SystemException {
		VcmsAttachedMessage vcmsAttachedMessage = (VcmsAttachedMessage)EntityCacheUtil.getResult(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
				VcmsAttachedMessageImpl.class, messageId);

		if (vcmsAttachedMessage == _nullVcmsAttachedMessage) {
			return null;
		}

		if (vcmsAttachedMessage == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				vcmsAttachedMessage = (VcmsAttachedMessage)session.get(VcmsAttachedMessageImpl.class,
						messageId);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (vcmsAttachedMessage != null) {
					cacheResult(vcmsAttachedMessage);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VcmsAttachedMessageModelImpl.ENTITY_CACHE_ENABLED,
						VcmsAttachedMessageImpl.class, messageId,
						_nullVcmsAttachedMessage);
				}

				closeSession(session);
			}
		}

		return vcmsAttachedMessage;
	}

	/**
	 * Returns all the vcms attached messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByArticle(String articleId)
		throws SystemException {
		return findByArticle(articleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms attached messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @return the range of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByArticle(String articleId, int start,
		int end) throws SystemException {
		return findByArticle(articleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms attached messages where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByArticle(String articleId, int start,
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

		List<VcmsAttachedMessage> list = (List<VcmsAttachedMessage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE);

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
				query.append(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
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

				list = (List<VcmsAttachedMessage>)QueryUtil.list(q,
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
	 * Returns the first vcms attached message in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByArticle_First(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		List<VcmsAttachedMessage> list = findByArticle(articleId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsAttachedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms attached message in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByArticle_Last(String articleId,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		int count = countByArticle(articleId);

		List<VcmsAttachedMessage> list = findByArticle(articleId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsAttachedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms attached messages before and after the current vcms attached message in the ordered set where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the primary key of the current vcms attached message
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage[] findByArticle_PrevAndNext(String messageId,
		String articleId, OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		VcmsAttachedMessage vcmsAttachedMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			VcmsAttachedMessage[] array = new VcmsAttachedMessageImpl[3];

			array[0] = getByArticle_PrevAndNext(session, vcmsAttachedMessage,
					articleId, orderByComparator, true);

			array[1] = vcmsAttachedMessage;

			array[2] = getByArticle_PrevAndNext(session, vcmsAttachedMessage,
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

	protected VcmsAttachedMessage getByArticle_PrevAndNext(Session session,
		VcmsAttachedMessage vcmsAttachedMessage, String articleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE);

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
			query.append(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsAttachedMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsAttachedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms attached messages where readMessage = &#63;.
	 *
	 * @param readMessage the read message
	 * @return the matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByUnRead(boolean readMessage)
		throws SystemException {
		return findByUnRead(readMessage, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vcms attached messages where readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @return the range of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByUnRead(boolean readMessage,
		int start, int end) throws SystemException {
		return findByUnRead(readMessage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms attached messages where readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByUnRead(boolean readMessage,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNREAD;
			finderArgs = new Object[] { readMessage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UNREAD;
			finderArgs = new Object[] { readMessage, start, end, orderByComparator };
		}

		List<VcmsAttachedMessage> list = (List<VcmsAttachedMessage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_UNREAD_READMESSAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(readMessage);

				list = (List<VcmsAttachedMessage>)QueryUtil.list(q,
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
	 * Returns the first vcms attached message in the ordered set where readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByUnRead_First(boolean readMessage,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		List<VcmsAttachedMessage> list = findByUnRead(readMessage, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("readMessage=");
			msg.append(readMessage);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsAttachedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms attached message in the ordered set where readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByUnRead_Last(boolean readMessage,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		int count = countByUnRead(readMessage);

		List<VcmsAttachedMessage> list = findByUnRead(readMessage, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("readMessage=");
			msg.append(readMessage);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsAttachedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms attached messages before and after the current vcms attached message in the ordered set where readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the primary key of the current vcms attached message
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage[] findByUnRead_PrevAndNext(String messageId,
		boolean readMessage, OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		VcmsAttachedMessage vcmsAttachedMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			VcmsAttachedMessage[] array = new VcmsAttachedMessageImpl[3];

			array[0] = getByUnRead_PrevAndNext(session, vcmsAttachedMessage,
					readMessage, orderByComparator, true);

			array[1] = vcmsAttachedMessage;

			array[2] = getByUnRead_PrevAndNext(session, vcmsAttachedMessage,
					readMessage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsAttachedMessage getByUnRead_PrevAndNext(Session session,
		VcmsAttachedMessage vcmsAttachedMessage, boolean readMessage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_UNREAD_READMESSAGE_2);

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
			query.append(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(readMessage);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsAttachedMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsAttachedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @return the matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByA_R(String articleId,
		boolean readMessage) throws SystemException {
		return findByA_R(articleId, readMessage, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @return the range of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByA_R(String articleId,
		boolean readMessage, int start, int end) throws SystemException {
		return findByA_R(articleId, readMessage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByA_R(String articleId,
		boolean readMessage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A_R;
			finderArgs = new Object[] { articleId, readMessage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A_R;
			finderArgs = new Object[] {
					articleId, readMessage,
					
					start, end, orderByComparator
				};
		}

		List<VcmsAttachedMessage> list = (List<VcmsAttachedMessage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE);

			if (articleId == null) {
				query.append(_FINDER_COLUMN_A_R_ARTICLEID_1);
			}
			else {
				if (articleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_A_R_ARTICLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_A_R_ARTICLEID_2);
				}
			}

			query.append(_FINDER_COLUMN_A_R_READMESSAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
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

				qPos.add(readMessage);

				list = (List<VcmsAttachedMessage>)QueryUtil.list(q,
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
	 * Returns the first vcms attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByA_R_First(String articleId,
		boolean readMessage, OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		List<VcmsAttachedMessage> list = findByA_R(articleId, readMessage, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(", readMessage=");
			msg.append(readMessage);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsAttachedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByA_R_Last(String articleId,
		boolean readMessage, OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		int count = countByA_R(articleId, readMessage);

		List<VcmsAttachedMessage> list = findByA_R(articleId, readMessage,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("articleId=");
			msg.append(articleId);

			msg.append(", readMessage=");
			msg.append(readMessage);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsAttachedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms attached messages before and after the current vcms attached message in the ordered set where articleId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the primary key of the current vcms attached message
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage[] findByA_R_PrevAndNext(String messageId,
		String articleId, boolean readMessage,
		OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		VcmsAttachedMessage vcmsAttachedMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			VcmsAttachedMessage[] array = new VcmsAttachedMessageImpl[3];

			array[0] = getByA_R_PrevAndNext(session, vcmsAttachedMessage,
					articleId, readMessage, orderByComparator, true);

			array[1] = vcmsAttachedMessage;

			array[2] = getByA_R_PrevAndNext(session, vcmsAttachedMessage,
					articleId, readMessage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsAttachedMessage getByA_R_PrevAndNext(Session session,
		VcmsAttachedMessage vcmsAttachedMessage, String articleId,
		boolean readMessage, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE);

		if (articleId == null) {
			query.append(_FINDER_COLUMN_A_R_ARTICLEID_1);
		}
		else {
			if (articleId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_A_R_ARTICLEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_A_R_ARTICLEID_2);
			}
		}

		query.append(_FINDER_COLUMN_A_R_READMESSAGE_2);

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
			query.append(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (articleId != null) {
			qPos.add(articleId);
		}

		qPos.add(readMessage);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsAttachedMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsAttachedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @return the matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByG_R(long groupId, boolean readMessage)
		throws SystemException {
		return findByG_R(groupId, readMessage, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @return the range of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByG_R(long groupId,
		boolean readMessage, int start, int end) throws SystemException {
		return findByG_R(groupId, readMessage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findByG_R(long groupId,
		boolean readMessage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_R;
			finderArgs = new Object[] { groupId, readMessage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_R;
			finderArgs = new Object[] {
					groupId, readMessage,
					
					start, end, orderByComparator
				};
		}

		List<VcmsAttachedMessage> list = (List<VcmsAttachedMessage>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_G_R_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_READMESSAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(readMessage);

				list = (List<VcmsAttachedMessage>)QueryUtil.list(q,
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
	 * Returns the first vcms attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByG_R_First(long groupId,
		boolean readMessage, OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		List<VcmsAttachedMessage> list = findByG_R(groupId, readMessage, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", readMessage=");
			msg.append(readMessage);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsAttachedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last vcms attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a matching vcms attached message could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage findByG_R_Last(long groupId,
		boolean readMessage, OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		int count = countByG_R(groupId, readMessage);

		List<VcmsAttachedMessage> list = findByG_R(groupId, readMessage,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", readMessage=");
			msg.append(readMessage);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVcmsAttachedMessageException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the vcms attached messages before and after the current vcms attached message in the ordered set where groupId = &#63; and readMessage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param messageId the primary key of the current vcms attached message
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vcms attached message
	 * @throws com.vportal.portlet.vcms.NoSuchVcmsAttachedMessageException if a vcms attached message with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsAttachedMessage[] findByG_R_PrevAndNext(String messageId,
		long groupId, boolean readMessage, OrderByComparator orderByComparator)
		throws NoSuchVcmsAttachedMessageException, SystemException {
		VcmsAttachedMessage vcmsAttachedMessage = findByPrimaryKey(messageId);

		Session session = null;

		try {
			session = openSession();

			VcmsAttachedMessage[] array = new VcmsAttachedMessageImpl[3];

			array[0] = getByG_R_PrevAndNext(session, vcmsAttachedMessage,
					groupId, readMessage, orderByComparator, true);

			array[1] = vcmsAttachedMessage;

			array[2] = getByG_R_PrevAndNext(session, vcmsAttachedMessage,
					groupId, readMessage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VcmsAttachedMessage getByG_R_PrevAndNext(Session session,
		VcmsAttachedMessage vcmsAttachedMessage, long groupId,
		boolean readMessage, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE);

		query.append(_FINDER_COLUMN_G_R_GROUPID_2);

		query.append(_FINDER_COLUMN_G_R_READMESSAGE_2);

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
			query.append(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(readMessage);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vcmsAttachedMessage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VcmsAttachedMessage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the vcms attached messages.
	 *
	 * @return the vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vcms attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @return the range of vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vcms attached messages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms attached messages
	 * @param end the upper bound of the range of vcms attached messages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsAttachedMessage> findAll(int start, int end,
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

		List<VcmsAttachedMessage> list = (List<VcmsAttachedMessage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VCMSATTACHEDMESSAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VCMSATTACHEDMESSAGE.concat(VcmsAttachedMessageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VcmsAttachedMessage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VcmsAttachedMessage>)QueryUtil.list(q,
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
	 * Removes all the vcms attached messages where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByArticle(String articleId) throws SystemException {
		for (VcmsAttachedMessage vcmsAttachedMessage : findByArticle(articleId)) {
			remove(vcmsAttachedMessage);
		}
	}

	/**
	 * Removes all the vcms attached messages where readMessage = &#63; from the database.
	 *
	 * @param readMessage the read message
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUnRead(boolean readMessage) throws SystemException {
		for (VcmsAttachedMessage vcmsAttachedMessage : findByUnRead(readMessage)) {
			remove(vcmsAttachedMessage);
		}
	}

	/**
	 * Removes all the vcms attached messages where articleId = &#63; and readMessage = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByA_R(String articleId, boolean readMessage)
		throws SystemException {
		for (VcmsAttachedMessage vcmsAttachedMessage : findByA_R(articleId,
				readMessage)) {
			remove(vcmsAttachedMessage);
		}
	}

	/**
	 * Removes all the vcms attached messages where groupId = &#63; and readMessage = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByG_R(long groupId, boolean readMessage)
		throws SystemException {
		for (VcmsAttachedMessage vcmsAttachedMessage : findByG_R(groupId,
				readMessage)) {
			remove(vcmsAttachedMessage);
		}
	}

	/**
	 * Removes all the vcms attached messages from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VcmsAttachedMessage vcmsAttachedMessage : findAll()) {
			remove(vcmsAttachedMessage);
		}
	}

	/**
	 * Returns the number of vcms attached messages where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByArticle(String articleId) throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSATTACHEDMESSAGE_WHERE);

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
	 * Returns the number of vcms attached messages where readMessage = &#63;.
	 *
	 * @param readMessage the read message
	 * @return the number of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUnRead(boolean readMessage) throws SystemException {
		Object[] finderArgs = new Object[] { readMessage };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UNREAD,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VCMSATTACHEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_UNREAD_READMESSAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(readMessage);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UNREAD,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms attached messages where articleId = &#63; and readMessage = &#63;.
	 *
	 * @param articleId the article ID
	 * @param readMessage the read message
	 * @return the number of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByA_R(String articleId, boolean readMessage)
		throws SystemException {
		Object[] finderArgs = new Object[] { articleId, readMessage };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_A_R,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSATTACHEDMESSAGE_WHERE);

			if (articleId == null) {
				query.append(_FINDER_COLUMN_A_R_ARTICLEID_1);
			}
			else {
				if (articleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_A_R_ARTICLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_A_R_ARTICLEID_2);
				}
			}

			query.append(_FINDER_COLUMN_A_R_READMESSAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (articleId != null) {
					qPos.add(articleId);
				}

				qPos.add(readMessage);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_R, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms attached messages where groupId = &#63; and readMessage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param readMessage the read message
	 * @return the number of matching vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countByG_R(long groupId, boolean readMessage)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, readMessage };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_R,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VCMSATTACHEDMESSAGE_WHERE);

			query.append(_FINDER_COLUMN_G_R_GROUPID_2);

			query.append(_FINDER_COLUMN_G_R_READMESSAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(readMessage);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_R, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of vcms attached messages.
	 *
	 * @return the number of vcms attached messages
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VCMSATTACHEDMESSAGE);

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
	 * Initializes the vcms attached message persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.vportal.portlet.vcms.model.VcmsAttachedMessage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VcmsAttachedMessage>> listenersList = new ArrayList<ModelListener<VcmsAttachedMessage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VcmsAttachedMessage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VcmsAttachedMessageImpl.class.getName());
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
	private static final String _SQL_SELECT_VCMSATTACHEDMESSAGE = "SELECT vcmsAttachedMessage FROM VcmsAttachedMessage vcmsAttachedMessage";
	private static final String _SQL_SELECT_VCMSATTACHEDMESSAGE_WHERE = "SELECT vcmsAttachedMessage FROM VcmsAttachedMessage vcmsAttachedMessage WHERE ";
	private static final String _SQL_COUNT_VCMSATTACHEDMESSAGE = "SELECT COUNT(vcmsAttachedMessage) FROM VcmsAttachedMessage vcmsAttachedMessage";
	private static final String _SQL_COUNT_VCMSATTACHEDMESSAGE_WHERE = "SELECT COUNT(vcmsAttachedMessage) FROM VcmsAttachedMessage vcmsAttachedMessage WHERE ";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_1 = "vcmsAttachedMessage.articleId IS NULL";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_2 = "vcmsAttachedMessage.articleId = ?";
	private static final String _FINDER_COLUMN_ARTICLE_ARTICLEID_3 = "(vcmsAttachedMessage.articleId IS NULL OR vcmsAttachedMessage.articleId = ?)";
	private static final String _FINDER_COLUMN_UNREAD_READMESSAGE_2 = "vcmsAttachedMessage.readMessage = ?";
	private static final String _FINDER_COLUMN_A_R_ARTICLEID_1 = "vcmsAttachedMessage.articleId IS NULL AND ";
	private static final String _FINDER_COLUMN_A_R_ARTICLEID_2 = "vcmsAttachedMessage.articleId = ? AND ";
	private static final String _FINDER_COLUMN_A_R_ARTICLEID_3 = "(vcmsAttachedMessage.articleId IS NULL OR vcmsAttachedMessage.articleId = ?) AND ";
	private static final String _FINDER_COLUMN_A_R_READMESSAGE_2 = "vcmsAttachedMessage.readMessage = ?";
	private static final String _FINDER_COLUMN_G_R_GROUPID_2 = "vcmsAttachedMessage.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_R_READMESSAGE_2 = "vcmsAttachedMessage.readMessage = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vcmsAttachedMessage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VcmsAttachedMessage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VcmsAttachedMessage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VcmsAttachedMessagePersistenceImpl.class);
	private static VcmsAttachedMessage _nullVcmsAttachedMessage = new VcmsAttachedMessageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VcmsAttachedMessage> toCacheModel() {
				return _nullVcmsAttachedMessageCacheModel;
			}
		};

	private static CacheModel<VcmsAttachedMessage> _nullVcmsAttachedMessageCacheModel =
		new CacheModel<VcmsAttachedMessage>() {
			public VcmsAttachedMessage toEntityModel() {
				return _nullVcmsAttachedMessage;
			}
		};
}