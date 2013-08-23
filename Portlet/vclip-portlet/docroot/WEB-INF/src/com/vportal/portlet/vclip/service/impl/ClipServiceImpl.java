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

import com.vportal.portlet.vclip.service.base.ClipServiceBaseImpl;
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
import com.vportal.portlet.vclip.model.impl.ClipImpl;
import com.vportal.portlet.vclip.service.base.ClipServiceBaseImpl;
import com.vportal.portlet.vclip.util.ActionKeysClipExt;
import com.vportal.portlet.vclip.util.WebKeysVClip;

/**
 * The implementation of the clip remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vclip.service.ClipService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.vportal.portlet.vclip.service.ClipServiceUtil} to access the clip remote service.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.vportal.portlet.vclip.service.base.ClipServiceBaseImpl
 * @see com.vportal.portlet.vclip.service.ClipServiceUtil
 */
public class ClipServiceImpl extends ClipServiceBaseImpl {
	public Clip addClip(long groupId, long companyId, long plid, Clip clip,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions)
			throws Exception {
		String id = Long.toString(CounterLocalServiceUtil.increment(Clip.class
				.getName()));
//		PortletPermissionUtil.check(getPermissionChecker(), plid,
//				WebKeysVClip.Clip_type_id, ActionKeysClipExt.ADD_CLIP);
		Clip c = clipPersistence.create(id);

		c.setClipTypeId(clip.getClipTypeId());

		c.setCreatedDate(clip.getCreatedDate());
		c.setModifiedDate(clip.getModifiedDate());
		c.setLanguage(clip.getLanguage());
		c.setUrl(clip.getUrl());
		c.setName(clip.getName());
		c.setTitle(clip.getTitle());
		c.setImage(clip.getImage());
		c.setTitle(clip.getTitle());
		c.setImage(clip.getImage());
		c.setGroupId(clip.getGroupId());
		c.setUserId(clip.getUserId());
		c.setCompanyId(clip.getCompanyId());
		c.setDescription(clip.getDescription());
		c.setActive(true);
		c = clipPersistence.update(c, false);

		// add permission
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addClipResources(c, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addClipResources(c, communityPermissions, guestPermissions);
		}

		return c;
	}

	public Clip updateClip(long groupId, long companyId, String clipId,
			Clip clip) throws Exception {
		PortletPermissionUtil.check(getPermissionChecker(), WebKeysVClip.Clip_type_id,
				ActionKeysClipExt.UPDATE);
		Clip c = clipPersistence.findByPrimaryKey(clip.getId());
		c.setModifiedDate(clip.getModifiedDate());
		c.setLanguage(clip.getLanguage());
		c.setClipTypeId(clip.getClipTypeId());
		c.setUrl(clip.getUrl());
		c.setName(clip.getName());
		c.setTitle(clip.getTitle());
		if ((clip.getImage() != null) && (!clip.getImage().trim().equals(""))) {
			c.setImage(clip.getImage());
		}
		c.setTitle(clip.getTitle());
		if ((clip.getImage() != null) && (!clip.getImage().trim().equals(""))) {
			c.setImage(clip.getImage());
		}
		c.setDescription(clip.getDescription());

		c = clipPersistence.update(c, false);

		return c;
	}

	public void deleteClip(Clip clip) throws Exception {

		ResourceLocalServiceUtil.deleteResource(clip.getCompanyId(), Clip.class
				.getName(), ResourceConstants.SCOPE_INDIVIDUAL, clip.getId());
		deleteClip(clip.getId());

	}

	public void deleteClip(String clipId) throws Exception {

		Clip c = null;
		try {
			c = clipPersistence.findByPrimaryKey(clipId);
		} catch (Exception ex) {
			throw new NoSuchArticleException();
		}
		ResourceLocalServiceUtil.deleteResource(c.getCompanyId(), Clip.class
				.getName(), ResourceConstants.SCOPE_INDIVIDUAL, c.getId());

		clipPersistence.remove(clipId);
	}

	// hit counter download clip
	public Clip increaseHitCount(String clipId) throws PortalException,
			SystemException {
		Clip vclip = clipPersistence.findByPrimaryKey(clipId);
		long hitCount = vclip.getHitcount();
		++hitCount;
		vclip.setHitcount(hitCount);
		clipPersistence.update(vclip, false);
		return vclip;
	}

	// hit counter view clip
	public Clip increaseHitCountView(String clipId) throws PortalException,
			SystemException {
		Clip vclip = clipPersistence.findByPrimaryKey(clipId);
		long hitCountview = vclip.getHitcountview();
		++hitCountview;
		vclip.setHitcountview(hitCountview);
		clipPersistence.update(vclip, false);
		return vclip;
	}

	public Clip findById(String clipId) throws Exception {

		return clipPersistence.findByPrimaryKey(clipId);
	}

	public List<Clip> findByClipTypeId(String clipTypeId) throws Exception {
		return clipPersistence.findByClipTypeId(clipTypeId);
	}

	public List<Clip> findByClipTypeId(String clipTypeId, int start, int end)
			throws Exception {
		return clipPersistence.findByClipTypeId(clipTypeId, start, end);
	}

	public int countByClipTypeId(String clipTypeId) throws Exception {
		return clipPersistence.countByClipTypeId(clipTypeId);
	}

	public List<Clip> findClip(Clip clip) throws Exception {
		return clipFinder.findClip(clip);
	}

	public List<Clip> findClip(Clip clip, int start, int end) throws Exception {
		return clipFinder.findClip(clip, start, end);
	}

	public int countClip(Clip clip) throws Exception {
		return clipFinder.countClip(clip);
	}
	public List<Clip> searchClip(String textSearch, String clipTypeId) throws Exception {
		return clipFinder.searchClip(textSearch, clipTypeId);		
	}
	public List<Clip> getAll() throws Exception {
		return clipPersistence.findAll();
	}

	// get specified quantity clip
	public List<Clip> getAll(int begin, int end) throws Exception {

		return clipPersistence.findAll(begin, end);
	}

	public int countAll() throws Exception {
		return clipPersistence.countAll();
	}

	public boolean hasParent(String clipTypeId) throws Exception {
		List<Clip> clipList = clipPersistence.findByClipTypeId(clipTypeId);
		if ((clipList != null) && (clipList.size() > 0)) {
			return true;
		}
		return false;
	}

	public Clip getFirst() throws Exception {
		List<Clip> myList = clipPersistence.findAll(0, 1);
		Clip clip = null;
		if (myList.size() > 0) {
			clip = (Clip) myList.get(0);
		}
		return clip;
	}

	public Clip getByClipTypeId(String clipTypeId) throws Exception {
		List<Clip> firstClipList = clipPersistence.findByClipTypeId(clipTypeId, 0, 1);
		if ((firstClipList != null) && (firstClipList.size() > 0)) {
			return (Clip) firstClipList.get(0);
		}
		return (new ClipImpl());

	}

	// add permission
	public void addClipResources(String articleId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		Clip article = clipPersistence.findByPrimaryKey(articleId);

		addClipResources(article, addCommunityPermissions, addGuestPermissions);
	}

	public void addClipResources(Clip article, boolean addCommunityPermissions,
			boolean addGuestPermissions) throws PortalException,
			SystemException {

		ResourceLocalServiceUtil.addResources(article.getCompanyId(),
				0, getUserId(), Clip.class.getName(), article.getPrimaryKey()
						.toString(), false, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addClipResources(String articleId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		Clip article = clipPersistence.findByPrimaryKey(articleId);

		addClipResources(article, communityPermissions, guestPermissions);
	}

	public void addClipResources(Clip article, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(
				article.getCompanyId(), 0, getUserId(), Clip.class
						.getName(), article.getPrimaryKey().toString(),
				communityPermissions, guestPermissions);
	}

}