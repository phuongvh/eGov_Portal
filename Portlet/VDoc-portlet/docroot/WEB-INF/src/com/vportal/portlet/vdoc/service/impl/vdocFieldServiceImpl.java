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

package com.vportal.portlet.vdoc.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.vportal.portlet.vdoc.DeleteFieldException;
import com.vportal.portlet.vdoc.InvalidNameFieldException;
import com.vportal.portlet.vdoc.NoSuchvdocFieldException;
import com.vportal.portlet.vdoc.model.vdocDocument;
import com.vportal.portlet.vdoc.model.vdocField;
import com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil;
import com.vportal.portlet.vdoc.service.vdocFieldServiceUtil;
import com.vportal.portlet.vdoc.service.base.vdocFieldServiceBaseImpl;

/**
 * The implementation of the vdoc field remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vdoc.service.vdocFieldService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see com.vportal.portlet.vdoc.service.base.vdocFieldServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.vdocFieldServiceUtil
 */
public class vdocFieldServiceImpl extends vdocFieldServiceBaseImpl {
	
	public vdocField addField(long groupId, long userId, String language, String parentId, 
			String name, String description, boolean statusField, int position,
			String listparent, String[] communityPermissions,
			String[] guestPermissions, ThemeDisplay themeDisplay) throws SystemException, PortalException, RemoteException{
		
		return addField(groupId, userId, language, parentId, name, description,
				statusField, position, listparent, null, null,
				communityPermissions, guestPermissions, themeDisplay);
	}
	
	public vdocField addField(long groupId, long userId, String language, String parentId,
			String name, String description, boolean statusField, int position,
			String listparent, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions, ThemeDisplay themeDisplay) throws SystemException, PortalException, RemoteException{
		
		_validator(name);
		String fieldId = String.valueOf(CounterLocalServiceUtil.increment(vdocField.class.getName())) ;
		Date now = new Date();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		vdocField vField = vdocFieldPersistence.create(fieldId);
		
		vField.setCreatedDate(now);
		vField.setCreatedByUser(userId);
		vField.setUserId(userId);
		vField.setGroupId(groupId);
		vField.setLanguage(language);
		vField.setCompanyId(user.getCompanyId());
		
		vField.setParentId(parentId);	
		
		vField.setName(name);
		vField.setDescription(description);
		vField.setStatusField(statusField);
		vField.setPosition(position);
		
		if(Validator.equals(parentId,"0")){
			vField.setListparent(0+"/"+fieldId+"/");
		}else{
			vField.setListparent(listparent + fieldId+"/");
		}
		
		vdocFieldPersistence.update(vField, false);
		
		if((addCommunityPermissions != null) && (addGuestPermissions != null)){
			addEntryResources(vField, addCommunityPermissions.booleanValue() , addGuestPermissions.booleanValue());
		}else{
			addEntryResources(vField, communityPermissions, guestPermissions);
		}
		
		return vField;
	}
	
	public vdocField updateField(vdocField field, long userId) throws NoSuchvdocFieldException, SystemException, NoSuchUserException{
		return updateField(field.getFieldId(), field.getGroupId(), field.getLanguage(),
				field.getParentId(), field.getName(), field.getDescription(), field.getStatusField(),
				field.getPosition(), field.getListparent(), userId);
	}
	
	
	public vdocField updateField(String fieldId, long groupId,
			String language, String parentId, String name, String description,
			boolean statusField, int position, String listparent, long userId) throws NoSuchvdocFieldException, SystemException, NoSuchUserException {
		
		vdocField field = vdocFieldPersistence.findByPrimaryKey(fieldId);
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		field.setCompanyId(user.getCompanyId());
		field.setGroupId(groupId);
		field.setLanguage(language);
		field.setName(name);
		field.setDescription(description);
		field.setStatusField(statusField);
		field.setPosition(position);
		field.setParentId(parentId);
		
		field.setModifiedDate(new Date());
		field.setModifiedByUser(userId);
		
		if(Validator.equals(parentId, "0")){
			field.setListparent(0 + "/" + fieldId + "/");
		}else{
			field.setListparent(listparent + fieldId + "/");
		}
		
		vdocFieldPersistence.update(field, false);
		
		return field;
	}
	
	public void deleteField(String fieldId) throws SystemException, PortalException{
		vdocField field = vdocFieldPersistence.findByPrimaryKey(fieldId);
		
		// Danh sách các Field mà có parentId là "fieldId"
		List<vdocField> fieldChildList = vdocFieldServiceUtil.getFieldByParentId(field.getFieldId());
		if(Validator.isNotNull(fieldChildList) && fieldChildList.size() > 0){
			throw new DeleteFieldException();
		}
		
		// Danh sách các Document mà thuộc lĩnh vực có id là fieldId
		List<vdocDocument> docList = vdocDocumentServiceUtil.getDocByG_L_F(field.getGroupId(), field.getLanguage(), fieldId);
		if(Validator.isNotNull(docList) && docList.size() > 0){
			throw new DeleteFieldException();
		}
		
		vdocFieldPersistence.remove(field);
		resourceLocalService.deleteResource(field.getCompanyId(), vdocField.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, field.getFieldId());
	}
	
	public vdocField getField(String fieldId) throws NoSuchvdocFieldException, SystemException{
		return vdocFieldPersistence.findByPrimaryKey(fieldId);
	}

	public List<vdocField> getFieldByParentId(String parentId) throws SystemException{
		return vdocFieldPersistence.findByParentId(parentId);
	}
	
	public List<vdocField> getFieldByG_L(long groupId, String language) throws SystemException{
		return vdocFieldPersistence.findByG_L(groupId, language);
	}
	
	public List<vdocField> getFieldByG_L_P(long groupId, String language, String parentId) throws SystemException{
		return vdocFieldPersistence.findByG_L_P(groupId, language, parentId);
	}
	
	public List<vdocField> getFieldByG_L_P(long groupId, String language, String parentId, int begin, int end) throws SystemException{
		return vdocFieldPersistence.findByG_L_P(groupId, language, parentId, begin, end);
	}
	
	public List<vdocField> getFieldByG_L(long groupId, String language, int begin, int end) throws SystemException{
		return vdocFieldPersistence.findByG_L(groupId, language, begin, end);
	}
	
	public int countFieldByG_L(long groupId, String language) throws SystemException{
		return vdocFieldPersistence.countByG_L(groupId, language);
	}
	
	public int countFieldByG_L_P(long groupId, String language, String parentId) throws SystemException{
		return vdocFieldPersistence.countByG_L_P(groupId, language, parentId);
	}
	
	public void addEntryResources(long entryId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		vdocField entry = vdocFieldPersistence.findByPrimaryKey(String
				.valueOf(entryId));

		addEntryResources(entry, addCommunityPermissions, addGuestPermissions);
	}

	public void addEntryResources(vdocField entry,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addResources(entry.getCompanyId(), entry
				.getGroupId(), entry.getUserId(), vdocField.class.getName(),
				entry.getFieldId(), false, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addEntryResources(long entryId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		vdocField entry = vdocFieldPersistence.findByPrimaryKey(String
				.valueOf(entryId));

		addEntryResources(entry, communityPermissions, guestPermissions);
	}

	public void addEntryResources(vdocField entry,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(entry.getCompanyId(), entry
				.getGroupId(), entry.getUserId(), vdocField.class.getName(),
				entry.getFieldId(), communityPermissions, guestPermissions);
	}

	private void _validator(String name) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(name)) {
			throw new InvalidNameFieldException();
		}
	}
}