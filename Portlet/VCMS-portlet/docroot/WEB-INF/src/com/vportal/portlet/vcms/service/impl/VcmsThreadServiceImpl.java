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

package com.vportal.portlet.vcms.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.vportal.portal.kernel.security.permission.ActionKeysExt;
import com.vportal.portal.util.PortletKeysExt;
import com.vportal.portlet.vcms.InvalidThreadTitleException;
import com.vportal.portlet.vcms.NoSuchVcmsThreadException;
import com.vportal.portlet.vcms.model.VcmsThread;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.base.VcmsThreadServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsThreadUtil;

/**
 * The implementation of the vcms thread remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsThreadService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsThreadServiceUtil} to access the
 * vcms thread remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsThreadServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsThreadServiceUtil
 */
public class VcmsThreadServiceImpl extends VcmsThreadServiceBaseImpl {
	public VcmsThread addThread(long groupId, long companyId, long plid,
			String title, String description, boolean hasImage, String image,
			String language, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		return addThread(groupId, companyId, plid, title, description,
				hasImage, image, language, null, null, communityPermissions,
				guestPermissions);
	}

	public VcmsThread addThread(long groupId, long companyId, long plid,
			String title, String description, boolean hasImage, String image,
			String language, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VCMS, ActionKeysExt.ADD_THREAD);

		_validate(title);

		String threadId = Long.toString(CounterLocalServiceUtil
				.increment(VcmsThread.class.getName()));

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		VcmsThread thread = VcmsThreadUtil.create(threadId);

		thread.setGroupId(groupId);
		thread.setCompanyId(companyId);

		thread.setTitle(title);
		thread.setDescription(description);
		thread.setHasImage(hasImage);
		thread.setImage(image);
		thread.setLanguage(language);

		thread.setCreatedDate(now);
		thread.setCreatedByUser(userId);

		thread.setModifiedDate(now);
		thread.setModifiedByUser(userId);

		vcmsThreadPersistence.update(thread, false);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addThreadResources(thread, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addThreadResources(thread, communityPermissions, guestPermissions);
		}

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - CREATE: vcms thread [" + title + "] by " + userId);

		return thread;
	}

	// Common Resources Utilities ...

	public void addThreadResources(String threadId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		VcmsThread thread = VcmsThreadUtil.findByPrimaryKey(threadId);

		addThreadResources(thread, addCommunityPermissions, addGuestPermissions);
	}

	public void addThreadResources(VcmsThread thread,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(thread.getCompanyId(), 0,
				getUserId(), VcmsThread.class.getName(), thread.getPrimaryKey()
						.toString(), false, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addThreadResources(String threadId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		VcmsThread thread = VcmsThreadUtil.findByPrimaryKey(threadId);

		addThreadResources(thread, communityPermissions, guestPermissions);
	}

	public void addThreadResources(VcmsThread thread,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(thread.getCompanyId(), 0,
				getUserId(), VcmsThread.class.getName(), thread.getPrimaryKey()
						.toString(), communityPermissions, guestPermissions);
	}

	public VcmsThread updateThread(String threadId, long groupId,
			long companyId, String title, String description, boolean hasImage,
			String image, String language) throws PortalException,
			SystemException, RemoteException {

		_validate(title);

		VcmsThread thread = VcmsThreadUtil.findByPrimaryKey(threadId);

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		thread.setGroupId(groupId);
		thread.setCompanyId(companyId);

		thread.setTitle(title);
		thread.setDescription(description);
		thread.setHasImage(hasImage);
		thread.setImage(image);
		thread.setLanguage(language);

		thread.setModifiedDate(now);
		thread.setModifiedByUser(userId);

		vcmsThreadPersistence.update(thread, false);

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - UPDATE: vcms thread [" + title + "] by " + userId);

		return thread;
	}

	public VcmsThread updateThread(VcmsThread thread) throws PortalException,
			SystemException, RemoteException {

		return updateThread(thread.getThreadId(), thread.getGroupId(),
				thread.getCompanyId(), thread.getTitle(),
				thread.getDescription(), thread.getHasImage(),
				thread.getImage(), thread.getLanguage());
	}

	public void deleteThread(String threadId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(threadId)) {
			throw new NoSuchVcmsThreadException();
		}

		VcmsThread thread = vcmsThreadPersistence.findByPrimaryKey(threadId);

		// Remove resource
		ResourceLocalServiceUtil.deleteResource(thread.getCompanyId(),
				VcmsThread.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				thread.getThreadId());

		// 1. Remove all relations to articles

		vcmsTARelationPersistence.removeByThread(threadId);

		// 2. Remove the thread itself

		vcmsThreadPersistence.remove(threadId);

		// 3. Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(new Date())
				+ " - DELETE: vcms thread [" + thread.getTitle() + "] by "
				+ getUserId());
	}

	public VcmsThread getThread(String threadId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(threadId)) {
			throw new NoSuchVcmsThreadException();
		}

		return vcmsThreadPersistence.findByPrimaryKey(threadId);
	}

	public List<VcmsThread> getThreads(String[] threadIds)
			throws PortalException, SystemException, RemoteException {

		List threads = new ArrayList();

		if ((threadIds == null) || (threadIds.length <= 0)) {
			return threads;
		}

		for (int i = 0; i < threadIds.length; i++) {
			threads.add(getThread(threadIds[i]));
		}

		return threads;
	}

	public List<VcmsThread> getThreadsByP_L(long groupId, String language)
			throws PortalException, SystemException, RemoteException {

		return vcmsThreadPersistence.findByP_L(groupId, language);
	}

	public List<VcmsThread> getThreadsByP_L(long groupId, String language,
			int begin, int end) throws PortalException, SystemException,
			RemoteException {

		return vcmsThreadPersistence.findByP_L(groupId, language, begin, end);
	}

	public int countThreadsByP_L(long groupId, String language)
			throws PortalException, SystemException, RemoteException {

		return vcmsThreadPersistence.countByP_L(groupId, language);
	}

	private void _validate(String title) throws PortalException,
			SystemException {

		if (Validator.isNull(title)) {
			throw new InvalidThreadTitleException();
		}

	}
}