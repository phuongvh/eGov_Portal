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

package com.vportal.portlet.vcms.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.vportal.portlet.vcms.model.VcmsLogger;
import com.vportal.portlet.vcms.service.VcmsArticleLocalService;
import com.vportal.portlet.vcms.service.VcmsArticleService;
import com.vportal.portlet.vcms.service.VcmsArticleStatusLocalService;
import com.vportal.portlet.vcms.service.VcmsArticleStatusService;
import com.vportal.portlet.vcms.service.VcmsArticleTypeLocalService;
import com.vportal.portlet.vcms.service.VcmsArticleTypeService;
import com.vportal.portlet.vcms.service.VcmsArticleVersionLocalService;
import com.vportal.portlet.vcms.service.VcmsArticleVersionService;
import com.vportal.portlet.vcms.service.VcmsAttachedMessageLocalService;
import com.vportal.portlet.vcms.service.VcmsAttachedMessageService;
import com.vportal.portlet.vcms.service.VcmsCARelationLocalService;
import com.vportal.portlet.vcms.service.VcmsCARelationService;
import com.vportal.portlet.vcms.service.VcmsCategoryLocalService;
import com.vportal.portlet.vcms.service.VcmsCategoryService;
import com.vportal.portlet.vcms.service.VcmsDiscussionLocalService;
import com.vportal.portlet.vcms.service.VcmsDiscussionService;
import com.vportal.portlet.vcms.service.VcmsLoggerLocalService;
import com.vportal.portlet.vcms.service.VcmsLoggerService;
import com.vportal.portlet.vcms.service.VcmsPARelationLocalService;
import com.vportal.portlet.vcms.service.VcmsPARelationService;
import com.vportal.portlet.vcms.service.VcmsPortionLocalService;
import com.vportal.portlet.vcms.service.VcmsPortionService;
import com.vportal.portlet.vcms.service.VcmsStatusLocalService;
import com.vportal.portlet.vcms.service.VcmsStatusService;
import com.vportal.portlet.vcms.service.VcmsTARelationLocalService;
import com.vportal.portlet.vcms.service.VcmsTARelationService;
import com.vportal.portlet.vcms.service.VcmsThreadLocalService;
import com.vportal.portlet.vcms.service.VcmsThreadService;
import com.vportal.portlet.vcms.service.VcmsTypeLocalService;
import com.vportal.portlet.vcms.service.VcmsTypeService;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleFinder;
import com.vportal.portlet.vcms.service.persistence.VcmsArticlePersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleStatusFinder;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleStatusPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleTypePersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsArticleVersionPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsAttachedMessagePersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsCARelationPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsCategoryPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsDiscussionFinder;
import com.vportal.portlet.vcms.service.persistence.VcmsDiscussionPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsLoggerFinder;
import com.vportal.portlet.vcms.service.persistence.VcmsLoggerPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsPARelationPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsPortionPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsStatusFinder;
import com.vportal.portlet.vcms.service.persistence.VcmsStatusPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsTARelationPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsThreadFinder;
import com.vportal.portlet.vcms.service.persistence.VcmsThreadPersistence;
import com.vportal.portlet.vcms.service.persistence.VcmsTypePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the vcms logger local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.vportal.portlet.vcms.service.impl.VcmsLoggerLocalServiceImpl}.
 * </p>
 *
 * @author hai
 * @see com.vportal.portlet.vcms.service.impl.VcmsLoggerLocalServiceImpl
 * @see com.vportal.portlet.vcms.service.VcmsLoggerLocalServiceUtil
 * @generated
 */
public abstract class VcmsLoggerLocalServiceBaseImpl
	implements VcmsLoggerLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.vportal.portlet.vcms.service.VcmsLoggerLocalServiceUtil} to access the vcms logger local service.
	 */

	/**
	 * Adds the vcms logger to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vcmsLogger the vcms logger
	 * @return the vcms logger that was added
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger addVcmsLogger(VcmsLogger vcmsLogger)
		throws SystemException {
		vcmsLogger.setNew(true);

		vcmsLogger = vcmsLoggerPersistence.update(vcmsLogger, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(vcmsLogger);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return vcmsLogger;
	}

	/**
	 * Creates a new vcms logger with the primary key. Does not add the vcms logger to the database.
	 *
	 * @param loggerId the primary key for the new vcms logger
	 * @return the new vcms logger
	 */
	public VcmsLogger createVcmsLogger(String loggerId) {
		return vcmsLoggerPersistence.create(loggerId);
	}

	/**
	 * Deletes the vcms logger with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loggerId the primary key of the vcms logger
	 * @throws PortalException if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteVcmsLogger(String loggerId)
		throws PortalException, SystemException {
		VcmsLogger vcmsLogger = vcmsLoggerPersistence.remove(loggerId);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(vcmsLogger);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the vcms logger from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vcmsLogger the vcms logger
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteVcmsLogger(VcmsLogger vcmsLogger)
		throws SystemException {
		vcmsLoggerPersistence.remove(vcmsLogger);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(vcmsLogger);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return vcmsLoggerPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return vcmsLoggerPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return vcmsLoggerPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return vcmsLoggerPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public VcmsLogger fetchVcmsLogger(String loggerId)
		throws SystemException {
		return vcmsLoggerPersistence.fetchByPrimaryKey(loggerId);
	}

	/**
	 * Returns the vcms logger with the primary key.
	 *
	 * @param loggerId the primary key of the vcms logger
	 * @return the vcms logger
	 * @throws PortalException if a vcms logger with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger getVcmsLogger(String loggerId)
		throws PortalException, SystemException {
		return vcmsLoggerPersistence.findByPrimaryKey(loggerId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return vcmsLoggerPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the vcms loggers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of vcms loggers
	 * @param end the upper bound of the range of vcms loggers (not inclusive)
	 * @return the range of vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public List<VcmsLogger> getVcmsLoggers(int start, int end)
		throws SystemException {
		return vcmsLoggerPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of vcms loggers.
	 *
	 * @return the number of vcms loggers
	 * @throws SystemException if a system exception occurred
	 */
	public int getVcmsLoggersCount() throws SystemException {
		return vcmsLoggerPersistence.countAll();
	}

	/**
	 * Updates the vcms logger in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vcmsLogger the vcms logger
	 * @return the vcms logger that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger updateVcmsLogger(VcmsLogger vcmsLogger)
		throws SystemException {
		return updateVcmsLogger(vcmsLogger, true);
	}

	/**
	 * Updates the vcms logger in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vcmsLogger the vcms logger
	 * @param merge whether to merge the vcms logger with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the vcms logger that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public VcmsLogger updateVcmsLogger(VcmsLogger vcmsLogger, boolean merge)
		throws SystemException {
		vcmsLogger.setNew(false);

		vcmsLogger = vcmsLoggerPersistence.update(vcmsLogger, merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(vcmsLogger);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return vcmsLogger;
	}

	/**
	 * Returns the vcms article local service.
	 *
	 * @return the vcms article local service
	 */
	public VcmsArticleLocalService getVcmsArticleLocalService() {
		return vcmsArticleLocalService;
	}

	/**
	 * Sets the vcms article local service.
	 *
	 * @param vcmsArticleLocalService the vcms article local service
	 */
	public void setVcmsArticleLocalService(
		VcmsArticleLocalService vcmsArticleLocalService) {
		this.vcmsArticleLocalService = vcmsArticleLocalService;
	}

	/**
	 * Returns the vcms article remote service.
	 *
	 * @return the vcms article remote service
	 */
	public VcmsArticleService getVcmsArticleService() {
		return vcmsArticleService;
	}

	/**
	 * Sets the vcms article remote service.
	 *
	 * @param vcmsArticleService the vcms article remote service
	 */
	public void setVcmsArticleService(VcmsArticleService vcmsArticleService) {
		this.vcmsArticleService = vcmsArticleService;
	}

	/**
	 * Returns the vcms article persistence.
	 *
	 * @return the vcms article persistence
	 */
	public VcmsArticlePersistence getVcmsArticlePersistence() {
		return vcmsArticlePersistence;
	}

	/**
	 * Sets the vcms article persistence.
	 *
	 * @param vcmsArticlePersistence the vcms article persistence
	 */
	public void setVcmsArticlePersistence(
		VcmsArticlePersistence vcmsArticlePersistence) {
		this.vcmsArticlePersistence = vcmsArticlePersistence;
	}

	/**
	 * Returns the vcms article finder.
	 *
	 * @return the vcms article finder
	 */
	public VcmsArticleFinder getVcmsArticleFinder() {
		return vcmsArticleFinder;
	}

	/**
	 * Sets the vcms article finder.
	 *
	 * @param vcmsArticleFinder the vcms article finder
	 */
	public void setVcmsArticleFinder(VcmsArticleFinder vcmsArticleFinder) {
		this.vcmsArticleFinder = vcmsArticleFinder;
	}

	/**
	 * Returns the vcms article status local service.
	 *
	 * @return the vcms article status local service
	 */
	public VcmsArticleStatusLocalService getVcmsArticleStatusLocalService() {
		return vcmsArticleStatusLocalService;
	}

	/**
	 * Sets the vcms article status local service.
	 *
	 * @param vcmsArticleStatusLocalService the vcms article status local service
	 */
	public void setVcmsArticleStatusLocalService(
		VcmsArticleStatusLocalService vcmsArticleStatusLocalService) {
		this.vcmsArticleStatusLocalService = vcmsArticleStatusLocalService;
	}

	/**
	 * Returns the vcms article status remote service.
	 *
	 * @return the vcms article status remote service
	 */
	public VcmsArticleStatusService getVcmsArticleStatusService() {
		return vcmsArticleStatusService;
	}

	/**
	 * Sets the vcms article status remote service.
	 *
	 * @param vcmsArticleStatusService the vcms article status remote service
	 */
	public void setVcmsArticleStatusService(
		VcmsArticleStatusService vcmsArticleStatusService) {
		this.vcmsArticleStatusService = vcmsArticleStatusService;
	}

	/**
	 * Returns the vcms article status persistence.
	 *
	 * @return the vcms article status persistence
	 */
	public VcmsArticleStatusPersistence getVcmsArticleStatusPersistence() {
		return vcmsArticleStatusPersistence;
	}

	/**
	 * Sets the vcms article status persistence.
	 *
	 * @param vcmsArticleStatusPersistence the vcms article status persistence
	 */
	public void setVcmsArticleStatusPersistence(
		VcmsArticleStatusPersistence vcmsArticleStatusPersistence) {
		this.vcmsArticleStatusPersistence = vcmsArticleStatusPersistence;
	}

	/**
	 * Returns the vcms article status finder.
	 *
	 * @return the vcms article status finder
	 */
	public VcmsArticleStatusFinder getVcmsArticleStatusFinder() {
		return vcmsArticleStatusFinder;
	}

	/**
	 * Sets the vcms article status finder.
	 *
	 * @param vcmsArticleStatusFinder the vcms article status finder
	 */
	public void setVcmsArticleStatusFinder(
		VcmsArticleStatusFinder vcmsArticleStatusFinder) {
		this.vcmsArticleStatusFinder = vcmsArticleStatusFinder;
	}

	/**
	 * Returns the vcms article type local service.
	 *
	 * @return the vcms article type local service
	 */
	public VcmsArticleTypeLocalService getVcmsArticleTypeLocalService() {
		return vcmsArticleTypeLocalService;
	}

	/**
	 * Sets the vcms article type local service.
	 *
	 * @param vcmsArticleTypeLocalService the vcms article type local service
	 */
	public void setVcmsArticleTypeLocalService(
		VcmsArticleTypeLocalService vcmsArticleTypeLocalService) {
		this.vcmsArticleTypeLocalService = vcmsArticleTypeLocalService;
	}

	/**
	 * Returns the vcms article type remote service.
	 *
	 * @return the vcms article type remote service
	 */
	public VcmsArticleTypeService getVcmsArticleTypeService() {
		return vcmsArticleTypeService;
	}

	/**
	 * Sets the vcms article type remote service.
	 *
	 * @param vcmsArticleTypeService the vcms article type remote service
	 */
	public void setVcmsArticleTypeService(
		VcmsArticleTypeService vcmsArticleTypeService) {
		this.vcmsArticleTypeService = vcmsArticleTypeService;
	}

	/**
	 * Returns the vcms article type persistence.
	 *
	 * @return the vcms article type persistence
	 */
	public VcmsArticleTypePersistence getVcmsArticleTypePersistence() {
		return vcmsArticleTypePersistence;
	}

	/**
	 * Sets the vcms article type persistence.
	 *
	 * @param vcmsArticleTypePersistence the vcms article type persistence
	 */
	public void setVcmsArticleTypePersistence(
		VcmsArticleTypePersistence vcmsArticleTypePersistence) {
		this.vcmsArticleTypePersistence = vcmsArticleTypePersistence;
	}

	/**
	 * Returns the vcms article version local service.
	 *
	 * @return the vcms article version local service
	 */
	public VcmsArticleVersionLocalService getVcmsArticleVersionLocalService() {
		return vcmsArticleVersionLocalService;
	}

	/**
	 * Sets the vcms article version local service.
	 *
	 * @param vcmsArticleVersionLocalService the vcms article version local service
	 */
	public void setVcmsArticleVersionLocalService(
		VcmsArticleVersionLocalService vcmsArticleVersionLocalService) {
		this.vcmsArticleVersionLocalService = vcmsArticleVersionLocalService;
	}

	/**
	 * Returns the vcms article version remote service.
	 *
	 * @return the vcms article version remote service
	 */
	public VcmsArticleVersionService getVcmsArticleVersionService() {
		return vcmsArticleVersionService;
	}

	/**
	 * Sets the vcms article version remote service.
	 *
	 * @param vcmsArticleVersionService the vcms article version remote service
	 */
	public void setVcmsArticleVersionService(
		VcmsArticleVersionService vcmsArticleVersionService) {
		this.vcmsArticleVersionService = vcmsArticleVersionService;
	}

	/**
	 * Returns the vcms article version persistence.
	 *
	 * @return the vcms article version persistence
	 */
	public VcmsArticleVersionPersistence getVcmsArticleVersionPersistence() {
		return vcmsArticleVersionPersistence;
	}

	/**
	 * Sets the vcms article version persistence.
	 *
	 * @param vcmsArticleVersionPersistence the vcms article version persistence
	 */
	public void setVcmsArticleVersionPersistence(
		VcmsArticleVersionPersistence vcmsArticleVersionPersistence) {
		this.vcmsArticleVersionPersistence = vcmsArticleVersionPersistence;
	}

	/**
	 * Returns the vcms attached message local service.
	 *
	 * @return the vcms attached message local service
	 */
	public VcmsAttachedMessageLocalService getVcmsAttachedMessageLocalService() {
		return vcmsAttachedMessageLocalService;
	}

	/**
	 * Sets the vcms attached message local service.
	 *
	 * @param vcmsAttachedMessageLocalService the vcms attached message local service
	 */
	public void setVcmsAttachedMessageLocalService(
		VcmsAttachedMessageLocalService vcmsAttachedMessageLocalService) {
		this.vcmsAttachedMessageLocalService = vcmsAttachedMessageLocalService;
	}

	/**
	 * Returns the vcms attached message remote service.
	 *
	 * @return the vcms attached message remote service
	 */
	public VcmsAttachedMessageService getVcmsAttachedMessageService() {
		return vcmsAttachedMessageService;
	}

	/**
	 * Sets the vcms attached message remote service.
	 *
	 * @param vcmsAttachedMessageService the vcms attached message remote service
	 */
	public void setVcmsAttachedMessageService(
		VcmsAttachedMessageService vcmsAttachedMessageService) {
		this.vcmsAttachedMessageService = vcmsAttachedMessageService;
	}

	/**
	 * Returns the vcms attached message persistence.
	 *
	 * @return the vcms attached message persistence
	 */
	public VcmsAttachedMessagePersistence getVcmsAttachedMessagePersistence() {
		return vcmsAttachedMessagePersistence;
	}

	/**
	 * Sets the vcms attached message persistence.
	 *
	 * @param vcmsAttachedMessagePersistence the vcms attached message persistence
	 */
	public void setVcmsAttachedMessagePersistence(
		VcmsAttachedMessagePersistence vcmsAttachedMessagePersistence) {
		this.vcmsAttachedMessagePersistence = vcmsAttachedMessagePersistence;
	}

	/**
	 * Returns the vcms c a relation local service.
	 *
	 * @return the vcms c a relation local service
	 */
	public VcmsCARelationLocalService getVcmsCARelationLocalService() {
		return vcmsCARelationLocalService;
	}

	/**
	 * Sets the vcms c a relation local service.
	 *
	 * @param vcmsCARelationLocalService the vcms c a relation local service
	 */
	public void setVcmsCARelationLocalService(
		VcmsCARelationLocalService vcmsCARelationLocalService) {
		this.vcmsCARelationLocalService = vcmsCARelationLocalService;
	}

	/**
	 * Returns the vcms c a relation remote service.
	 *
	 * @return the vcms c a relation remote service
	 */
	public VcmsCARelationService getVcmsCARelationService() {
		return vcmsCARelationService;
	}

	/**
	 * Sets the vcms c a relation remote service.
	 *
	 * @param vcmsCARelationService the vcms c a relation remote service
	 */
	public void setVcmsCARelationService(
		VcmsCARelationService vcmsCARelationService) {
		this.vcmsCARelationService = vcmsCARelationService;
	}

	/**
	 * Returns the vcms c a relation persistence.
	 *
	 * @return the vcms c a relation persistence
	 */
	public VcmsCARelationPersistence getVcmsCARelationPersistence() {
		return vcmsCARelationPersistence;
	}

	/**
	 * Sets the vcms c a relation persistence.
	 *
	 * @param vcmsCARelationPersistence the vcms c a relation persistence
	 */
	public void setVcmsCARelationPersistence(
		VcmsCARelationPersistence vcmsCARelationPersistence) {
		this.vcmsCARelationPersistence = vcmsCARelationPersistence;
	}

	/**
	 * Returns the vcms category local service.
	 *
	 * @return the vcms category local service
	 */
	public VcmsCategoryLocalService getVcmsCategoryLocalService() {
		return vcmsCategoryLocalService;
	}

	/**
	 * Sets the vcms category local service.
	 *
	 * @param vcmsCategoryLocalService the vcms category local service
	 */
	public void setVcmsCategoryLocalService(
		VcmsCategoryLocalService vcmsCategoryLocalService) {
		this.vcmsCategoryLocalService = vcmsCategoryLocalService;
	}

	/**
	 * Returns the vcms category remote service.
	 *
	 * @return the vcms category remote service
	 */
	public VcmsCategoryService getVcmsCategoryService() {
		return vcmsCategoryService;
	}

	/**
	 * Sets the vcms category remote service.
	 *
	 * @param vcmsCategoryService the vcms category remote service
	 */
	public void setVcmsCategoryService(VcmsCategoryService vcmsCategoryService) {
		this.vcmsCategoryService = vcmsCategoryService;
	}

	/**
	 * Returns the vcms category persistence.
	 *
	 * @return the vcms category persistence
	 */
	public VcmsCategoryPersistence getVcmsCategoryPersistence() {
		return vcmsCategoryPersistence;
	}

	/**
	 * Sets the vcms category persistence.
	 *
	 * @param vcmsCategoryPersistence the vcms category persistence
	 */
	public void setVcmsCategoryPersistence(
		VcmsCategoryPersistence vcmsCategoryPersistence) {
		this.vcmsCategoryPersistence = vcmsCategoryPersistence;
	}

	/**
	 * Returns the vcms discussion local service.
	 *
	 * @return the vcms discussion local service
	 */
	public VcmsDiscussionLocalService getVcmsDiscussionLocalService() {
		return vcmsDiscussionLocalService;
	}

	/**
	 * Sets the vcms discussion local service.
	 *
	 * @param vcmsDiscussionLocalService the vcms discussion local service
	 */
	public void setVcmsDiscussionLocalService(
		VcmsDiscussionLocalService vcmsDiscussionLocalService) {
		this.vcmsDiscussionLocalService = vcmsDiscussionLocalService;
	}

	/**
	 * Returns the vcms discussion remote service.
	 *
	 * @return the vcms discussion remote service
	 */
	public VcmsDiscussionService getVcmsDiscussionService() {
		return vcmsDiscussionService;
	}

	/**
	 * Sets the vcms discussion remote service.
	 *
	 * @param vcmsDiscussionService the vcms discussion remote service
	 */
	public void setVcmsDiscussionService(
		VcmsDiscussionService vcmsDiscussionService) {
		this.vcmsDiscussionService = vcmsDiscussionService;
	}

	/**
	 * Returns the vcms discussion persistence.
	 *
	 * @return the vcms discussion persistence
	 */
	public VcmsDiscussionPersistence getVcmsDiscussionPersistence() {
		return vcmsDiscussionPersistence;
	}

	/**
	 * Sets the vcms discussion persistence.
	 *
	 * @param vcmsDiscussionPersistence the vcms discussion persistence
	 */
	public void setVcmsDiscussionPersistence(
		VcmsDiscussionPersistence vcmsDiscussionPersistence) {
		this.vcmsDiscussionPersistence = vcmsDiscussionPersistence;
	}

	/**
	 * Returns the vcms discussion finder.
	 *
	 * @return the vcms discussion finder
	 */
	public VcmsDiscussionFinder getVcmsDiscussionFinder() {
		return vcmsDiscussionFinder;
	}

	/**
	 * Sets the vcms discussion finder.
	 *
	 * @param vcmsDiscussionFinder the vcms discussion finder
	 */
	public void setVcmsDiscussionFinder(
		VcmsDiscussionFinder vcmsDiscussionFinder) {
		this.vcmsDiscussionFinder = vcmsDiscussionFinder;
	}

	/**
	 * Returns the vcms logger local service.
	 *
	 * @return the vcms logger local service
	 */
	public VcmsLoggerLocalService getVcmsLoggerLocalService() {
		return vcmsLoggerLocalService;
	}

	/**
	 * Sets the vcms logger local service.
	 *
	 * @param vcmsLoggerLocalService the vcms logger local service
	 */
	public void setVcmsLoggerLocalService(
		VcmsLoggerLocalService vcmsLoggerLocalService) {
		this.vcmsLoggerLocalService = vcmsLoggerLocalService;
	}

	/**
	 * Returns the vcms logger remote service.
	 *
	 * @return the vcms logger remote service
	 */
	public VcmsLoggerService getVcmsLoggerService() {
		return vcmsLoggerService;
	}

	/**
	 * Sets the vcms logger remote service.
	 *
	 * @param vcmsLoggerService the vcms logger remote service
	 */
	public void setVcmsLoggerService(VcmsLoggerService vcmsLoggerService) {
		this.vcmsLoggerService = vcmsLoggerService;
	}

	/**
	 * Returns the vcms logger persistence.
	 *
	 * @return the vcms logger persistence
	 */
	public VcmsLoggerPersistence getVcmsLoggerPersistence() {
		return vcmsLoggerPersistence;
	}

	/**
	 * Sets the vcms logger persistence.
	 *
	 * @param vcmsLoggerPersistence the vcms logger persistence
	 */
	public void setVcmsLoggerPersistence(
		VcmsLoggerPersistence vcmsLoggerPersistence) {
		this.vcmsLoggerPersistence = vcmsLoggerPersistence;
	}

	/**
	 * Returns the vcms logger finder.
	 *
	 * @return the vcms logger finder
	 */
	public VcmsLoggerFinder getVcmsLoggerFinder() {
		return vcmsLoggerFinder;
	}

	/**
	 * Sets the vcms logger finder.
	 *
	 * @param vcmsLoggerFinder the vcms logger finder
	 */
	public void setVcmsLoggerFinder(VcmsLoggerFinder vcmsLoggerFinder) {
		this.vcmsLoggerFinder = vcmsLoggerFinder;
	}

	/**
	 * Returns the vcms p a relation local service.
	 *
	 * @return the vcms p a relation local service
	 */
	public VcmsPARelationLocalService getVcmsPARelationLocalService() {
		return vcmsPARelationLocalService;
	}

	/**
	 * Sets the vcms p a relation local service.
	 *
	 * @param vcmsPARelationLocalService the vcms p a relation local service
	 */
	public void setVcmsPARelationLocalService(
		VcmsPARelationLocalService vcmsPARelationLocalService) {
		this.vcmsPARelationLocalService = vcmsPARelationLocalService;
	}

	/**
	 * Returns the vcms p a relation remote service.
	 *
	 * @return the vcms p a relation remote service
	 */
	public VcmsPARelationService getVcmsPARelationService() {
		return vcmsPARelationService;
	}

	/**
	 * Sets the vcms p a relation remote service.
	 *
	 * @param vcmsPARelationService the vcms p a relation remote service
	 */
	public void setVcmsPARelationService(
		VcmsPARelationService vcmsPARelationService) {
		this.vcmsPARelationService = vcmsPARelationService;
	}

	/**
	 * Returns the vcms p a relation persistence.
	 *
	 * @return the vcms p a relation persistence
	 */
	public VcmsPARelationPersistence getVcmsPARelationPersistence() {
		return vcmsPARelationPersistence;
	}

	/**
	 * Sets the vcms p a relation persistence.
	 *
	 * @param vcmsPARelationPersistence the vcms p a relation persistence
	 */
	public void setVcmsPARelationPersistence(
		VcmsPARelationPersistence vcmsPARelationPersistence) {
		this.vcmsPARelationPersistence = vcmsPARelationPersistence;
	}

	/**
	 * Returns the vcms portion local service.
	 *
	 * @return the vcms portion local service
	 */
	public VcmsPortionLocalService getVcmsPortionLocalService() {
		return vcmsPortionLocalService;
	}

	/**
	 * Sets the vcms portion local service.
	 *
	 * @param vcmsPortionLocalService the vcms portion local service
	 */
	public void setVcmsPortionLocalService(
		VcmsPortionLocalService vcmsPortionLocalService) {
		this.vcmsPortionLocalService = vcmsPortionLocalService;
	}

	/**
	 * Returns the vcms portion remote service.
	 *
	 * @return the vcms portion remote service
	 */
	public VcmsPortionService getVcmsPortionService() {
		return vcmsPortionService;
	}

	/**
	 * Sets the vcms portion remote service.
	 *
	 * @param vcmsPortionService the vcms portion remote service
	 */
	public void setVcmsPortionService(VcmsPortionService vcmsPortionService) {
		this.vcmsPortionService = vcmsPortionService;
	}

	/**
	 * Returns the vcms portion persistence.
	 *
	 * @return the vcms portion persistence
	 */
	public VcmsPortionPersistence getVcmsPortionPersistence() {
		return vcmsPortionPersistence;
	}

	/**
	 * Sets the vcms portion persistence.
	 *
	 * @param vcmsPortionPersistence the vcms portion persistence
	 */
	public void setVcmsPortionPersistence(
		VcmsPortionPersistence vcmsPortionPersistence) {
		this.vcmsPortionPersistence = vcmsPortionPersistence;
	}

	/**
	 * Returns the vcms status local service.
	 *
	 * @return the vcms status local service
	 */
	public VcmsStatusLocalService getVcmsStatusLocalService() {
		return vcmsStatusLocalService;
	}

	/**
	 * Sets the vcms status local service.
	 *
	 * @param vcmsStatusLocalService the vcms status local service
	 */
	public void setVcmsStatusLocalService(
		VcmsStatusLocalService vcmsStatusLocalService) {
		this.vcmsStatusLocalService = vcmsStatusLocalService;
	}

	/**
	 * Returns the vcms status remote service.
	 *
	 * @return the vcms status remote service
	 */
	public VcmsStatusService getVcmsStatusService() {
		return vcmsStatusService;
	}

	/**
	 * Sets the vcms status remote service.
	 *
	 * @param vcmsStatusService the vcms status remote service
	 */
	public void setVcmsStatusService(VcmsStatusService vcmsStatusService) {
		this.vcmsStatusService = vcmsStatusService;
	}

	/**
	 * Returns the vcms status persistence.
	 *
	 * @return the vcms status persistence
	 */
	public VcmsStatusPersistence getVcmsStatusPersistence() {
		return vcmsStatusPersistence;
	}

	/**
	 * Sets the vcms status persistence.
	 *
	 * @param vcmsStatusPersistence the vcms status persistence
	 */
	public void setVcmsStatusPersistence(
		VcmsStatusPersistence vcmsStatusPersistence) {
		this.vcmsStatusPersistence = vcmsStatusPersistence;
	}

	/**
	 * Returns the vcms status finder.
	 *
	 * @return the vcms status finder
	 */
	public VcmsStatusFinder getVcmsStatusFinder() {
		return vcmsStatusFinder;
	}

	/**
	 * Sets the vcms status finder.
	 *
	 * @param vcmsStatusFinder the vcms status finder
	 */
	public void setVcmsStatusFinder(VcmsStatusFinder vcmsStatusFinder) {
		this.vcmsStatusFinder = vcmsStatusFinder;
	}

	/**
	 * Returns the vcms t a relation local service.
	 *
	 * @return the vcms t a relation local service
	 */
	public VcmsTARelationLocalService getVcmsTARelationLocalService() {
		return vcmsTARelationLocalService;
	}

	/**
	 * Sets the vcms t a relation local service.
	 *
	 * @param vcmsTARelationLocalService the vcms t a relation local service
	 */
	public void setVcmsTARelationLocalService(
		VcmsTARelationLocalService vcmsTARelationLocalService) {
		this.vcmsTARelationLocalService = vcmsTARelationLocalService;
	}

	/**
	 * Returns the vcms t a relation remote service.
	 *
	 * @return the vcms t a relation remote service
	 */
	public VcmsTARelationService getVcmsTARelationService() {
		return vcmsTARelationService;
	}

	/**
	 * Sets the vcms t a relation remote service.
	 *
	 * @param vcmsTARelationService the vcms t a relation remote service
	 */
	public void setVcmsTARelationService(
		VcmsTARelationService vcmsTARelationService) {
		this.vcmsTARelationService = vcmsTARelationService;
	}

	/**
	 * Returns the vcms t a relation persistence.
	 *
	 * @return the vcms t a relation persistence
	 */
	public VcmsTARelationPersistence getVcmsTARelationPersistence() {
		return vcmsTARelationPersistence;
	}

	/**
	 * Sets the vcms t a relation persistence.
	 *
	 * @param vcmsTARelationPersistence the vcms t a relation persistence
	 */
	public void setVcmsTARelationPersistence(
		VcmsTARelationPersistence vcmsTARelationPersistence) {
		this.vcmsTARelationPersistence = vcmsTARelationPersistence;
	}

	/**
	 * Returns the vcms thread local service.
	 *
	 * @return the vcms thread local service
	 */
	public VcmsThreadLocalService getVcmsThreadLocalService() {
		return vcmsThreadLocalService;
	}

	/**
	 * Sets the vcms thread local service.
	 *
	 * @param vcmsThreadLocalService the vcms thread local service
	 */
	public void setVcmsThreadLocalService(
		VcmsThreadLocalService vcmsThreadLocalService) {
		this.vcmsThreadLocalService = vcmsThreadLocalService;
	}

	/**
	 * Returns the vcms thread remote service.
	 *
	 * @return the vcms thread remote service
	 */
	public VcmsThreadService getVcmsThreadService() {
		return vcmsThreadService;
	}

	/**
	 * Sets the vcms thread remote service.
	 *
	 * @param vcmsThreadService the vcms thread remote service
	 */
	public void setVcmsThreadService(VcmsThreadService vcmsThreadService) {
		this.vcmsThreadService = vcmsThreadService;
	}

	/**
	 * Returns the vcms thread persistence.
	 *
	 * @return the vcms thread persistence
	 */
	public VcmsThreadPersistence getVcmsThreadPersistence() {
		return vcmsThreadPersistence;
	}

	/**
	 * Sets the vcms thread persistence.
	 *
	 * @param vcmsThreadPersistence the vcms thread persistence
	 */
	public void setVcmsThreadPersistence(
		VcmsThreadPersistence vcmsThreadPersistence) {
		this.vcmsThreadPersistence = vcmsThreadPersistence;
	}

	/**
	 * Returns the vcms thread finder.
	 *
	 * @return the vcms thread finder
	 */
	public VcmsThreadFinder getVcmsThreadFinder() {
		return vcmsThreadFinder;
	}

	/**
	 * Sets the vcms thread finder.
	 *
	 * @param vcmsThreadFinder the vcms thread finder
	 */
	public void setVcmsThreadFinder(VcmsThreadFinder vcmsThreadFinder) {
		this.vcmsThreadFinder = vcmsThreadFinder;
	}

	/**
	 * Returns the vcms type local service.
	 *
	 * @return the vcms type local service
	 */
	public VcmsTypeLocalService getVcmsTypeLocalService() {
		return vcmsTypeLocalService;
	}

	/**
	 * Sets the vcms type local service.
	 *
	 * @param vcmsTypeLocalService the vcms type local service
	 */
	public void setVcmsTypeLocalService(
		VcmsTypeLocalService vcmsTypeLocalService) {
		this.vcmsTypeLocalService = vcmsTypeLocalService;
	}

	/**
	 * Returns the vcms type remote service.
	 *
	 * @return the vcms type remote service
	 */
	public VcmsTypeService getVcmsTypeService() {
		return vcmsTypeService;
	}

	/**
	 * Sets the vcms type remote service.
	 *
	 * @param vcmsTypeService the vcms type remote service
	 */
	public void setVcmsTypeService(VcmsTypeService vcmsTypeService) {
		this.vcmsTypeService = vcmsTypeService;
	}

	/**
	 * Returns the vcms type persistence.
	 *
	 * @return the vcms type persistence
	 */
	public VcmsTypePersistence getVcmsTypePersistence() {
		return vcmsTypePersistence;
	}

	/**
	 * Sets the vcms type persistence.
	 *
	 * @param vcmsTypePersistence the vcms type persistence
	 */
	public void setVcmsTypePersistence(VcmsTypePersistence vcmsTypePersistence) {
		this.vcmsTypePersistence = vcmsTypePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.vportal.portlet.vcms.model.VcmsLogger",
			vcmsLoggerLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.vportal.portlet.vcms.model.VcmsLogger");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return VcmsLogger.class;
	}

	protected String getModelClassName() {
		return VcmsLogger.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = vcmsLoggerPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = VcmsArticleLocalService.class)
	protected VcmsArticleLocalService vcmsArticleLocalService;
	@BeanReference(type = VcmsArticleService.class)
	protected VcmsArticleService vcmsArticleService;
	@BeanReference(type = VcmsArticlePersistence.class)
	protected VcmsArticlePersistence vcmsArticlePersistence;
	@BeanReference(type = VcmsArticleFinder.class)
	protected VcmsArticleFinder vcmsArticleFinder;
	@BeanReference(type = VcmsArticleStatusLocalService.class)
	protected VcmsArticleStatusLocalService vcmsArticleStatusLocalService;
	@BeanReference(type = VcmsArticleStatusService.class)
	protected VcmsArticleStatusService vcmsArticleStatusService;
	@BeanReference(type = VcmsArticleStatusPersistence.class)
	protected VcmsArticleStatusPersistence vcmsArticleStatusPersistence;
	@BeanReference(type = VcmsArticleStatusFinder.class)
	protected VcmsArticleStatusFinder vcmsArticleStatusFinder;
	@BeanReference(type = VcmsArticleTypeLocalService.class)
	protected VcmsArticleTypeLocalService vcmsArticleTypeLocalService;
	@BeanReference(type = VcmsArticleTypeService.class)
	protected VcmsArticleTypeService vcmsArticleTypeService;
	@BeanReference(type = VcmsArticleTypePersistence.class)
	protected VcmsArticleTypePersistence vcmsArticleTypePersistence;
	@BeanReference(type = VcmsArticleVersionLocalService.class)
	protected VcmsArticleVersionLocalService vcmsArticleVersionLocalService;
	@BeanReference(type = VcmsArticleVersionService.class)
	protected VcmsArticleVersionService vcmsArticleVersionService;
	@BeanReference(type = VcmsArticleVersionPersistence.class)
	protected VcmsArticleVersionPersistence vcmsArticleVersionPersistence;
	@BeanReference(type = VcmsAttachedMessageLocalService.class)
	protected VcmsAttachedMessageLocalService vcmsAttachedMessageLocalService;
	@BeanReference(type = VcmsAttachedMessageService.class)
	protected VcmsAttachedMessageService vcmsAttachedMessageService;
	@BeanReference(type = VcmsAttachedMessagePersistence.class)
	protected VcmsAttachedMessagePersistence vcmsAttachedMessagePersistence;
	@BeanReference(type = VcmsCARelationLocalService.class)
	protected VcmsCARelationLocalService vcmsCARelationLocalService;
	@BeanReference(type = VcmsCARelationService.class)
	protected VcmsCARelationService vcmsCARelationService;
	@BeanReference(type = VcmsCARelationPersistence.class)
	protected VcmsCARelationPersistence vcmsCARelationPersistence;
	@BeanReference(type = VcmsCategoryLocalService.class)
	protected VcmsCategoryLocalService vcmsCategoryLocalService;
	@BeanReference(type = VcmsCategoryService.class)
	protected VcmsCategoryService vcmsCategoryService;
	@BeanReference(type = VcmsCategoryPersistence.class)
	protected VcmsCategoryPersistence vcmsCategoryPersistence;
	@BeanReference(type = VcmsDiscussionLocalService.class)
	protected VcmsDiscussionLocalService vcmsDiscussionLocalService;
	@BeanReference(type = VcmsDiscussionService.class)
	protected VcmsDiscussionService vcmsDiscussionService;
	@BeanReference(type = VcmsDiscussionPersistence.class)
	protected VcmsDiscussionPersistence vcmsDiscussionPersistence;
	@BeanReference(type = VcmsDiscussionFinder.class)
	protected VcmsDiscussionFinder vcmsDiscussionFinder;
	@BeanReference(type = VcmsLoggerLocalService.class)
	protected VcmsLoggerLocalService vcmsLoggerLocalService;
	@BeanReference(type = VcmsLoggerService.class)
	protected VcmsLoggerService vcmsLoggerService;
	@BeanReference(type = VcmsLoggerPersistence.class)
	protected VcmsLoggerPersistence vcmsLoggerPersistence;
	@BeanReference(type = VcmsLoggerFinder.class)
	protected VcmsLoggerFinder vcmsLoggerFinder;
	@BeanReference(type = VcmsPARelationLocalService.class)
	protected VcmsPARelationLocalService vcmsPARelationLocalService;
	@BeanReference(type = VcmsPARelationService.class)
	protected VcmsPARelationService vcmsPARelationService;
	@BeanReference(type = VcmsPARelationPersistence.class)
	protected VcmsPARelationPersistence vcmsPARelationPersistence;
	@BeanReference(type = VcmsPortionLocalService.class)
	protected VcmsPortionLocalService vcmsPortionLocalService;
	@BeanReference(type = VcmsPortionService.class)
	protected VcmsPortionService vcmsPortionService;
	@BeanReference(type = VcmsPortionPersistence.class)
	protected VcmsPortionPersistence vcmsPortionPersistence;
	@BeanReference(type = VcmsStatusLocalService.class)
	protected VcmsStatusLocalService vcmsStatusLocalService;
	@BeanReference(type = VcmsStatusService.class)
	protected VcmsStatusService vcmsStatusService;
	@BeanReference(type = VcmsStatusPersistence.class)
	protected VcmsStatusPersistence vcmsStatusPersistence;
	@BeanReference(type = VcmsStatusFinder.class)
	protected VcmsStatusFinder vcmsStatusFinder;
	@BeanReference(type = VcmsTARelationLocalService.class)
	protected VcmsTARelationLocalService vcmsTARelationLocalService;
	@BeanReference(type = VcmsTARelationService.class)
	protected VcmsTARelationService vcmsTARelationService;
	@BeanReference(type = VcmsTARelationPersistence.class)
	protected VcmsTARelationPersistence vcmsTARelationPersistence;
	@BeanReference(type = VcmsThreadLocalService.class)
	protected VcmsThreadLocalService vcmsThreadLocalService;
	@BeanReference(type = VcmsThreadService.class)
	protected VcmsThreadService vcmsThreadService;
	@BeanReference(type = VcmsThreadPersistence.class)
	protected VcmsThreadPersistence vcmsThreadPersistence;
	@BeanReference(type = VcmsThreadFinder.class)
	protected VcmsThreadFinder vcmsThreadFinder;
	@BeanReference(type = VcmsTypeLocalService.class)
	protected VcmsTypeLocalService vcmsTypeLocalService;
	@BeanReference(type = VcmsTypeService.class)
	protected VcmsTypeService vcmsTypeService;
	@BeanReference(type = VcmsTypePersistence.class)
	protected VcmsTypePersistence vcmsTypePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static Log _log = LogFactoryUtil.getLog(VcmsLoggerLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}