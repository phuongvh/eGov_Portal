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

import com.vportal.portlet.vcms.service.VcmsArticleVersionServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.vportal.portlet.vcms.service.VcmsArticleVersionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.vportal.portlet.vcms.model.VcmsArticleVersionSoap}.
 * If the method in the service utility returns a
 * {@link com.vportal.portlet.vcms.model.VcmsArticleVersion}, that is translated to a
 * {@link com.vportal.portlet.vcms.model.VcmsArticleVersionSoap}. Methods that SOAP cannot
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
 * @see       VcmsArticleVersionServiceHttp
 * @see       com.vportal.portlet.vcms.model.VcmsArticleVersionSoap
 * @see       com.vportal.portlet.vcms.service.VcmsArticleVersionServiceUtil
 * @generated
 */
public class VcmsArticleVersionServiceSoap {
	public static com.vportal.portlet.vcms.model.VcmsArticleVersionSoap addVersion(
		long groupId, java.lang.String language, long companyId,
		java.lang.String articleId, java.lang.String typeIds, long status,
		java.lang.String versionName, java.lang.String title,
		java.lang.String lead, java.lang.String content, long userHit,
		boolean hasImage, java.lang.String imageTitle, java.lang.String image,
		java.lang.String author, java.lang.String source, boolean discussible,
		boolean hasPoll, java.lang.String pollId, java.util.Date effectiveDate,
		java.util.Date expireDate, boolean sticky, boolean stickyNeverExpired,
		java.util.Date stickyExpireDate, boolean hasAttach)
		throws RemoteException {
		try {
			com.vportal.portlet.vcms.model.VcmsArticleVersion returnValue = VcmsArticleVersionServiceUtil.addVersion(groupId,
					language, companyId, articleId, typeIds, status,
					versionName, title, lead, content, userHit, hasImage,
					imageTitle, image, author, source, discussible, hasPoll,
					pollId, effectiveDate, expireDate, sticky,
					stickyNeverExpired, stickyExpireDate, hasAttach);

			return com.vportal.portlet.vcms.model.VcmsArticleVersionSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countVersionByArticleId(java.lang.String articleId)
		throws RemoteException {
		try {
			int returnValue = VcmsArticleVersionServiceUtil.countVersionByArticleId(articleId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.vportal.portlet.vcms.model.VcmsArticleVersion[] listVersionByArticleId(
		java.lang.String articleId) throws RemoteException {
		try {
			java.util.List<com.vportal.portlet.vcms.model.VcmsArticleVersion> returnValue =
				VcmsArticleVersionServiceUtil.listVersionByArticleId(articleId);

			return returnValue.toArray(new com.vportal.portlet.vcms.model.VcmsArticleVersion[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VcmsArticleVersionServiceSoap.class);
}