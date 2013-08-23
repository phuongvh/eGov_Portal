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
import com.vportal.portlet.vdoc.DeleteOrgException;
import com.vportal.portlet.vdoc.InvalidNameFieldException;
import com.vportal.portlet.vdoc.NoSuchvdocOrgException;
import com.vportal.portlet.vdoc.model.vdocDORel;
import com.vportal.portlet.vdoc.model.vdocField;
import com.vportal.portlet.vdoc.model.vdocOrg;
import com.vportal.portlet.vdoc.service.vdocDORelServiceUtil;
import com.vportal.portlet.vdoc.service.vdocOrgServiceUtil;
import com.vportal.portlet.vdoc.service.base.vdocOrgServiceBaseImpl;

/**
 * The implementation of the vdoc org remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vdoc.service.vdocOrgService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author MrEn
 * @see com.vportal.portlet.vdoc.service.base.vdocOrgServiceBaseImpl
 * @see com.vportal.portlet.vdoc.service.vdocOrgServiceUtil
 */
public class vdocOrgServiceImpl extends vdocOrgServiceBaseImpl {
	public vdocOrg addOrg(long groupId, long userId, String language, String parentId,
			String name, String description, String address, String phone ,boolean statusOrg, 
			int position, String fax , String listparent, String[] communityPermissions,
			String[] guestPermissions, ThemeDisplay themeDisplay) throws PortalException, SystemException, RemoteException{
		
		return addOrg(groupId, userId, language, parentId, name, description, address, phone, statusOrg,
				position, fax, listparent, null, null, communityPermissions, guestPermissions, themeDisplay);
	}
	
	public vdocOrg addOrg(long groupId, long userId, String language, String parentId,
			String name, String description, String address, String phone, boolean statusOrg,
			int position, String fax, String listparent, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions, String[] guestPermissions, ThemeDisplay themeDisplay) throws PortalException, SystemException, RemoteException{
		
		_validator(name);
		String orgId = String.valueOf(CounterLocalServiceUtil.increment(vdocOrg.class.getName())) ;
		Date now = new Date();
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		vdocOrg org = vdocOrgPersistence.create(orgId);
		
		org.setGroupId(groupId);
		org.setCompanyId(user.getCompanyId());
		org.setUserId(userId);
		org.setCreatedDate(now);
		org.setCreatedByUser(userId);
		org.setParentId(parentId);
		org.setName(name);
		org.setDescription(description);
		org.setAddress(address);
		org.setPhone(phone);
		org.setFax(fax);
		org.setLanguage(language);
		org.setStatusOrg(statusOrg);
		org.setPosition(position);
		
		if(Validator.equals(parentId,"0")){
			org.setListparent(0+"/"+orgId+"/");
		}else{
			org.setListparent(listparent + orgId+"/");
		}
		
		vdocOrgPersistence.update(org, false);
		if((addCommunityPermissions != null) && (addGuestPermissions != null)){
			addEntryResources(org, addCommunityPermissions.booleanValue() , addGuestPermissions.booleanValue());
		}else{
			addEntryResources(org, communityPermissions, guestPermissions);
		}
		
		return org;
	}
	
	public vdocOrg updateOrg(vdocOrg org, long userId) throws NoSuchvdocOrgException, NoSuchUserException, SystemException{
		return updateOrg(org.getOrgId(), org.getGroupId(), org.getLanguage(), 
				org.getParentId(), org.getName(), org.getDescription(), org.getAddress(), 
				org.getPhone(), org.getStatusOrg(), org.getPosition(), org.getFax(), org.getListparent(), userId);
	}
	
	public vdocOrg updateOrg(String orgId, long groupId, String language, 
			String parentId, String name, String description, String address, 
			String phone, boolean statusOrg, int position, String fax, String listparent, long userId) throws SystemException, NoSuchvdocOrgException, NoSuchUserException{
		
		vdocOrg org = vdocOrgPersistence.findByPrimaryKey(orgId);
		
		User user = userPersistence.findByPrimaryKey(userId);
		
		org.setGroupId(groupId);
		org.setCompanyId(user.getCompanyId());
		
		org.setParentId(parentId);
		org.setName(name);
		org.setDescription(description);
		org.setAddress(address);
		org.setPhone(phone);
		org.setPosition(position);
		org.setStatusOrg(statusOrg);
		org.setFax(fax);
		org.setLanguage(language);
		
		org.setModifiedByUser(userId);
		org.setModifiedDate(new Date());
		
		if(Validator.equals(parentId, "0")){
			org.setListparent(0 + "/" + orgId + "/");
		}else{
			org.setListparent(listparent + orgId + "/");
		}
		
		vdocOrgPersistence.update(org, false);
		return org;
	}
	
	public void deleteOrg(String orgId) throws NoSuchvdocOrgException, SystemException, DeleteOrgException, PortalException{
		vdocOrg org = vdocOrgPersistence.findByPrimaryKey(orgId);
		
		List<vdocOrg> orgChildList = vdocOrgServiceUtil.getOrgByParentId(orgId);
		if(Validator.isNotNull(orgChildList) && orgChildList.size() > 0){
			throw new DeleteOrgException();
		}
		
		List<vdocDORel> docList = vdocDORelServiceUtil.getDORelByOrg(orgId);
		if(Validator.isNotNull(docList) && docList.size() > 0){
			throw new DeleteOrgException();
		}
		
		vdocOrgPersistence.remove(orgId);
		resourceLocalService.deleteResource(org.getCompanyId(), vdocOrg.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, org.getOrgId());
	}
	
	public vdocOrg getOrg(String orgId) throws NoSuchvdocOrgException, SystemException{
		return vdocOrgPersistence.findByPrimaryKey(orgId);
	}
	
	public List<vdocOrg> getOrgByParentId(String parentId) throws SystemException{
		return vdocOrgPersistence.findByParentId(parentId);
	}
	
	public List<vdocOrg> getOrgByG_L(long groupId, String language) throws SystemException{
		return vdocOrgPersistence.findByG_L(groupId, language);
	}
	
	public List<vdocOrg> getOrgByG_L(long groupId, String language, int begin, int end) throws SystemException{
		return vdocOrgPersistence.findByG_L(groupId, language, begin, end);
	}
	
	public List<vdocOrg> getOrgByG_L_P(long groupId, String language, String parentId) throws SystemException{
		return vdocOrgPersistence.findByG_L_P(groupId, language, parentId);
	}
	
	public List<vdocOrg> getOrgByG_L_P(long groupId, String language, String parentId, int begin, int end) throws SystemException{
		return vdocOrgPersistence.findByG_L_P(groupId, language, parentId, begin, end);
	}
	
	public int countOrgByG_L(long groupId, String language) throws SystemException{
		return vdocOrgPersistence.findByG_L(groupId, language).size();
	}
	
	public int countOrgByG_L_P(long groupId, String language, String parentId) throws SystemException{
		return vdocOrgPersistence.findByG_L_P(groupId, language, parentId).size();
	}
	
	public void addEntryResources(long entryId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		vdocOrg entry = vdocOrgPersistence.findByPrimaryKey(String
				.valueOf(entryId));

		addEntryResources(entry, addCommunityPermissions, addGuestPermissions);
	}

	public void addEntryResources(vdocOrg entry,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addResources(entry.getCompanyId(), entry
				.getGroupId(), entry.getUserId(), vdocField.class.getName(),
				entry.getOrgId(), false, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addEntryResources(long entryId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		vdocOrg entry = vdocOrgPersistence.findByPrimaryKey(String
				.valueOf(entryId));

		addEntryResources(entry, communityPermissions, guestPermissions);
	}

	public void addEntryResources(vdocOrg entry,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		resourceLocalService.addModelResources(entry.getCompanyId(), entry
				.getGroupId(), entry.getUserId(), vdocField.class.getName(),
				entry.getOrgId(), communityPermissions, guestPermissions);
	}

	private void _validator(String name) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(name)) {
			throw new InvalidNameFieldException();
		}
	}
}