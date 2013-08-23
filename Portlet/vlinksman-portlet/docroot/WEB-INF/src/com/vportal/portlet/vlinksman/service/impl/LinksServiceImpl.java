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

package com.vportal.portlet.vlinksman.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import org.apache.commons.validator.UrlValidator;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.vlinksman.InvalidNameLinkException;
import com.vportal.portlet.vlinksman.InvalidUrlLinkException;
import com.vportal.portlet.vlinksman.model.Links;
import com.vportal.portlet.vlinksman.service.base.LinksServiceBaseImpl;
import com.vportal.portlet.vlinksman.service.permission.LinksPermission;
import com.vportal.portlet.vlinksman.service.persistence.LinksUtil;
import com.vportal.portlet.vlinksman.util.ActionKeysExt;
import com.vportal.portlet.vlinksman.util.PortletKeysExt;

/**
 * The implementation of the links remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vlinksman.service.LinksService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vlinksman.service.LinksServiceUtil} to access the
 * links remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author hai
 * @see com.vportal.portlet.vlinksman.service.base.LinksServiceBaseImpl
 * @see com.vportal.portlet.vlinksman.service.LinksServiceUtil
 */
public class LinksServiceImpl extends LinksServiceBaseImpl {
	public Links addLinks(long groupId, long companyId, long plid,
			long linkgroupId, String name, String description, String url,
			long position, long userId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VLINKSMAN, ActionKeysExt.ADD_LINK);

		return addLinks(groupId, companyId, plid, linkgroupId, name,
				description, url, position, userId, null, null,
				communityPermissions, guestPermissions);
	}

	public Links addLinks(long groupId, long companyId, long plid,
			long linkgroupId, String name, String description, String url,
			long position, long userId, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		// _validate(name, url);

		long linkId = CounterLocalServiceUtil.increment(Links.class.getName());

		Links link = LinksUtil.create(linkId);
		link.setCompanyId(companyId);
		link.setGroupId(groupId);

		link.setLinkgroupId(linkgroupId);
		link.setName(name);
		link.setDescription(description);
		link.setUrl(url);
		link.setCreatedDate(new Date());
		link.setPosition(1);

		LinksUtil.update(link, false);

		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {
			addLinksResources(link, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());

		} else {

			addLinksResources(link, communityPermissions, guestPermissions);
		}

		return link;
	}
	
	// new add links fix
	public Links addLinks(long groupId, long companyId, long plid,
			long linkgroupId, String name, String description, String url,
			int position, long userId,Boolean hasImage,Boolean isTargetBlank,String imageName, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VLINKSMAN, ActionKeysExt.ADD_LINK);
		
		return addLinks(groupId, companyId, plid, linkgroupId, name, description, url, position, userId, hasImage, isTargetBlank, imageName,null,null, communityPermissions, guestPermissions);
		 
	}
	
	
	public Links addLinks(long groupId, long companyId, long plid,
			long linkgroupId, String name, String description, String url,
			int position, long userId,Boolean hasImage,Boolean isTargetBlank,String imageName, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		// _validate(name, url);

		long linkId = CounterLocalServiceUtil.increment(Links.class.getName());

		Links link = LinksUtil.create(linkId);
		link.setCompanyId(companyId);
		link.setGroupId(groupId);

		link.setLinkgroupId(linkgroupId);
		link.setName(name);
		link.setDescription(description);
		link.setUrl(url);
		link.setCreatedDate(new Date());
		link.setPosition(1);
		link.setHasImage(hasImage);
		link.setIsTargetBlank(isTargetBlank);
		link.setImageName(imageName);

		LinksUtil.update(link, false);

		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {
			addLinksResources(link, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());

		} else {

			addLinksResources(link, communityPermissions, guestPermissions);
		}

		return link;
	}
	
	// new add links fix 2
		public Links addLinks(long groupId, long companyId, long plid,
				long linkgroupId, String name, String description, String url,
				int position, long userId,Boolean hasImage,Boolean isTargetBlank,String imageName,long folderId, String[] communityPermissions,
				String[] guestPermissions) throws PortalException, SystemException,
				RemoteException {

			PortletPermissionUtil.check(getPermissionChecker(), plid,
					PortletKeysExt.VLINKSMAN, ActionKeysExt.ADD_LINK);
			
			return addLinks(groupId, companyId, plid, linkgroupId, name, description, url, position, userId, hasImage, isTargetBlank, imageName,folderId,null,null, communityPermissions, guestPermissions);
			 
		}
		
		
		public Links addLinks(long groupId, long companyId, long plid,
				long linkgroupId, String name, String description, String url,
				int position, long userId,Boolean hasImage,Boolean isTargetBlank,String imageName,long folderId, Boolean addCommunityPermissions,
				Boolean addGuestPermissions, String[] communityPermissions,
				String[] guestPermissions) throws PortalException, SystemException,
				RemoteException {

			// _validate(name, url);

			long linkId = CounterLocalServiceUtil.increment(Links.class.getName());

			Links link = LinksUtil.create(linkId);
			link.setCompanyId(companyId);
			link.setGroupId(groupId);

			link.setLinkgroupId(linkgroupId);
			link.setName(name);
			link.setDescription(description);
			link.setUrl(url);
			link.setCreatedDate(new Date());
			link.setPosition(1);
			link.setHasImage(hasImage);
			link.setIsTargetBlank(isTargetBlank);
			link.setImageName(imageName);
			link.setFolderId(folderId);

			LinksUtil.update(link, false);

			if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {
				addLinksResources(link, addCommunityPermissions.booleanValue(),
						addGuestPermissions.booleanValue());

			} else {

				addLinksResources(link, communityPermissions, guestPermissions);
			}

			return link;
		}
		
	
	
	// new function addLinks
	public Links addLinks(Links link,long plid,Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws SystemException, PrincipalException, PortalException{
		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VLINKSMAN, ActionKeysExt.ADD_LINK);
		long linkId = CounterLocalServiceUtil.increment(Links.class.getName());
		link = LinksUtil.create(linkId);		
		LinksUtil.update(link, false);
		
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {
			addLinksResources(link, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());

		} else {

			addLinksResources(link, communityPermissions, guestPermissions);
		}
		
		return link;
	}
	
	// new function updateLinks
	public Links updateLinks(Links link) throws SystemException, PrincipalException, PortalException, RemoteException{
		LinksPermission.check(getPermissionChecker(), link.getLinkId(),
				ActionKeysExt.UPDATE);
		LinksUtil.update(link, false);
		return link;
	}

	public Links updateLinks(long linkId, long groupId, long companyId,
			long linkgroupId, String name, String description, String url,
			long position) throws PortalException, SystemException,
			RemoteException {

		LinksPermission.check(getPermissionChecker(), linkId,
				ActionKeysExt.UPDATE);

		// _validate(name, url);

		Links link = LinksUtil.findByPrimaryKey(linkId);

		link.setCompanyId(companyId);
		link.setGroupId(groupId);

		link.setLinkgroupId(linkgroupId);
		link.setName(name);
		link.setDescription(description);
		link.setUrl(url);
		link.setModifiedDate(new Date());
		link.setPosition(position);
		
		LinksUtil.update(link, false);
		return link;
	}
	
	public Links updateLink(Links link) throws PortalException,
	SystemException, RemoteException {
		return updateLinks(link.getLinkId(), link.getGroupId(),
		link.getCompanyId(), link.getLinkgroupId(), link.getName(),
		link.getDescription(), link.getUrl(), link.getPosition());
}
	
	//new update link fix
	
	public Links updateLinks(long linkId, long groupId, long companyId,
			long linkgroupId, String name, String description, String url,
			long position,Boolean hasImage,Boolean isTargetBlank,String imageName) throws PortalException, SystemException,
			RemoteException {

		LinksPermission.check(getPermissionChecker(), linkId,
				ActionKeysExt.UPDATE);
		
		Links link = LinksUtil.findByPrimaryKey(linkId);

		link.setCompanyId(companyId);
		link.setGroupId(groupId);

		link.setLinkgroupId(linkgroupId);
		link.setName(name);
		link.setDescription(description);
		link.setUrl(url);
		link.setModifiedDate(new Date());
		link.setPosition(position);
		link.setHasImage(hasImage);
		link.setIsTargetBlank(isTargetBlank);
		link.setImageName(imageName);		
		
		LinksUtil.update(link, false);
		return link;
	}
		
		
		//new update link fix 2
		
		public Links updateLinks(long linkId, long groupId, long companyId,
				long linkgroupId, String name, String description, String url,
				long position,Boolean hasImage,Boolean isTargetBlank,String imageName,long folderId) throws PortalException, SystemException,
				RemoteException {

			LinksPermission.check(getPermissionChecker(), linkId,
					ActionKeysExt.UPDATE);

		// _validate(name, url);

		Links link = LinksUtil.findByPrimaryKey(linkId);

		link.setCompanyId(companyId);
		link.setGroupId(groupId);

		link.setLinkgroupId(linkgroupId);
		link.setName(name);
		link.setDescription(description);
		link.setUrl(url);
		link.setModifiedDate(new Date());
		link.setPosition(position);
		link.setHasImage(hasImage);
		link.setIsTargetBlank(isTargetBlank);
		link.setImageName(imageName);
		link.setFolderId(folderId);
		
		LinksUtil.update(link, false);
		return link;
	}

	public Links updateLink2(Links link) throws PortalException,
			SystemException, RemoteException {
		return updateLinks(link.getLinkId(), link.getGroupId(),
				link.getCompanyId(), link.getLinkgroupId(), link.getName(),
				link.getDescription(), link.getUrl(), link.getPosition(),link.getHasImage(),link.getIsTargetBlank(),link.getImageName());
	}
	
	public Links updateLink3(Links link) throws PortalException,
	SystemException, RemoteException {
return updateLinks(link.getLinkId(), link.getGroupId(),
		link.getCompanyId(), link.getLinkgroupId(), link.getName(),
		link.getDescription(), link.getUrl(), link.getPosition(),link.getHasImage(),link.getIsTargetBlank(),link.getImageName(),link.getFolderId());
}

	public void deleteLink(long linkId) throws PortalException,
			SystemException, RemoteException {
		linksPersistence.remove(linkId);
//		LinksPermission.check(getPermissionChecker(), linkId,
//				ActionKeysExt.DELETE);
//		Links link = LinksUtil.findByPrimaryKey(linkId);
//
//		ResourceLocalServiceUtil.deleteResource(link.getCompanyId(),
//				Links.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
//				link.getLinkId());
//
//		LinksUtil.remove(linkId);
	}

	public List getAll() throws PortalException, SystemException,
			RemoteException {
		return LinksUtil.findAll();
	}

	public List getByLinkGroupId(long linkGroupId) throws PortalException,
			SystemException, RemoteException {
		return LinksUtil.findBylinkgroupId(linkGroupId);
	}

	public List getByGroupId(long groupId) throws PortalException,
			SystemException, RemoteException {
		return linksPersistence.findByGroupId(groupId);
	}

	public List getByGroupId(long groupId, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return linksPersistence.findByGroupId(groupId, start, end);
	}

	public int countByGroupId(long groupId) throws PortalException,
			SystemException, RemoteException {
		return linksPersistence.countByGroupId(groupId);
	}

	public List getByLinkG_GL(long groupId, long linkGroupId)
			throws PortalException, SystemException, RemoteException {

		return linksPersistence.findByG_LG(groupId, linkGroupId);
	}

	public List getByLinkG_GL(long groupId, long linkGroupId, int start, int end)
			throws PortalException, SystemException, RemoteException {
		return linksPersistence.findByG_LG(groupId, linkGroupId, start, end);
	}

	public Links getLinks(long linkId) throws PortalException, SystemException,
			RemoteException {
		return LinksUtil.findByPrimaryKey(linkId);
	}

	// add Resource
	public void addLinksResources(long linkId, boolean addCommunityPermissions,
			boolean addGuestPermissions) throws PortalException,
			SystemException {

		Links link = LinksUtil.findByPrimaryKey(linkId);
		addLinksResources(link, addCommunityPermissions, addGuestPermissions);
	}

	public void addLinksResources(Links link, boolean addCommunityPermissions,
			boolean addGuestPermissions) throws PortalException,
			SystemException {

		ResourceLocalServiceUtil.addResources(PortalUtil.getDefaultCompanyId(),
				0, getUserId(), Links.class.getName(), link.getPrimaryKey(),
				false, addCommunityPermissions, addGuestPermissions);

	}

	public void addLinksResources(long linkId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		Links link = LinksUtil.findByPrimaryKey(linkId);
		addLinksResources(link, communityPermissions, guestPermissions);
	}

	public void addLinksResources(Links link, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(
				PortalUtil.getDefaultCompanyId(), 0, getUserId(),
				Links.class.getName(), link.getPrimaryKey(),
				communityPermissions, guestPermissions);
	}

	public void _validate(String name, String url) throws SystemException,
			PortalException, RemoteException {

		String[] schemes = { "http", "https", "ftp" };
		UrlValidator urlValidator = new UrlValidator(schemes);

		if (Validator.isNull(name)) {
			throw new InvalidNameLinkException();
		}
		if (Validator.isNull(url)) {
			throw new InvalidUrlLinkException();
		}
	}
}