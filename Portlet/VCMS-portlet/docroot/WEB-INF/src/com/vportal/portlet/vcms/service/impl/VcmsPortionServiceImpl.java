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
import com.vportal.portlet.vcms.DeletePortionException;
import com.vportal.portlet.vcms.DuplicatePortionCodeException;
import com.vportal.portlet.vcms.InvalidPortionCodeException;
import com.vportal.portlet.vcms.InvalidPortionNameException;
import com.vportal.portlet.vcms.NoSuchVcmsPortionException;
import com.vportal.portlet.vcms.model.VcmsPortion;
import com.vportal.portlet.vcms.service.VcmsCategoryServiceUtil;
import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;
import com.vportal.portlet.vcms.service.VcmsPARelationServiceUtil;
import com.vportal.portlet.vcms.service.base.VcmsPortionServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsPortionUtil;

/**
 * The implementation of the vcms portion remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsPortionService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsPortionServiceUtil} to access the
 * vcms portion remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsPortionServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsPortionServiceUtil
 */
public class VcmsPortionServiceImpl extends VcmsPortionServiceBaseImpl {
	public VcmsPortion addPortion(long groupId, long companyId, long plid,
			String code, String name, String description,
			boolean categorizable, String language,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		return addPortion(groupId, companyId, plid, code, name, description,
				categorizable, language, null, null, communityPermissions,
				guestPermissions);
	}

	public VcmsPortion addPortion(long groupId, long companyId, long plid,
			String code, String name, String description,
			boolean categorizable, String language,
			Boolean addCommunityPermissions, Boolean addGuestPermissions,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		PortletPermissionUtil.check(getPermissionChecker(), plid,
				PortletKeysExt.VCMS, ActionKeysExt.ADD_PORTION);

		VcmsPortion portion = null;

		_validate(groupId, null, code, name, true);
		Date now = new Date();
		String userId = String.valueOf(getUserId());

		String portionId = Long.toString(CounterLocalServiceUtil
				.increment(VcmsPortion.class.getName()));

		portion = VcmsPortionUtil.create(portionId);

		portion.setGroupId(groupId);
		portion.setCompanyId(companyId);

		portion.setCode(code);
		portion.setName(name);
		portion.setDescription(description);
		portion.setCategorizable(categorizable);
		portion.setLanguage(language);

		portion.setCreatedDate(now);
		portion.setCreatedByUser(userId);

		portion.setModifiedDate(now);
		portion.setModifiedByUser(userId);

		vcmsPortionPersistence.update(portion, false);

		// Add to common resources
		if ((addCommunityPermissions != null) && (addGuestPermissions != null)) {

			addPortionResources(portion,
					addCommunityPermissions.booleanValue(),
					addGuestPermissions.booleanValue());
		} else {
			addPortionResources(portion, communityPermissions, guestPermissions);
		}

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - CREATE: vcms portion [" + name + "] by " + userId);

		return portion;
	}

	public void addPortionResources(String portionId,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException, RemoteException {

		VcmsPortion portion = getPortion(portionId);

		addPortionResources(portion, addCommunityPermissions,
				addGuestPermissions);
	}

	public void addPortionResources(VcmsPortion portion,
			boolean addCommunityPermissions, boolean addGuestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addResources(portion.getCompanyId(),
				portion.getGroupId(),
				Long.parseLong(portion.getCreatedByUser()),
				VcmsPortion.class.getName(), portion.getPortionId(), false,
				addCommunityPermissions, addGuestPermissions);
	}

	public void addPortionResources(String portionId,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException, RemoteException {

		VcmsPortion portion = getPortion(portionId);

		addPortionResources(portion, communityPermissions, guestPermissions);
	}

	public void addPortionResources(VcmsPortion portion,
			String[] communityPermissions, String[] guestPermissions)
			throws PortalException, SystemException {

		ResourceLocalServiceUtil.addModelResources(portion.getCompanyId(),
				portion.getGroupId(),
				Long.parseLong(portion.getCreatedByUser()),
				VcmsPortion.class.getName(), portion.getPortionId(),
				communityPermissions, guestPermissions);
	}

	public VcmsPortion updatePortion(String portionId, long groupId,
			long companyId, String code, String name, String description,
			boolean categorizable, String language) throws PortalException,
			SystemException, RemoteException {

		VcmsPortion portion = null;

		_validate(groupId, portionId, code, name, false);

		Date now = new Date();
		String userId = String.valueOf(getUserId());

		portion = vcmsPortionPersistence.findByPrimaryKey(portionId);

		portion.setGroupId(groupId);
		portion.setCompanyId(companyId);

		portion.setCode(code);
		portion.setName(name);
		portion.setDescription(description);
		portion.setCategorizable(categorizable);
		portion.setLanguage(language);

		portion.setModifiedDate(now);
		portion.setModifiedByUser(userId);

		vcmsPortionPersistence.update(portion, false);

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(now)
				+ " - UPDATE: vcms portion [" + name + "] by " + userId);

		return portion;
	}

	public void deletePortion(String portionId) throws PortalException,
			SystemException, RemoteException {

		VcmsPortion portion = vcmsPortionPersistence
				.findByPrimaryKey(portionId);

		// Portion can only be deleted when it has no children

		List categories = VcmsCategoryServiceUtil.getCategoriesByPortion(
				portion.getGroupId(), portionId, portion.getLanguage());

		List paRelations = VcmsPARelationServiceUtil
				.getRelationsByPortion(portionId);

		if (((categories != null) && (categories.size() > 0))
				|| ((paRelations != null) && (paRelations.size() > 0))) {

			throw new DeletePortionException();
		}

		// Remove resources
		ResourceLocalServiceUtil.deleteResource(portion.getCompanyId(),
				VcmsPortion.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, portion.getPortionId());

		// Remove portion
		vcmsPortionPersistence.remove(portion);

		// Logging...

		VcmsLoggerServiceUtil.log(CalendarUtil.getTimestamp(new Date())
				+ " - DELETE: vcms portion [" + portion.getName() + "] by "
				+ getUserId());
	}

	public void deletePortions(String[] portionIds) throws PortalException,
			SystemException, RemoteException {

		if ((portionIds == null) || (portionIds.length <= 0)) {
			return;
		}

		for (int i = 0; i < portionIds.length; i++) {
			deletePortion(portionIds[i]);
		}
	}

	public VcmsPortion getPortion(String portionId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(portionId)) {
			throw new NoSuchVcmsPortionException();
		}

		return vcmsPortionPersistence.findByPrimaryKey(portionId);
	}

	public VcmsPortion getPortionByS_C(long groupId, String code)
			throws PortalException, SystemException, RemoteException {
		return vcmsPortionPersistence.findByS_C(groupId, code);
	}

	public List<VcmsPortion> getPortionsByS_L(long groupId, String language)
			throws PortalException, SystemException, RemoteException {
		return vcmsPortionPersistence.findByS_L(groupId, language);
	}

	public List<VcmsPortion> getPortionsByS_L(long groupId, String language,
			int start, int end) throws PortalException, SystemException,
			RemoteException {
		return vcmsPortionPersistence.findByS_L(groupId, language, start, end);
	}

	public int countPortionsByS_L(long groupId, String language)
			throws SystemException {
		return vcmsPortionPersistence.countByS_L(groupId, language);
	}

	// Common Resources Utilities ...

	public int countByCategorizable(long groupId, boolean categorizable)
			throws PortalException, SystemException, RemoteException {

		if (Validator.isNull(groupId)) {
			return 0;
		}

		return vcmsPortionPersistence.countByCategorizable(groupId,
				categorizable);
	}

	private void _validate(long groupId, String portionId, String code,
			String name, boolean isNew) throws PortalException, SystemException {

		if (Validator.isNull(code)) {
			throw new InvalidPortionCodeException();
		}

		if (Validator.isNull(name)) {
			throw new InvalidPortionNameException();
		}

		VcmsPortion portion = null;

		if (Validator.isNotNull(code)) {
			try {
				portion = vcmsPortionPersistence.findByS_C(groupId, code);
			} catch (Exception ex) {
				// Ignore..
			}
		}

		if (isNew) {
			if ((portion != null) && portion.getCode().equals(code)) {
				throw new DuplicatePortionCodeException();
			}
		} else {
			if ((portion != null) && portion.getCode().equals(code)
					&& !portion.getPortionId().equals(portionId)) {
				throw new DuplicatePortionCodeException();
			}
		}
	}
}