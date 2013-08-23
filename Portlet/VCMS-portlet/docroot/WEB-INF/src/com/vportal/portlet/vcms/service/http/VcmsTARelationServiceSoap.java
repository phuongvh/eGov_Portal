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

import com.vportal.portlet.vcms.service.VcmsTARelationServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsTARelationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsTARelationSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsTARelation}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsTARelationSoap}. Methods that SOAP cannot
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
 * @see       VcmsTARelationServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsTARelationSoap
 * @see       com.vportal.portlet.vcms.service.VcmsTARelationServiceUtil
 * @generated
 */
public class VcmsTARelationServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsTARelationSoap addRelation(
		java.lang.String threadId, java.lang.String articleId)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsTARelation returnValue = VcmsTARelationServiceUtil.addRelation(threadId,
					articleId);

			return com.vportal.portlet.vcms.model.VcmsTARelationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelation(java.lang.String threadId,
		java.lang.String articleId) throws RemoteException {
		try {
			VcmsTARelationServiceUtil.deleteRelation(threadId, articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelationsByArticle(java.lang.String articleId)
		throws RemoteException {
		try {
			VcmsTARelationServiceUtil.deleteRelationsByArticle(articleId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelationsByThread(java.lang.String threadId)
		throws RemoteException {
		try {
			VcmsTARelationServiceUtil.deleteRelationsByThread(threadId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsTARelation[] getRelationsByArticle(
		java.lang.String articleId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> returnValue =
				VcmsTARelationServiceUtil.getRelationsByArticle(articleId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsTARelation[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsTARelation[] getRelationsByThread(
		java.lang.String threadId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsTARelation> returnValue =
				VcmsTARelationServiceUtil.getRelationsByThread(threadId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsTARelation[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countArticlesOfThread(java.lang.String threadId)
		throws RemoteException {
		try {
			int returnValue = VcmsTARelationServiceUtil.countArticlesOfThread(threadId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countRelationByThread(java.lang.String threadId)
		throws RemoteException {
		try {
			int returnValue = VcmsTARelationServiceUtil.countRelationByThread(threadId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsTARelationServiceSoap.class);
}