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
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.vportal.portlet.vcms.DeleteTypeArticleException;
import com.vportal.portlet.vcms.DuplicateTypeCodeException;
import com.vportal.portlet.vcms.InvalidTypeCodeException;
import com.vportal.portlet.vcms.InvalidTypeNameException;
import com.vportal.portlet.vcms.NoSuchVcmsTypeException;
import com.vportal.portlet.vcms.model.VcmsType;
import com.vportal.portlet.vcms.service.VcmsArticleTypeLocalServiceUtil;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.base.VcmsTypeServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsTypeUtil;

/**
 * The implementation of the vcms type remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsTypeService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsTypeServiceUtil} to access the
 * vcms type remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsTypeServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsTypeServiceUtil
 */
public class VcmsTypeServiceImpl extends VcmsTypeServiceBaseImpl {
	public VcmsType addType(long groupId, long companyId, long plid,
			String code, String name, String description, String language,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		return addType(groupId, companyId, plid, code, name, description,
				language, null, null, communityPermissions, guestPermissions);
	}

	public VcmsType addType(long groupId, long companyId, long plid,
			String code, String name, String description, String language,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		// PortletPermissionUtil.check(
		// getPermissionChecker(), plid, PortletKeysExt.VCMS,
		// ActionKeysExt.ADD_Type);

		VcmsType type = null;

		_validate(groupId, null, code, name, true);

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		String typeId = Long.toString(CounterLocalServiceUtil
				.increment(VcmsType.class.getName()));

		type = VcmsTypeUtil.create(typeId);

		type.setGroupId(groupId);
		type.setCompanyId(companyId);

		type.setCode(code);
		type.setName(name);
		type.setDescription(description);

		type.setLanguage(language);

		type.setCreatedDate(now);
		type.setCreatedByUser(userId);

		type.setModifiedDate(now);
		type.setModifiedByUser(userId);

		VcmsTypeUtil.update(type, false);

		// Add to common resources //tempcancel
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addTypeResources(type, addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addTypeResources(type, communityPermissions, guestPermissions);
		}

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - CREATE: vcms Type [" + name + "] by " + userId);

		return type;
	}

	public void addTypeResources(String TypeId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException, RemoteException {

		VcmsType Type = (VcmsType) getType(TypeId);

		addTypeResources(Type, addCommunityPermissions, addGuestPermissions);
	}

	public void addTypeResources(VcmsType Type,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(Type.getCompanyId(),
				Type.getGroupId(), Long.parseLong(Type.getCreatedByUser()),
				VcmsType.class.getName(), Type.getTypeId(), false,
				addCommunityPermissions, addGuestPermissions);
	}

	public void addTypeResources(String TypeId, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException,
			RemoteException {

		VcmsType Type = (VcmsType) getType(TypeId);

		addTypeResources(Type, communityPermissions, guestPermissions);
	}

	public void addTypeResources(VcmsType Type, String[] communityPermissions,
			String[] guestPermissions) throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(Type.getCompanyId(),
				Type.getGroupId(), Long.parseLong(Type.getCreatedByUser()),
				VcmsType.class.getName(), Type.getTypeId(),
				communityPermissions, guestPermissions);
	}

	public VcmsType updateType(String typeId, long groupId, long companyId,
			String code, String name, String description, String language)
			throws PortalException, SystemException, RemoteException {

		VcmsType type = null;

		_validate(groupId, typeId, code, name, false);

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		type = VcmsTypeUtil.findByPrimaryKey(typeId);

		type.setGroupId(groupId);
		type.setCompanyId(companyId);

		type.setCode(code);
		type.setName(name);
		type.setDescription(description);

		type.setLanguage(language);

		type.setModifiedDate(now);
		type.setModifiedByUser(userId);

		VcmsTypeUtil.update(type, false);

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - UPDATE: vcms Type [" + name + "] by " + userId);

		return type;
	}

	public void deleteType(String typeId) throws PortalException,
			SystemException, RemoteException {

		VcmsType type = VcmsTypeUtil.findByPrimaryKey(typeId);

		List listArticles = new ArrayList();

		listArticles = (List) VcmsArticleTypeLocalServiceUtil.getByTypeId(Long
				.parseLong(typeId));

		if (Validator.isNotNull(listArticles) && listArticles.size() > 0) {
			throw new DeleteTypeArticleException();
		}

		// Type can only be deleted when it has no children

		// Remove resources//temp cancel
		// ResourceLocalServiceUtil.deleteResource(type.getCompanyId(),
		// VcmsType.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, type
		// .getTypeId());

		// Remove Type
		// ham cu
		// VcmsTypeUtil.remove(type);

		// ham moi
		VcmsTypeUtil.remove(type.getTypeId());

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(new Date())
				+ " - DELETE: vcms Type [" + type.getName() + "] by "
				+ getUserId());
	}

	public void deleteTypes(String[] typeIds) throws PortalException,
			SystemException, RemoteException {

		if ((typeIds == null) || (typeIds.length <= 0)) {
			return;
		}

		for (int i = 0; i < typeIds.length; i++) {
			deleteType(typeIds[i]);
		}
	}

	public VcmsType getType(String typeId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(typeId)) {
			throw new NoSuchVcmsTypeException();
		}

		return VcmsTypeUtil.findByPrimaryKey(typeId);
	}

	public VcmsType getTypeByS_C(long groupId, String code)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(groupId) || Validator.isNull(code)) {
			throw new NoSuchVcmsTypeException();
		}

		return VcmsTypeUtil.findByS_C(groupId, code);
	}

	public List<VcmsType> getTypesByS_L(long groupId, String language)
			throws PortalException, SystemException, RemoteException {

		return vcmsTypePersistence.findByS_L(groupId, language);
	}

	public List<VcmsType> getTypesByS_L(long groupId, String language,
			int start, int end) throws PortalException, SystemException,
			RemoteException {

		return vcmsTypePersistence.findByS_L(groupId, language, start, end);
	}

	public int countTypesByS_L(long groupId, String language)
			throws PortalException, SystemException, RemoteException {

		return vcmsTypePersistence.countByS_L(groupId, language);
	}

	// Common Resources Utilities ...

	private void _validate(long groupId, String typeId, String code,
			String name, boolean isNew) throws PortalException, SystemException {

		if (Validator.isNull(code)) {
			throw new InvalidTypeCodeException();
		}

		if (Validator.isNull(name)) {
			throw new InvalidTypeNameException();
		}

		VcmsType type = null;

		if (Validator.isNotNull(code)) {
			try {
				type = VcmsTypeUtil.findByS_C(groupId, code);
			} catch (Exception ex) {
				// Ignore..
			}
		}

		if (isNew) {
			if ((type != null) && type.getCode().equals(code)) {
				throw new DuplicateTypeCodeException();
			}
		} else {
			if ((type != null) && type.getCode().equals(code)
					&& !type.getTypeId().equals(typeId)) {
				throw new DuplicateTypeCodeException();
			}
		}
	}
}