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

import com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsCARelationSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsCARelation}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsCARelationSoap}. Methods that SOAP cannot
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
 * @see       VcmsCARelationServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsCARelationSoap
 * @see       com.vportal.portlet.vcms.service.VcmsCARelationServiceUtil
 * @generated
 */
public class VcmsCARelationServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsCARelationSoap addRelation(
		java.lang.String categoryId, java.lang.String articleId, long statusId)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsCARelation returnValue = VcmsCARelationServiceUtil.addRelation(categoryId,
					articleId, statusId);

			return com.vportal.portlet.vcms.model.VcmsCARelationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelation(java.lang.String categoryId,
		java.lang.String articleId) throws RemoteException {
		try {
			VcmsCARelationServiceUtil.deleteRelation(categoryId, articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelationsByCategory(java.lang.String categoryId)
		throws RemoteException {
		try {
			VcmsCARelationServiceUtil.deleteRelationsByCategory(categoryId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelationsByArticle(java.lang.String articleId)
		throws RemoteException {
		try {
			VcmsCARelationServiceUtil.deleteRelationsByArticle(articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCARelation[] getRelationsByCategory(
		java.lang.String categoryId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> returnValue =
				VcmsCARelationServiceUtil.getRelationsByCategory(categoryId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsCARelation[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCARelation[] getRelationsByArticle(
		java.lang.String articleId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsCARelation> returnValue =
				VcmsCARelationServiceUtil.getRelationsByArticle(articleId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsCARelation[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticlesOfCategory(java.lang.String categoryId)
		throws RemoteException {
		try {
			int returnValue = VcmsCARelationServiceUtil.countArticlesOfCategory(categoryId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsCARelationSoap findRelationsByArticle(
		java.lang.String articleId) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsCARelation returnValue = VcmsCARelationServiceUtil.findRelationsByArticle(articleId);

			return com.vportal.portlet.vcms.model.VcmsCARelationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsCARelationServiceSoap.class);
}