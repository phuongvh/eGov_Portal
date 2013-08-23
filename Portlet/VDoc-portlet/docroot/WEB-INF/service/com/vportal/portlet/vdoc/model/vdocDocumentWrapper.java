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

package com.vportal.portlet.vdoc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link vdocDocument}.
 * </p>
 *
 * @author    MrEn
 * @see       vdocDocument
 * @generated
 */
public class vdocDocumentWrapper implements vdocDocument,
	ModelWrapper<vdocDocument> {
	public vdocDocumentWrapper(vdocDocument vdocDocument) {
		_vdocDocument = vdocDocument;
	}

	public Class<?> getModelClass() {
		return vdocDocument.class;
	}

	public String getModelClassName() {
		return vdocDocument.class.getName();
	}

	/**
	* Returns the primary key of this vdoc document.
	*
	* @return the primary key of this vdoc document
	*/
	public java.lang.String getPrimaryKey() {
		return _vdocDocument.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vdoc document.
	*
	* @param primaryKey the primary key of this vdoc document
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_vdocDocument.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the doc ID of this vdoc document.
	*
	* @return the doc ID of this vdoc document
	*/
	public java.lang.String getDocId() {
		return _vdocDocument.getDocId();
	}

	/**
	* Sets the doc ID of this vdoc document.
	*
	* @param docId the doc ID of this vdoc document
	*/
	public void setDocId(java.lang.String docId) {
		_vdocDocument.setDocId(docId);
	}

	/**
	* Returns the group ID of this vdoc document.
	*
	* @return the group ID of this vdoc document
	*/
	public long getGroupId() {
		return _vdocDocument.getGroupId();
	}

	/**
	* Sets the group ID of this vdoc document.
	*
	* @param groupId the group ID of this vdoc document
	*/
	public void setGroupId(long groupId) {
		_vdocDocument.setGroupId(groupId);
	}

	/**
	* Returns the language of this vdoc document.
	*
	* @return the language of this vdoc document
	*/
	public java.lang.String getLanguage() {
		return _vdocDocument.getLanguage();
	}

	/**
	* Sets the language of this vdoc document.
	*
	* @param language the language of this vdoc document
	*/
	public void setLanguage(java.lang.String language) {
		_vdocDocument.setLanguage(language);
	}

	/**
	* Returns the company ID of this vdoc document.
	*
	* @return the company ID of this vdoc document
	*/
	public long getCompanyId() {
		return _vdocDocument.getCompanyId();
	}

	/**
	* Sets the company ID of this vdoc document.
	*
	* @param companyId the company ID of this vdoc document
	*/
	public void setCompanyId(long companyId) {
		_vdocDocument.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vdoc document.
	*
	* @return the user ID of this vdoc document
	*/
	public long getUserId() {
		return _vdocDocument.getUserId();
	}

	/**
	* Sets the user ID of this vdoc document.
	*
	* @param userId the user ID of this vdoc document
	*/
	public void setUserId(long userId) {
		_vdocDocument.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vdoc document.
	*
	* @return the user uuid of this vdoc document
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vdocDocument.getUserUuid();
	}

	/**
	* Sets the user uuid of this vdoc document.
	*
	* @param userUuid the user uuid of this vdoc document
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_vdocDocument.setUserUuid(userUuid);
	}

	/**
	* Returns the created by user of this vdoc document.
	*
	* @return the created by user of this vdoc document
	*/
	public long getCreatedByUser() {
		return _vdocDocument.getCreatedByUser();
	}

	/**
	* Sets the created by user of this vdoc document.
	*
	* @param createdByUser the created by user of this vdoc document
	*/
	public void setCreatedByUser(long createdByUser) {
		_vdocDocument.setCreatedByUser(createdByUser);
	}

	/**
	* Returns the created date of this vdoc document.
	*
	* @return the created date of this vdoc document
	*/
	public java.util.Date getCreatedDate() {
		return _vdocDocument.getCreatedDate();
	}

	/**
	* Sets the created date of this vdoc document.
	*
	* @param createdDate the created date of this vdoc document
	*/
	public void setCreatedDate(java.util.Date createdDate) {
		_vdocDocument.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified by user of this vdoc document.
	*
	* @return the modified by user of this vdoc document
	*/
	public long getModifiedByUser() {
		return _vdocDocument.getModifiedByUser();
	}

	/**
	* Sets the modified by user of this vdoc document.
	*
	* @param modifiedByUser the modified by user of this vdoc document
	*/
	public void setModifiedByUser(long modifiedByUser) {
		_vdocDocument.setModifiedByUser(modifiedByUser);
	}

	/**
	* Returns the modified date of this vdoc document.
	*
	* @return the modified date of this vdoc document
	*/
	public java.util.Date getModifiedDate() {
		return _vdocDocument.getModifiedDate();
	}

	/**
	* Sets the modified date of this vdoc document.
	*
	* @param modifiedDate the modified date of this vdoc document
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vdocDocument.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the approved by user of this vdoc document.
	*
	* @return the approved by user of this vdoc document
	*/
	public long getApprovedByUser() {
		return _vdocDocument.getApprovedByUser();
	}

	/**
	* Sets the approved by user of this vdoc document.
	*
	* @param approvedByUser the approved by user of this vdoc document
	*/
	public void setApprovedByUser(long approvedByUser) {
		_vdocDocument.setApprovedByUser(approvedByUser);
	}

	/**
	* Returns the approved date of this vdoc document.
	*
	* @return the approved date of this vdoc document
	*/
	public java.util.Date getApprovedDate() {
		return _vdocDocument.getApprovedDate();
	}

	/**
	* Sets the approved date of this vdoc document.
	*
	* @param approvedDate the approved date of this vdoc document
	*/
	public void setApprovedDate(java.util.Date approvedDate) {
		_vdocDocument.setApprovedDate(approvedDate);
	}

	/**
	* Returns the published by user of this vdoc document.
	*
	* @return the published by user of this vdoc document
	*/
	public long getPublishedByUser() {
		return _vdocDocument.getPublishedByUser();
	}

	/**
	* Sets the published by user of this vdoc document.
	*
	* @param publishedByUser the published by user of this vdoc document
	*/
	public void setPublishedByUser(long publishedByUser) {
		_vdocDocument.setPublishedByUser(publishedByUser);
	}

	/**
	* Returns the published date of this vdoc document.
	*
	* @return the published date of this vdoc document
	*/
	public java.util.Date getPublishedDate() {
		return _vdocDocument.getPublishedDate();
	}

	/**
	* Sets the published date of this vdoc document.
	*
	* @param publishedDate the published date of this vdoc document
	*/
	public void setPublishedDate(java.util.Date publishedDate) {
		_vdocDocument.setPublishedDate(publishedDate);
	}

	/**
	* Returns the promul date of this vdoc document.
	*
	* @return the promul date of this vdoc document
	*/
	public java.util.Date getPromulDate() {
		return _vdocDocument.getPromulDate();
	}

	/**
	* Sets the promul date of this vdoc document.
	*
	* @param promulDate the promul date of this vdoc document
	*/
	public void setPromulDate(java.util.Date promulDate) {
		_vdocDocument.setPromulDate(promulDate);
	}

	/**
	* Returns the effectived date of this vdoc document.
	*
	* @return the effectived date of this vdoc document
	*/
	public java.util.Date getEffectivedDate() {
		return _vdocDocument.getEffectivedDate();
	}

	/**
	* Sets the effectived date of this vdoc document.
	*
	* @param effectivedDate the effectived date of this vdoc document
	*/
	public void setEffectivedDate(java.util.Date effectivedDate) {
		_vdocDocument.setEffectivedDate(effectivedDate);
	}

	/**
	* Returns the expired date of this vdoc document.
	*
	* @return the expired date of this vdoc document
	*/
	public java.util.Date getExpiredDate() {
		return _vdocDocument.getExpiredDate();
	}

	/**
	* Sets the expired date of this vdoc document.
	*
	* @param expiredDate the expired date of this vdoc document
	*/
	public void setExpiredDate(java.util.Date expiredDate) {
		_vdocDocument.setExpiredDate(expiredDate);
	}

	/**
	* Returns the replace doc of this vdoc document.
	*
	* @return the replace doc of this vdoc document
	*/
	public java.lang.String getReplaceDoc() {
		return _vdocDocument.getReplaceDoc();
	}

	/**
	* Sets the replace doc of this vdoc document.
	*
	* @param replaceDoc the replace doc of this vdoc document
	*/
	public void setReplaceDoc(java.lang.String replaceDoc) {
		_vdocDocument.setReplaceDoc(replaceDoc);
	}

	/**
	* Returns the title of this vdoc document.
	*
	* @return the title of this vdoc document
	*/
	public java.lang.String getTitle() {
		return _vdocDocument.getTitle();
	}

	/**
	* Sets the title of this vdoc document.
	*
	* @param title the title of this vdoc document
	*/
	public void setTitle(java.lang.String title) {
		_vdocDocument.setTitle(title);
	}

	/**
	* Returns the content of this vdoc document.
	*
	* @return the content of this vdoc document
	*/
	public java.lang.String getContent() {
		return _vdocDocument.getContent();
	}

	/**
	* Sets the content of this vdoc document.
	*
	* @param content the content of this vdoc document
	*/
	public void setContent(java.lang.String content) {
		_vdocDocument.setContent(content);
	}

	/**
	* Returns the process of this vdoc document.
	*
	* @return the process of this vdoc document
	*/
	public java.lang.String getProcess() {
		return _vdocDocument.getProcess();
	}

	/**
	* Sets the process of this vdoc document.
	*
	* @param process the process of this vdoc document
	*/
	public void setProcess(java.lang.String process) {
		_vdocDocument.setProcess(process);
	}

	/**
	* Returns the base of this vdoc document.
	*
	* @return the base of this vdoc document
	*/
	public java.lang.String getBase() {
		return _vdocDocument.getBase();
	}

	/**
	* Sets the base of this vdoc document.
	*
	* @param base the base of this vdoc document
	*/
	public void setBase(java.lang.String base) {
		_vdocDocument.setBase(base);
	}

	/**
	* Returns the time of this vdoc document.
	*
	* @return the time of this vdoc document
	*/
	public java.lang.String getTime() {
		return _vdocDocument.getTime();
	}

	/**
	* Sets the time of this vdoc document.
	*
	* @param time the time of this vdoc document
	*/
	public void setTime(java.lang.String time) {
		_vdocDocument.setTime(time);
	}

	/**
	* Returns the cost of this vdoc document.
	*
	* @return the cost of this vdoc document
	*/
	public java.lang.String getCost() {
		return _vdocDocument.getCost();
	}

	/**
	* Sets the cost of this vdoc document.
	*
	* @param cost the cost of this vdoc document
	*/
	public void setCost(java.lang.String cost) {
		_vdocDocument.setCost(cost);
	}

	/**
	* Returns the require of this vdoc document.
	*
	* @return the require of this vdoc document
	*/
	public java.lang.String getRequire() {
		return _vdocDocument.getRequire();
	}

	/**
	* Sets the require of this vdoc document.
	*
	* @param require the require of this vdoc document
	*/
	public void setRequire(java.lang.String require) {
		_vdocDocument.setRequire(require);
	}

	/**
	* Returns the result of this vdoc document.
	*
	* @return the result of this vdoc document
	*/
	public java.lang.String getResult() {
		return _vdocDocument.getResult();
	}

	/**
	* Sets the result of this vdoc document.
	*
	* @param result the result of this vdoc document
	*/
	public void setResult(java.lang.String result) {
		_vdocDocument.setResult(result);
	}

	/**
	* Returns the objects of this vdoc document.
	*
	* @return the objects of this vdoc document
	*/
	public java.lang.String getObjects() {
		return _vdocDocument.getObjects();
	}

	/**
	* Sets the objects of this vdoc document.
	*
	* @param objects the objects of this vdoc document
	*/
	public void setObjects(java.lang.String objects) {
		_vdocDocument.setObjects(objects);
	}

	/**
	* Returns the style of this vdoc document.
	*
	* @return the style of this vdoc document
	*/
	public java.lang.String getStyle() {
		return _vdocDocument.getStyle();
	}

	/**
	* Sets the style of this vdoc document.
	*
	* @param style the style of this vdoc document
	*/
	public void setStyle(java.lang.String style) {
		_vdocDocument.setStyle(style);
	}

	/**
	* Returns the position of this vdoc document.
	*
	* @return the position of this vdoc document
	*/
	public int getPosition() {
		return _vdocDocument.getPosition();
	}

	/**
	* Sets the position of this vdoc document.
	*
	* @param position the position of this vdoc document
	*/
	public void setPosition(int position) {
		_vdocDocument.setPosition(position);
	}

	/**
	* Returns the note of this vdoc document.
	*
	* @return the note of this vdoc document
	*/
	public java.lang.String getNote() {
		return _vdocDocument.getNote();
	}

	/**
	* Sets the note of this vdoc document.
	*
	* @param note the note of this vdoc document
	*/
	public void setNote(java.lang.String note) {
		_vdocDocument.setNote(note);
	}

	/**
	* Returns the user hit of this vdoc document.
	*
	* @return the user hit of this vdoc document
	*/
	public int getUserHit() {
		return _vdocDocument.getUserHit();
	}

	/**
	* Sets the user hit of this vdoc document.
	*
	* @param userHit the user hit of this vdoc document
	*/
	public void setUserHit(int userHit) {
		_vdocDocument.setUserHit(userHit);
	}

	/**
	* Returns the status doc of this vdoc document.
	*
	* @return the status doc of this vdoc document
	*/
	public int getStatusDoc() {
		return _vdocDocument.getStatusDoc();
	}

	/**
	* Sets the status doc of this vdoc document.
	*
	* @param statusDoc the status doc of this vdoc document
	*/
	public void setStatusDoc(int statusDoc) {
		_vdocDocument.setStatusDoc(statusDoc);
	}

	/**
	* Returns the type doc of this vdoc document.
	*
	* @return the type doc of this vdoc document
	*/
	public int getTypeDoc() {
		return _vdocDocument.getTypeDoc();
	}

	/**
	* Sets the type doc of this vdoc document.
	*
	* @param typeDoc the type doc of this vdoc document
	*/
	public void setTypeDoc(int typeDoc) {
		_vdocDocument.setTypeDoc(typeDoc);
	}

	/**
	* Returns the has attachment of this vdoc document.
	*
	* @return the has attachment of this vdoc document
	*/
	public boolean getHasAttachment() {
		return _vdocDocument.getHasAttachment();
	}

	/**
	* Returns <code>true</code> if this vdoc document is has attachment.
	*
	* @return <code>true</code> if this vdoc document is has attachment; <code>false</code> otherwise
	*/
	public boolean isHasAttachment() {
		return _vdocDocument.isHasAttachment();
	}

	/**
	* Sets whether this vdoc document is has attachment.
	*
	* @param hasAttachment the has attachment of this vdoc document
	*/
	public void setHasAttachment(boolean hasAttachment) {
		_vdocDocument.setHasAttachment(hasAttachment);
	}

	/**
	* Returns the field ID of this vdoc document.
	*
	* @return the field ID of this vdoc document
	*/
	public java.lang.String getFieldId() {
		return _vdocDocument.getFieldId();
	}

	/**
	* Sets the field ID of this vdoc document.
	*
	* @param fieldId the field ID of this vdoc document
	*/
	public void setFieldId(java.lang.String fieldId) {
		_vdocDocument.setFieldId(fieldId);
	}

	/**
	* Returns the org rels of this vdoc document.
	*
	* @return the org rels of this vdoc document
	*/
	public java.lang.String getOrgRels() {
		return _vdocDocument.getOrgRels();
	}

	/**
	* Sets the org rels of this vdoc document.
	*
	* @param orgRels the org rels of this vdoc document
	*/
	public void setOrgRels(java.lang.String orgRels) {
		_vdocDocument.setOrgRels(orgRels);
	}

	/**
	* Returns the field rels of this vdoc document.
	*
	* @return the field rels of this vdoc document
	*/
	public java.lang.String getFieldRels() {
		return _vdocDocument.getFieldRels();
	}

	/**
	* Sets the field rels of this vdoc document.
	*
	* @param fieldRels the field rels of this vdoc document
	*/
	public void setFieldRels(java.lang.String fieldRels) {
		_vdocDocument.setFieldRels(fieldRels);
	}

	public boolean isNew() {
		return _vdocDocument.isNew();
	}

	public void setNew(boolean n) {
		_vdocDocument.setNew(n);
	}

	public boolean isCachedModel() {
		return _vdocDocument.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vdocDocument.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vdocDocument.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vdocDocument.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vdocDocument.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vdocDocument.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vdocDocument.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new vdocDocumentWrapper((vdocDocument)_vdocDocument.clone());
	}

	public int compareTo(
		com.vportal.portlet.vdoc.model.vdocDocument vdocDocument) {
		return _vdocDocument.compareTo(vdocDocument);
	}

	@Override
	public int hashCode() {
		return _vdocDocument.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.vportal.portlet.vdoc.model.vdocDocument> toCacheModel() {
		return _vdocDocument.toCacheModel();
	}

	public com.vportal.portlet.vdoc.model.vdocDocument toEscapedModel() {
		return new vdocDocumentWrapper(_vdocDocument.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vdocDocument.toString();
	}

	public java.lang.String toXmlString() {
		return _vdocDocument.toXmlString();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public vdocDocument getWrappedvdocDocument() {
		return _vdocDocument;
	}

	public vdocDocument getWrappedModel() {
		return _vdocDocument;
	}

	public void resetOriginalValues() {
		_vdocDocument.resetOriginalValues();
	}

	private vdocDocument _vdocDocument;
}