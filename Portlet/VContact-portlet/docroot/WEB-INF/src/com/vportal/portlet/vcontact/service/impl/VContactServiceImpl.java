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

package com.vportal.portlet.vcontact.service.impl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Contact;
import com.vportal.portlet.vcontact.model.VContact;
import com.vportal.portlet.vcontact.service.base.VContactServiceBaseImpl;
import com.vportal.portlet.vcontact.service.persistence.VContactUtil;

/**
 * The implementation of the v contact remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.vportal.portlet.vcontact.service.VContactService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see com.vportal.portlet.vcontact.service.base.VContactServiceBaseImpl
 * @see com.vportal.portlet.vcontact.service.VContactServiceUtil
 */
public class VContactServiceImpl extends VContactServiceBaseImpl {
	
	public static final int RECEIVED_PENDING = 0;

	public static final int RECEIVED = 1;

	public static final int DECLINE = 2;

	public VContact addContact(long groupId, long companyId, long plid,
			String guestName, String email, String title, String address,
			String phone, String fax, String content, boolean hasAttach,
			int status, long userId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		return addContact(groupId, companyId, plid, guestName, email, title,
				address, phone, fax, content, hasAttach, status, userId, null,
				null, communityPermissions, guestPermissions);

	}

	public VContact addContact(long groupId, long companyId, long plid,
			String guestName, String email, String title, String address,
			String phone, String fax, String content, boolean hasAttach,
			int status, long userId, Boolean addCommunityPermissions,
			Boolean addGuestPermissions, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		long Id = CounterLocalServiceUtil.increment(Contact.class.getName());

		VContact contact = VContactUtil.create(Id);

		contact.setGroupId(groupId);
		contact.setCompanyId(companyId);

		contact.setCreatedDate(new Date());
		contact.setGuestName(guestName);
		contact.setEmail(email);
		contact.setTitle(title);
		contact.setAddress(address);
		contact.setPhone(phone);
		contact.setFax(fax);
		contact.setContent(content);
		contact.setHasAttach(hasAttach);
		contact.setStatus(VContactServiceImpl.RECEIVED_PENDING);

		VContactUtil.update(contact,false);
		return contact;
	}

	public VContact updateContact(long Id, long groupId, long companyId,
			String guestName, String email, String title, String address,
			String phone, String fax, String content, boolean hasAttach,
			int status) throws PortalException, SystemException,
			RemoteException {

		VContact contact = VContactUtil.findByPrimaryKey(Id);

		contact.setGroupId(groupId);
		contact.setCompanyId(companyId);

		contact.setModifiedDate(new Date());
		contact.setGuestName(guestName);
		contact.setEmail(email);
		contact.setTitle(title);
		contact.setAddress(address);
		contact.setPhone(phone);
		contact.setFax(fax);
		contact.setContent(content);
		contact.setHasAttach(hasAttach);
		contact.setStatus(status);

		VContactUtil.update(contact,false);
		return contact;
	}

	public VContact updateContact(VContact contact) throws PortalException,
			SystemException, RemoteException {
		return updateContact(contact.getId(), contact.getGroupId(), contact
				.getCompanyId(), contact.getGuestName(), contact.getEmail(),
				contact.getTitle(), contact.getAddress(), contact.getPhone(),
				contact.getFax(), contact.getContent(), contact.getHasAttach(),
				contact.getStatus());

	}

	public void deleteContact(long Id) throws PortalException, SystemException,
			RemoteException {

		VContact contact = VContactUtil.findByPrimaryKey(Id);
		vContactPersistence.remove(contact);
	}

	public List<VContact> getAll() throws PortalException, SystemException,
			RemoteException {
		return VContactUtil.findAll();
	}

	public List<VContact> getByStatus(int status) throws PortalException,
			SystemException, RemoteException {

		return vContactPersistence.findByStatus(status);
	}

	public List<VContact> getByG_S(long groupId, int status) throws PortalException,
			SystemException, RemoteException {

		return vContactPersistence.findByG_S(groupId, status);
	}

	public List<VContact> getByG_S(long groupId, int status, int start, int end)
			throws PortalException, SystemException, RemoteException {

		return vContactPersistence.findByG_S(groupId, status, start, end);
	}

	public VContact getContact(long Id) throws PortalException,
			SystemException, RemoteException {

		return VContactUtil.findByPrimaryKey(Id);
	}
}