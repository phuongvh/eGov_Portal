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

import com.vportal.portlet.vcms.service.VcmsPARelationServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsPARelationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsPARelationSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsPARelation}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsPARelationSoap}. Methods that SOAP cannot
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
 * @see       VcmsPARelationServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsPARelationSoap
 * @see       com.vportal.portlet.vcms.service.VcmsPARelationServiceUtil
 * @generated
 */
public class VcmsPARelationServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsPARelationSoap addRelation(
		java.lang.String portionId, java.lang.String articleId)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsPARelation returnValue = VcmsPARelationServiceUtil.addRelation(portionId,
					articleId);

			return com.vportal.portlet.vcms.model.VcmsPARelationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelation(java.lang.String portionId,
		java.lang.String articleId) throws RemoteException {
		try {
			VcmsPARelationServiceUtil.deleteRelation(portionId, articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelationsByPortion(java.lang.String portionId)
		throws RemoteException {
		try {
			VcmsPARelationServiceUtil.deleteRelationsByPortion(portionId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelationsByArticle(java.lang.String articleId)
		throws RemoteException {
		try {
			VcmsPARelationServiceUtil.deleteRelationsByArticle(articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsPARelation[] getRelationsByPortion(
		java.lang.String portionId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> returnValue =
				VcmsPARelationServiceUtil.getRelationsByPortion(portionId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsPARelation[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsPARelation[] getRelationsByArticle(
		java.lang.String articleId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsPARelation> returnValue =
				VcmsPARelationServiceUtil.getRelationsByArticle(articleId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsPARelation[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsPARelationServiceSoap.class);
}