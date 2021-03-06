/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.vportal.portlet.vcms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VcmsArticleLocalService}.
 * </p>
 *
 * @author    hai
 * @see       VcmsArticleLocalService
 * @generated
 */
public class VcmsArticleLocalServiceWrapper implements VcmsArticleLocalService,
	ServiceWrapper<VcmsArticleLocalService> {
	public VcmsArticleLocalServiceWrapper(
		VcmsArticleLocalService vcmsArticleLocalService) {
		_vcmsArticleLocalService = vcmsArticleLocalService;
	}

	/**
	* Adds the vcms article to the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticle the vcms article
	* @return the vcms article that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticle addVcmsArticle(
		com.vportal.portlet.vcms.model.VcmsArticle vcmsArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.addVcmsArticle(vcmsArticle);
	}

	/**
	* Creates a new vcms article with the primary key. Does not add the vcms article to the database.
	*
	* @param articleId the primary key for the new vcms article
	* @return the new vcms article
	*/
	public com.vportal.portlet.vcms.model.VcmsArticle createVcmsArticle(
		java.lang.String articleId) {
		return _vcmsArticleLocalService.createVcmsArticle(articleId);
	}

	/**
	* Deletes the vcms article with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleId the primary key of the vcms article
	* @throws PortalException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsArticle(java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleLocalService.deleteVcmsArticle(articleId);
	}

	/**
	* Deletes the vcms article from the database. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticle the vcms article
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVcmsArticle(
		com.vportal.portlet.vcms.model.VcmsArticle vcmsArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		_vcmsArticleLocalService.deleteVcmsArticle(vcmsArticle);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vcms.model.VcmsArticle fetchVcmsArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.fetchVcmsArticle(articleId);
	}

	/**
	* Returns the vcms article with the primary key.
	*
	* @param articleId the primary key of the vcms article
	* @return the vcms article
	* @throws PortalException if a vcms article with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticle getVcmsArticle(
		java.lang.String articleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.getVcmsArticle(articleId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vcms articles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vcms articles
	* @param end the upper bound of the range of vcms articles (not inclusive)
	* @return the range of vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vcms.model.VcmsArticle> getVcmsArticles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.getVcmsArticles(start, end);
	}

	/**
	* Returns the number of vcms articles.
	*
	* @return the number of vcms articles
	* @throws SystemException if a system exception occurred
	*/
	public int getVcmsArticlesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.getVcmsArticlesCount();
	}

	/**
	* Updates the vcms article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticle the vcms article
	* @return the vcms article that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticle updateVcmsArticle(
		com.vportal.portlet.vcms.model.VcmsArticle vcmsArticle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.updateVcmsArticle(vcmsArticle);
	}

	/**
	* Updates the vcms article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vcmsArticle the vcms article
	* @param merge whether to merge the vcms article with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the vcms article that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vcms.model.VcmsArticle updateVcmsArticle(
		com.vportal.portlet.vcms.model.VcmsArticle vcmsArticle, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vcmsArticleLocalService.updateVcmsArticle(vcmsArticle, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _vcmsArticleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vcmsArticleLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VcmsArticleLocalService getWrappedVcmsArticleLocalService() {
		return _vcmsArticleLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVcmsArticleLocalService(
		VcmsArticleLocalService vcmsArticleLocalService) {
		_vcmsArticleLocalService = vcmsArticleLocalService;
	}

	public VcmsArticleLocalService getWrappedService() {
		return _vcmsArticleLocalService;
	}

	public void setWrappedService(
		VcmsArticleLocalService vcmsArticleLocalService) {
		_vcmsArticleLocalService = vcmsArticleLocalService;
	}

	private VcmsArticleLocalService _vcmsArticleLocalService;
}