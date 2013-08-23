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

package com.vportal.portlet.vcms.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vcms.service.VcmsPortionServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsPortionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsPortionSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsPortion}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsPortionSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    hai
 * @see       VcmsPortionServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsPortionSoap
 * @see       com.vportal.portlet.vcms.service.VcmsPortionServiceUtil
 * @generated
 */
public class VcmsPortionServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsPortionSoap addPortion(
		long groupId, long companyId, long plid, java.lang.String code,
		java.lang.String name, java.lang.String description,
		boolean categorizable, java.lang.String language,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsPortion returnValue = VcmsPortionServiceUtil.addPortion(groupId,
					companyId, plid, code, name, description, categorizable,
					language, communityPermissions, guestPermissions);

			return com.vportal.portlet.vcms.model.VcmsPortionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsPortionSoap addPortion(
		long groupId, long companyId, long plid, java.lang.String code,
		java.lang.String name, java.lang.String description,
		boolean categorizable, java.lang.String language,
		java.lang.Boolean addCommunityPermissions,
		java.lang.Boolean addGuestPermissions,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsPortion returnValue = VcmsPortionServiceUtil.addPortion(groupId,
					companyId, plid, code, name, description, categorizable,
					language, addCommunityPermissions, addGuestPermissions,
					communityPermissions, guestPermissions);

			return com.vportal.portlet.vcms.model.VcmsPortionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addPortionResources(java.lang.String portionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VcmsPortionServiceUtil.addPortionResources(portionId,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addPortionResources(
		com.vportal.portlet.vcms.model.VcmsPortion portion,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws RemoteException {
		try {
			VcmsPortionServiceUtil.addPortionResources(portion,
				addCommunityPermissions, addGuestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addPortionResources(java.lang.String portionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VcmsPortionServiceUtil.addPortionResources(portionId,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addPortionResources(
		com.vportal.portlet.vcms.model.VcmsPortion portion,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions) throws RemoteException {
		try {
			VcmsPortionServiceUtil.addPortionResources(portion,
				communityPermissions, guestPermissions);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsPortionSoap updatePortion(
		java.lang.String portionId, long groupId, long companyId,
		java.lang.String code, java.lang.String name,
		java.lang.String description, boolean categorizable,
		java.lang.String language) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsPortion returnValue = VcmsPortionServiceUtil.updatePortion(portionId,
					groupId, companyId, code, name, description, categorizable,
					language);

			return com.vportal.portlet.vcms.model.VcmsPortionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deletePortion(java.lang.String portionId)
		throws RemoteException {
		try {
			VcmsPortionServiceUtil.deletePortion(portionId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deletePortions(java.lang.String[] portionIds)
		throws RemoteException {
		try {
			VcmsPortionServiceUtil.deletePortions(portionIds);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsPortionSoap getPortion(
		java.lang.String portionId) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsPortion returnValue = VcmsPortionServiceUtil.getPortion(portionId);

			return com.vportal.portlet.vcms.model.VcmsPortionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsPortionSoap getPortionByS_C(
		long groupId, java.lang.String code) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsPortion returnValue = VcmsPortionServiceUtil.getPortionByS_C(groupId,
					code);

			return com.vportal.portlet.vcms.model.VcmsPortionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsPortion[] getPortionsByS_L(
		long groupId, java.lang.String language) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> returnValue =
				VcmsPortionServiceUtil.getPortionsByS_L(groupId, language);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsPortion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsPortion[] getPortionsByS_L(
		long groupId, java.lang.String language, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsPortion> returnValue =
				VcmsPortionServiceUtil.getPortionsByS_L(groupId, language,
					start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsPortion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countPortionsByS_L(long groupId, java.lang.String language)
		throws RemoteException {
		try {
			int returnValue = VcmsPortionServiceUtil.countPortionsByS_L(groupId,
					language);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByCategorizable(long groupId, boolean categorizable)
		throws RemoteException {
		try {
			int returnValue = VcmsPortionServiceUtil.countByCategorizable(groupId,
					categorizable);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsPortionServiceSoap.class);
}