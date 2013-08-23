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

package com.vportal.portlet.vfaq.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link FAQCategoryLocalService}.
 * </p>
 *
 * @author    DucNN
 * @see       FAQCategoryLocalService
 * @generated
 */
public class FAQCategoryLocalServiceWrapper implements FAQCategoryLocalService,
	ServiceWrapper<FAQCategoryLocalService> {
	public FAQCategoryLocalServiceWrapper(
		FAQCategoryLocalService faqCategoryLocalService) {
		_faqCategoryLocalService = faqCategoryLocalService;
	}

	/**
	* Adds the f a q category to the database. Also notifies the appropriate model listeners.
	*
	* @param faqCategory the f a q category
	* @return the f a q category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQCategory addFAQCategory(
		com.vportal.portlet.vfaq.model.FAQCategory faqCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.addFAQCategory(faqCategory);
	}

	/**
	* Creates a new f a q category with the primary key. Does not add the f a q category to the database.
	*
	* @param id the primary key for the new f a q category
	* @return the new f a q category
	*/
	public com.vportal.portlet.vfaq.model.FAQCategory createFAQCategory(long id) {
		return _faqCategoryLocalService.createFAQCategory(id);
	}

	/**
	* Deletes the f a q category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the f a q category
	* @throws PortalException if a f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteFAQCategory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryLocalService.deleteFAQCategory(id);
	}

	/**
	* Deletes the f a q category from the database. Also notifies the appropriate model listeners.
	*
	* @param faqCategory the f a q category
	* @throws SystemException if a system exception occurred
	*/
	public void deleteFAQCategory(
		com.vportal.portlet.vfaq.model.FAQCategory faqCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryLocalService.deleteFAQCategory(faqCategory);
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
		return _faqCategoryLocalService.dynamicQuery(dynamicQuery);
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
		return _faqCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _faqCategoryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _faqCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.vportal.portlet.vfaq.model.FAQCategory fetchFAQCategory(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.fetchFAQCategory(id);
	}

	/**
	* Returns the f a q category with the primary key.
	*
	* @param id the primary key of the f a q category
	* @return the f a q category
	* @throws PortalException if a f a q category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQCategory getFAQCategory(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getFAQCategory(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the f a q categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of f a q categories
	* @param end the upper bound of the range of f a q categories (not inclusive)
	* @return the range of f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.vportal.portlet.vfaq.model.FAQCategory> getFAQCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getFAQCategories(start, end);
	}

	/**
	* Returns the number of f a q categories.
	*
	* @return the number of f a q categories
	* @throws SystemException if a system exception occurred
	*/
	public int getFAQCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getFAQCategoriesCount();
	}

	/**
	* Updates the f a q category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqCategory the f a q category
	* @return the f a q category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQCategory updateFAQCategory(
		com.vportal.portlet.vfaq.model.FAQCategory faqCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.updateFAQCategory(faqCategory);
	}

	/**
	* Updates the f a q category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param faqCategory the f a q category
	* @param merge whether to merge the f a q category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the f a q category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.vportal.portlet.vfaq.model.FAQCategory updateFAQCategory(
		com.vportal.portlet.vfaq.model.FAQCategory faqCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.updateFAQCategory(faqCategory, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _faqCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_faqCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.vportal.portlet.vfaq.model.FAQCategory addCategory(
		java.lang.String name, java.lang.String description,
		java.lang.String language, long parent, long catorder, long catlevel,
		java.lang.String image, java.lang.String createdByUser,
		java.util.Date createdDate, long groupId, long plid, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions) throws java.lang.Exception {
		return _faqCategoryLocalService.addCategory(name, description,
			language, parent, catorder, catlevel, image, createdByUser,
			createdDate, groupId, plid, userId, addCommunityPermissions,
			addGuestPermissions);
	}

	public com.vportal.portlet.vfaq.model.FAQCategory addCategory(
		java.lang.String name, java.lang.String description,
		java.lang.String language, long parent, long catorder, long catlevel,
		java.lang.String image, java.lang.String createdByUser,
		java.util.Date createdDate, long groupId, long plid, long userId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return _faqCategoryLocalService.addCategory(name, description,
			language, parent, catorder, catlevel, image, createdByUser,
			createdDate, groupId, plid, userId, communityPermissions,
			guestPermissions);
	}

	public com.vportal.portlet.vfaq.model.FAQCategory addCategory(
		java.lang.String name, java.lang.String description,
		java.lang.String language, long parent, long catorder, long catlevel,
		java.lang.String image, java.lang.String createdByUser,
		java.util.Date createdDate, long groupId, long plid, long userId,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws java.lang.Exception {
		return _faqCategoryLocalService.addCategory(name, description,
			language, parent, catorder, catlevel, image, createdByUser,
			createdDate, groupId, plid, userId, addCommunityPermissions,
			addGuestPermissions, communityPermissions, guestPermissions);
	}

	public com.vportal.portlet.vfaq.model.FAQCategory updateImage(
		long categoryId, java.lang.String imageName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.updateImage(categoryId, imageName);
	}

	public com.vportal.portlet.vfaq.model.FAQCategory updateCategory(
		long categoryId, java.lang.String name, java.lang.String description,
		java.lang.String language, long parent, long catorder, long catlevel,
		java.lang.String image, java.lang.String modifiedByUser,
		java.util.Date modifiedDate, long groupId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.updateCategory(categoryId, name,
			description, language, parent, catorder, catlevel, image,
			modifiedByUser, modifiedDate, groupId, userId);
	}

	public void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryLocalService.deleteCategory(categoryId);
	}

	public void deleteCategory(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryLocalService.deleteCategory(groupId, categoryId);
	}

	public com.vportal.portlet.vfaq.model.FAQCategory getCategory(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getCategory(groupId, categoryId);
	}

	public com.vportal.portlet.vfaq.model.FAQCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getCategory(categoryId);
	}

	public java.util.List getSubCategory(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getSubCategory(groupId, parentId);
	}

	public java.util.List getSubCategory(long parentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getSubCategory(parentId);
	}

	public java.util.List getAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getAll(groupId);
	}

	public java.util.List getAll(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getAll(groupId, start, end);
	}

	public int countAll(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.countAll(groupId);
	}

	public java.util.List getAll()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getAll();
	}

	public java.util.List getAll(int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getAll(begin, end);
	}

	public java.util.List getByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getByGroupId(groupId);
	}

	public void addCategoryResources(long categoryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryLocalService.addCategoryResources(categoryId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(
		com.vportal.portlet.vfaq.model.FAQCategory category,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryLocalService.addCategoryResources(category,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(long categoryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryLocalService.addCategoryResources(categoryId,
			communityPermissions, guestPermissions);
	}

	public void addCategoryResources(
		com.vportal.portlet.vfaq.model.FAQCategory category,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_faqCategoryLocalService.addCategoryResources(category,
			communityPermissions, guestPermissions);
	}

	public java.util.List getByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getByG_L(groupId, language);
	}

	public java.util.List getByG_L(long groupId, java.lang.String language,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getByG_L(groupId, language, start, end);
	}

	public java.util.List getByG_L_P(long groupId, java.lang.String language,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getByG_L_P(groupId, language, parentId);
	}

	public java.util.List getByG_L_P(long groupId, java.lang.String language,
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getByG_L_P(groupId, language, parentId,
			start, end);
	}

	public int countByG_L(long groupId, java.lang.String language)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.countByG_L(groupId, language);
	}

	public int countByG_L_P(long groupId, java.lang.String language,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.countByG_L_P(groupId, language, parentId);
	}

	public int countByG_L_C(long groupId, java.lang.String language,
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.countByG_L_C(groupId, language,
			categoryId);
	}

	public java.util.List getCategoriesByG_L(long groupId,
		java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _faqCategoryLocalService.getCategoriesByG_L(groupId, language);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public FAQCategoryLocalService getWrappedFAQCategoryLocalService() {
		return _faqCategoryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedFAQCategoryLocalService(
		FAQCategoryLocalService faqCategoryLocalService) {
		_faqCategoryLocalService = faqCategoryLocalService;
	}

	public FAQCategoryLocalService getWrappedService() {
		return _faqCategoryLocalService;
	}

	public void setWrappedService(
		FAQCategoryLocalService faqCategoryLocalService) {
		_faqCategoryLocalService = faqCategoryLocalService;
	}

	private FAQCategoryLocalService _faqCategoryLocalService;
}