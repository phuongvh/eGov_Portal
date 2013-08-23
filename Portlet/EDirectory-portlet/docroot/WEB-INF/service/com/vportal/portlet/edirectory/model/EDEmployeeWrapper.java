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

package com.vportal.portlet.edirectory.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link EDEmployee}.
 * </p>
 *
 * @author    HOAN
 * @see       EDEmployee
 * @generated
 */
public class EDEmployeeWrapper implements EDEmployee, ModelWrapper<EDEmployee> {
	public EDEmployeeWrapper(EDEmployee edEmployee) {
		_edEmployee = edEmployee;
	}

	public Class<?> getModelClass() {
		return EDEmployee.class;
	}

	public String getModelClassName() {
		return EDEmployee.class.getName();
	}

	/**
	* Returns the primary key of this e d employee.
	*
	* @return the primary key of this e d employee
	*/
	public long getPrimaryKey() {
		return _edEmployee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e d employee.
	*
	* @param primaryKey the primary key of this e d employee
	*/
	public void setPrimaryKey(long primaryKey) {
		_edEmployee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e d employee.
	*
	* @return the uuid of this e d employee
	*/
	public java.lang.String getUuid() {
		return _edEmployee.getUuid();
	}

	/**
	* Sets the uuid of this e d employee.
	*
	* @param uuid the uuid of this e d employee
	*/
	public void setUuid(java.lang.String uuid) {
		_edEmployee.setUuid(uuid);
	}

	/**
	* Returns the ID of this e d employee.
	*
	* @return the ID of this e d employee
	*/
	public long getId() {
		return _edEmployee.getId();
	}

	/**
	* Sets the ID of this e d employee.
	*
	* @param id the ID of this e d employee
	*/
	public void setId(long id) {
		_edEmployee.setId(id);
	}

	/**
	* Returns the created date of this e d employee.
	*
	* @return the created date of this e d employee
	*/
	public java.util.Date getCreatedDate() {
		return _edEmployee.getCreatedDate();
	}

	/**
	* Sets the created date of this e d employee.
	*
	* @param createdDate the created date of this e d employee
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_edEmployee.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this e d employee.
	*
	* @return the modified date of this e d employee
	*/
	public java.util.Date getModifiedDate() {
		return _edEmployee.getModifiedDate();
	}

	/**
	* Sets the modified date of this e d employee.
	*
	* @param modifiedDate the modified date of this e d employee
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_edEmployee.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this e d employee.
	*
	* @return the title of this e d employee
	*/
	public java.lang.String getTitle() {
		return _edEmployee.getTitle();
	}

	/**
	* Sets the title of this e d employee.
	*
	* @param title the title of this e d employee
	*/
	public void setTitle(java.lang.String title) {
		_edEmployee.setTitle(title);
	}

	/**
	* Returns the name of this e d employee.
	*
	* @return the name of this e d employee
	*/
	public java.lang.String getName() {
		return _edEmployee.getName();
	}

	/**
	* Sets the name of this e d employee.
	*
	* @param name the name of this e d employee
	*/
	public void setName(java.lang.String name) {
		_edEmployee.setName(name);
	}

	/**
	* Returns the birthday of this e d employee.
	*
	* @return the birthday of this e d employee
	*/
	public java.util.Date getBirthday() {
		return _edEmployee.getBirthday();
	}

	/**
	* Sets the birthday of this e d employee.
	*
	* @param birthday the birthday of this e d employee
	*/
	public void setBirthday(java.util.Date birthday) {
		_edEmployee.setBirthday(birthday);
	}

	/**
	* Returns the home side of this e d employee.
	*
	* @return the home side of this e d employee
	*/
	public java.lang.String getHomeSide() {
		return _edEmployee.getHomeSide();
	}

	/**
	* Sets the home side of this e d employee.
	*
	* @param homeSide the home side of this e d employee
	*/
	public void setHomeSide(java.lang.String homeSide) {
		_edEmployee.setHomeSide(homeSide);
	}

	/**
	* Returns the family of this e d employee.
	*
	* @return the family of this e d employee
	*/
	public java.lang.String getFamily() {
		return _edEmployee.getFamily();
	}

	/**
	* Sets the family of this e d employee.
	*
	* @param family the family of this e d employee
	*/
	public void setFamily(java.lang.String family) {
		_edEmployee.setFamily(family);
	}

	/**
	* Returns the race of this e d employee.
	*
	* @return the race of this e d employee
	*/
	public java.lang.String getRace() {
		return _edEmployee.getRace();
	}

	/**
	* Sets the race of this e d employee.
	*
	* @param race the race of this e d employee
	*/
	public void setRace(java.lang.String race) {
		_edEmployee.setRace(race);
	}

	/**
	* Returns the home of this e d employee.
	*
	* @return the home of this e d employee
	*/
	public java.lang.String getHome() {
		return _edEmployee.getHome();
	}

	/**
	* Sets the home of this e d employee.
	*
	* @param home the home of this e d employee
	*/
	public void setHome(java.lang.String home) {
		_edEmployee.setHome(home);
	}

	/**
	* Returns the home phone of this e d employee.
	*
	* @return the home phone of this e d employee
	*/
	public java.lang.String getHomePhone() {
		return _edEmployee.getHomePhone();
	}

	/**
	* Sets the home phone of this e d employee.
	*
	* @param homePhone the home phone of this e d employee
	*/
	public void setHomePhone(java.lang.String homePhone) {
		_edEmployee.setHomePhone(homePhone);
	}

	/**
	* Returns the work phone of this e d employee.
	*
	* @return the work phone of this e d employee
	*/
	public java.lang.String getWorkPhone() {
		return _edEmployee.getWorkPhone();
	}

	/**
	* Sets the work phone of this e d employee.
	*
	* @param workPhone the work phone of this e d employee
	*/
	public void setWorkPhone(java.lang.String workPhone) {
		_edEmployee.setWorkPhone(workPhone);
	}

	/**
	* Returns the mobile phone of this e d employee.
	*
	* @return the mobile phone of this e d employee
	*/
	public java.lang.String getMobilePhone() {
		return _edEmployee.getMobilePhone();
	}

	/**
	* Sets the mobile phone of this e d employee.
	*
	* @param mobilePhone the mobile phone of this e d employee
	*/
	public void setMobilePhone(java.lang.String mobilePhone) {
		_edEmployee.setMobilePhone(mobilePhone);
	}

	/**
	* Returns the email of this e d employee.
	*
	* @return the email of this e d employee
	*/
	public java.lang.String getEmail() {
		return _edEmployee.getEmail();
	}

	/**
	* Sets the email of this e d employee.
	*
	* @param email the email of this e d employee
	*/
	public void setEmail(java.lang.String email) {
		_edEmployee.setEmail(email);
	}

	/**
	* Returns the department ID of this e d employee.
	*
	* @return the department ID of this e d employee
	*/
	public long getDepartmentId() {
		return _edEmployee.getDepartmentId();
	}

	/**
	* Sets the department ID of this e d employee.
	*
	* @param departmentId the department ID of this e d employee
	*/
	public void setDepartmentId(long departmentId) {
		_edEmployee.setDepartmentId(departmentId);
	}

	/**
	* Returns the major level of this e d employee.
	*
	* @return the major level of this e d employee
	*/
	public java.lang.String getMajorLevel() {
		return _edEmployee.getMajorLevel();
	}

	/**
	* Sets the major level of this e d employee.
	*
	* @param majorLevel the major level of this e d employee
	*/
	public void setMajorLevel(java.lang.String majorLevel) {
		_edEmployee.setMajorLevel(majorLevel);
	}

	/**
	* Returns the philosophism of this e d employee.
	*
	* @return the philosophism of this e d employee
	*/
	public java.lang.String getPhilosophism() {
		return _edEmployee.getPhilosophism();
	}

	/**
	* Sets the philosophism of this e d employee.
	*
	* @param philosophism the philosophism of this e d employee
	*/
	public void setPhilosophism(java.lang.String philosophism) {
		_edEmployee.setPhilosophism(philosophism);
	}

	/**
	* Returns the foreign language of this e d employee.
	*
	* @return the foreign language of this e d employee
	*/
	public java.lang.String getForeignLanguage() {
		return _edEmployee.getForeignLanguage();
	}

	/**
	* Sets the foreign language of this e d employee.
	*
	* @param foreignLanguage the foreign language of this e d employee
	*/
	public void setForeignLanguage(java.lang.String foreignLanguage) {
		_edEmployee.setForeignLanguage(foreignLanguage);
	}

	/**
	* Returns the join date of this e d employee.
	*
	* @return the join date of this e d employee
	*/
	public java.util.Date getJoinDate() {
		return _edEmployee.getJoinDate();
	}

	/**
	* Sets the join date of this e d employee.
	*
	* @param joinDate the join date of this e d employee
	*/
	public void setJoinDate(java.util.Date joinDate) {
		_edEmployee.setJoinDate(joinDate);
	}

	/**
	* Returns the image of this e d employee.
	*
	* @return the image of this e d employee
	*/
	public java.lang.String getImage() {
		return _edEmployee.getImage();
	}

	/**
	* Sets the image of this e d employee.
	*
	* @param image the image of this e d employee
	*/
	public void setImage(java.lang.String image) {
		_edEmployee.setImage(image);
	}

	/**
	* Returns the is show tree of this e d employee.
	*
	* @return the is show tree of this e d employee
	*/
	public boolean getIsShowTree() {
		return _edEmployee.getIsShowTree();
	}

	/**
	* Returns <code>true</code> if this e d employee is is show tree.
	*
	* @return <code>true</code> if this e d employee is is show tree; <code>false</code> otherwise
	*/
	public boolean isIsShowTree() {
		return _edEmployee.isIsShowTree();
	}

	/**
	* Sets whether this e d employee is is show tree.
	*
	* @param isShowTree the is show tree of this e d employee
	*/
	public void setIsShowTree(boolean isShowTree) {
		_edEmployee.setIsShowTree(isShowTree);
	}

	/**
	* Returns the other info of this e d employee.
	*
	* @return the other info of this e d employee
	*/
	public java.lang.String getOtherInfo() {
		return _edEmployee.getOtherInfo();
	}

	/**
	* Sets the other info of this e d employee.
	*
	* @param otherInfo the other info of this e d employee
	*/
	public void setOtherInfo(java.lang.String otherInfo) {
		_edEmployee.setOtherInfo(otherInfo);
	}

	/**
	* Returns the company ID of this e d employee.
	*
	* @return the company ID of this e d employee
	*/
	public long getCompanyId() {
		return _edEmployee.getCompanyId();
	}

	/**
	* Sets the company ID of this e d employee.
	*
	* @param companyId the company ID of this e d employee
	*/
	public void setCompanyId(long companyId) {
		_edEmployee.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this e d employee.
	*
	* @return the group ID of this e d employee
	*/
	public long getGroupId() {
		return _edEmployee.getGroupId();
	}

	/**
	* Sets the group ID of this e d employee.
	*
	* @param groupId the group ID of this e d employee
	*/
	public void setGroupId(long groupId) {
		_edEmployee.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this e d employee.
	*
	* @return the user ID of this e d employee
	*/
	public long getUserId() {
		return _edEmployee.getUserId();
	}

	/**
	* Sets the user ID of this e d employee.
	*
	* @param userId the user ID of this e d employee
	*/
	public void setUserId(long userId) {
		_edEmployee.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e d employee.
	*
	* @return the user uuid of this e d employee
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _edEmployee.getUserUuid();
	}

	/**
	* Sets the user uuid of this e d employee.
	*
	* @param userUuid the user uuid of this e d employee
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_edEmployee.setUserUuid(userUuid);
	}

	/**
	* Returns the language ID of this e d employee.
	*
	* @return the language ID of this e d employee
	*/
	public java.lang.String getLanguageId() {
		return _edEmployee.getLanguageId();
	}

	/**
	* Sets the language ID of this e d employee.
	*
	* @param languageId the language ID of this e d employee
	*/
	public void setLanguageId(java.lang.String languageId) {
		_edEmployee.setLanguageId(languageId);
	}

	/**
	* Returns the display order of this e d employee.
	*
	* @return the display order of this e d employee
	*/
	public long getDisplayOrder() {
		return _edEmployee.getDisplayOrder();
	}

	/**
	* Sets the display order of this e d employee.
	*
	* @param displayOrder the display order of this e d employee
	*/
	public void setDisplayOrder(long displayOrder) {
		_edEmployee.setDisplayOrder(displayOrder);
	}

	/**
	* Returns the sex of this e d employee.
	*
	* @return the sex of this e d employee
	*/
	public java.lang.String getSex() {
		return _edEmployee.getSex();
	}

	/**
	* Sets the sex of this e d employee.
	*
	* @param sex the sex of this e d employee
	*/
	public void setSex(java.lang.String sex) {
		_edEmployee.setSex(sex);
	}

	/**
	* Returns the status of this e d employee.
	*
	* @return the status of this e d employee
	*/
	public long getStatus() {
		return _edEmployee.getStatus();
	}

	/**
	* Sets the status of this e d employee.
	*
	* @param status the status of this e d employee
	*/
	public void setStatus(long status) {
		_edEmployee.setStatus(status);
	}

	/**
	* Returns the show of this e d employee.
	*
	* @return the show of this e d employee
	*/
	public java.lang.String getShow() {
		return _edEmployee.getShow();
	}

	/**
	* Sets the show of this e d employee.
	*
	* @param show the show of this e d employee
	*/
	public void setShow(java.lang.String show) {
		_edEmployee.setShow(show);
	}

	public boolean isNew() {
		return _edEmployee.isNew();
	}

	public void setNew(boolean n) {
		_edEmployee.setNew(n);
	}

	public boolean isCachedModel() {
		return _edEmployee.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_edEmployee.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _edEmployee.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _edEmployee.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_edEmployee.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _edEmployee.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_edEmployee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EDEmployeeWrapper((EDEmployee)_edEmployee.clone());
	}

	public int compareTo(
		com.vportal.portlet.edirectory.model.EDEmployee edEmployee) {
		return _edEmployee.compareTo(edEmployee);
	}

	@Override
	public int hashCode() {
		return _edEmployee.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.edirectory.model.EDEmployee> toCacheModel() {
		return _edEmployee.toCacheModel();
	}

	public com.vportal.portlet.edirectory.model.EDEmployee toEscapedModel() {
		return new EDEmployeeWrapper(_edEmployee.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _edEmployee.toString();
	}

	public java.lang.String toXmlString() {
		return _edEmployee.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_edEmployee.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public EDEmployee getWrappedEDEmployee() {
		return _edEmployee;
	}

	public EDEmployee getWrappedModel() {
		return _edEmployee;
	}

	public void resetOriginalValues() {
		_edEmployee.resetOriginalValues();
	}

	private EDEmployee _edEmployee;
}