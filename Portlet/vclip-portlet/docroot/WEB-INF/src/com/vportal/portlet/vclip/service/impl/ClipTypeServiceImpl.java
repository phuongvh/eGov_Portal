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

package com.vportal.portlet.vclip.service.impl;

import com.vportal.portlet.vclip.service.base.ClipTypeServiceBaseImpl;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portlet.journal.NoSuchArticleException;
//import com.vportal.portal.servlet.MainServlet;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vclip.model.Clip;
import com.vportal.portlet.vclip.model.ClipType;
import com.vportal.portlet.vclip.model.impl.ClipTypeImpl;
import com.vportal.portlet.vclip.service.ClipServiceUtil;
import com.vportal.portlet.vclip.service.base.ClipTypeServiceBaseImpl;
import com.vportal.portlet.vclip.service.persistence.ClipTypeUtil;
import com.vportal.portlet.vclip.util.ActionKeysClipExt;
import com.vportal.portlet.vclip.util.WebKeysVClip;

/**
 * The implementation of the clip type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vclip.service.ClipTypeService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.vportal.portlet.vclip.service.ClipTypeServiceUtil} to access the clip type remote service.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vportal.portlet.vclip.service.base.ClipTypeServiceBaseImpl
 * @see com.vportal.portlet.vclip.service.ClipTypeServiceUtil
 */
public class ClipTypeServiceImpl extends ClipTypeServiceBaseImpl {
	public ClipType addClipType(long groupId, long companyId, long plid,ClipType clipType, Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions) throws Exception {
		PortletPermissionUtil.check(getPermissionChecker(),plid,WebKeysVClip.Clip_type_id,ActionKeysClipExt.ADD_CLIPTYPE);
		String id = Long.toString(CounterLocalServiceUtil
				.increment(ClipType.class.getName()));
		ClipType c=ClipTypeUtil.create(id);
		c.setLanguage(clipType.getLanguage());
		c.setCreatedDate(clipType.getCreatedDate());
		c.setModifiedDate(clipType.getModifiedDate());

		c.setTitle(clipType.getTitle());
		c.setName(clipType.getName());
		c.setDescription(clipType.getDescription());	
		
		c.setGroupId(groupId);
		c.setUserId(clipType.getUserId());
		c.setCompanyId(companyId);
		c=clipTypePersistence.update(c,false);
		
		//add permission by cuongnv
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {
		
			addClipTypeResources(c,addCommunityPermissions.booleanValue(), addGuestPermissions.booleanValue());
		} else {
			addClipTypeResources(c, communityPermissions, guestPermissions);
		}
		
		return c;
	}
	
	public ClipType updateClipType(long groupId, long companyId,String clipTypeId, ClipType clipType) throws Exception {
		
		PortletPermissionUtil.check(getPermissionChecker(),WebKeysVClip.Clip_type_id, ActionKeysClipExt.UPDATE);		
		
		ClipType c=ClipTypeUtil.findByPrimaryKey(clipType.getId());
	
		c.setModifiedDate(clipType.getModifiedDate());
		c.setLanguage(clipType.getLanguage());
		c.setTitle(clipType.getTitle());
		c.setName(clipType.getName());
		c.setDescription(clipType.getDescription());		
		
		c=clipTypePersistence.update(c,true);
		
		return c;
	}
	
	public void deleteClipType(ClipType clipType) throws Exception {
		
		deleteClipType(clipType.getId());
	}
	
	public void deleteClipType(String clipTypeId) throws Exception {
		@SuppressWarnings("unchecked")
		List<Clip> clipList= ClipServiceUtil.findByClipTypeId(clipTypeId);
		for(int i=0;i<clipList.size();i++){
			Clip clip=(Clip)clipList.get(i);
			ClipServiceUtil.deleteClip(clip.getId());
		}
		ClipType c = null;
		try {
			c = clipTypePersistence.findByPrimaryKey(clipTypeId);
		} catch (Exception ex) {
			throw new NoSuchArticleException();
		}		
		ResourceLocalServiceUtil.deleteResource(c.getCompanyId(), ClipType.class.getName(), ResourceConstants. SCOPE_INDIVIDUAL, c.getId());
		clipTypePersistence.remove(clipTypeId);
	}

	public ClipType findById(String clipTypeId) throws Exception{
		return clipTypePersistence.findByPrimaryKey(clipTypeId);
	}
	
	public List<ClipType> findAll() throws Exception{
		return clipTypePersistence.findAll();
	}
	public List<ClipType> findAll(int begin,int end) throws Exception{
		return clipTypePersistence.findAll(begin,end);
	}
	public int countAll() throws Exception{
		return clipTypePersistence.countAll();
	}
	public List<ClipType> getLanguage(String language,boolean active)throws Exception{
		return clipTypePersistence.findByLanguage(language, active);
	}
	@SuppressWarnings("unchecked")
	public List<ClipType> findClipType(ClipType clipType) throws Exception{
		return clipTypeFinder.findClipType(clipType);
	}
	@SuppressWarnings("unchecked")
	public List<ClipType> findClipType(ClipType clipType,int start,int end) throws Exception{
		return clipTypeFinder.findClipType(clipType,start,end);
	}
	public int countClipType(ClipType clipType) throws Exception{
		return clipTypeFinder.countClipType(clipType);
	}
	
	//get first cliptype cuongnv
	public ClipType getFirst() throws Exception {
		@SuppressWarnings("rawtypes")
		List myList = clipTypePersistence.findAll();
		if ((myList != null) && (myList.size() > 0)) {
			return (ClipType) myList.get(0);
		}
		return (new ClipTypeImpl());
	}
	
	
	//add permission CuongNV
	public void addClipTypeResources(String articleId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {		
		
		ClipType article = clipTypePersistence.findByPrimaryKey(articleId);

		addClipTypeResources(article, addCommunityPermissions,addGuestPermissions);
	}

	public void addClipTypeResources(ClipType article,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(article.getCompanyId(),
				0, getUserId(), ClipType.class.getName(), article
						.getPrimaryKey().toString(), false,
				addCommunityPermissions, addGuestPermissions);
	}

	public void addClipTypeResources(String articleId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ClipType article = clipTypePersistence.findByPrimaryKey(articleId);

		addClipTypeResources(article, communityPermissions, guestPermissions);
	}

	public void addClipTypeResources(ClipType article,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(
				article.getCompanyId(), 0, getUserId(),
				ClipType.class.getName(),
				article.getPrimaryKey().toString(), communityPermissions,
				guestPermissions);
	}
	
}