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

import com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsLoggerSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsLogger}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsLoggerSoap}. Methods that SOAP cannot
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
 * @see       VcmsLoggerServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsLoggerSoap
 * @see       com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil
 * @generated
 */
public class VcmsLoggerServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsLoggerSoap log(
		java.lang.String content) throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsLogger returnValue = VcmsLoggerServiceUtil.log(content);

			return com.vportal.portlet.vcms.model.VcmsLoggerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsLogger[] findLogsByUser(
		java.lang.String userId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> returnValue =
				VcmsLoggerServiceUtil.findLogsByUser(userId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsLogger[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsLogger[] findLogs(
		java.util.Date from, java.util.Date to) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> returnValue =
				VcmsLoggerServiceUtil.findLogs(from, to);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsLogger[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsLogger[] findLogersByD_A_K(
		java.lang.String keyword, int select, java.util.Date datePresent)
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> returnValue =
				VcmsLoggerServiceUtil.findLogersByD_A_K(keyword, select,
					datePresent);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsLogger[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsLogger[] findLogersByD_A_K(
		java.lang.String keyword, int select, java.util.Date datePresent,
		int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> returnValue =
				VcmsLoggerServiceUtil.findLogersByD_A_K(keyword, select,
					datePresent, start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsLogger[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countLogersByD_A_K(java.lang.String keyword, int select,
		java.util.Date datePresent) throws RemoteException {
		try {
			int returnValue = VcmsLoggerServiceUtil.countLogersByD_A_K(keyword,
					select, datePresent);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsLogger[] findLogs()
		throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> returnValue =
				VcmsLoggerServiceUtil.findLogs();

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsLogger[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countLogs() throws RemoteException {
		try {
			int returnValue = VcmsLoggerServiceUtil.countLogs();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsLogger[] findLogs(
		int start, int end) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsLogger> returnValue =
				VcmsLoggerServiceUtil.findLogs(start, end);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsLogger[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeLogs(java.util.Date from, java.util.Date to)
		throws RemoteException {
		try {
			VcmsLoggerServiceUtil.removeLogs(from, to);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeLog(java.lang.String loggerId)
		throws RemoteException {
		try {
			VcmsLoggerServiceUtil.removeLog(loggerId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsLoggerServiceSoap.class);
}