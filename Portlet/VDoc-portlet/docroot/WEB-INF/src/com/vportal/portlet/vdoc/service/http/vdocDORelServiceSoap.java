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

package com.vportal.portlet.vdoc.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.vportal.portlet.vdoc.service.vdocDORelServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vdoc.service.vdocDORelServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vdoc.model.vdocDORelSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vdoc.model.vdocDORel}, that is translated to a
 * {@link com.vportal.portlet.vdoc.model.vdocDORelSoap}. Methods that SOAP cannot
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
 * @author    MrEn
 * @see       vdocDORelServiceHttp
 * @see       com.vportal.portlet.vdoc.model.vdocDORelSoap
 * @see       com.vportal.portlet.vdoc.service.vdocDORelServiceUtil
 * @generated
 */
public class vdocDORelServiceSoap {
	public static int countCategory_approving(java.lang.String categoryId)
		throws RemoteException {
		try {
			int returnValue = vdocDORelServiceUtil.countCategory_approving(categoryId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countCategory_public(java.lang.String categoryId)
		throws RemoteException {
		try {
			int returnValue = vdocDORelServiceUtil.countCategory_public(categoryId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countCategory_modify(java.lang.String categoryId)
		throws RemoteException {
		try {
			int returnValue = vdocDORelServiceUtil.countCategory_modify(categoryId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDORelSoap addRelation(
		java.lang.String docId, java.lang.String orgId)
		throws RemoteException {
		try {
			com.vportal.portlet.vdoc.model.vdocDORel returnValue = vdocDORelServiceUtil.addRelation(docId,
					orgId);

			return com.vportal.portlet.vdoc.model.vdocDORelSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelation(java.lang.String docId,
		java.lang.String orgId) throws RemoteException {
		try {
			vdocDORelServiceUtil.deleteRelation(docId, orgId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRelByDoc(java.lang.String docId)
		throws RemoteException {
		try {
			vdocDORelServiceUtil.deleteRelByDoc(docId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDORel[] getDORelByDoc(
		java.lang.String docId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> returnValue =
				vdocDORelServiceUtil.getDORelByDoc(docId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDORel[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDORel[] getDORelByOrg(
		java.lang.String orgId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> returnValue =
				vdocDORelServiceUtil.getDORelByOrg(orgId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDORel[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDORel[] getRelByDoc(
		java.lang.String docId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> returnValue =
				vdocDORelServiceUtil.getRelByDoc(docId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDORel[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vdoc.model.vdocDORel[] getRelByField(
		java.lang.String orgId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vdoc.model.vdocDORel> returnValue =
				vdocDORelServiceUtil.getRelByField(orgId);

			return returnValue.toArray(new com.vportal.portlet.vdoc.model.vdocDORel[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(vdocDORelServiceSoap.class);
}