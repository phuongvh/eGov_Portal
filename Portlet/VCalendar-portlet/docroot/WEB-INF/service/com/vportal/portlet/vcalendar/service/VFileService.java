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

package com.vportal.portlet.vcalendar.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the v file remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LongLH
 * @see VFileServiceUtil
 * @see com.vportal.portlet.vcalendar.service.base.VFileServiceBaseImpl
 * @see com.vportal.portlet.vcalendar.service.impl.VFileServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VFileService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VFileServiceUtil} to access the v file remote service. Add custom service methods to {@link com.vportal.portlet.vcalendar.service.impl.VFileServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public com.vportal.portlet.vcalendar.model.VFile addVFile(
		java.lang.String fullname, java.lang.String phone,
		java.lang.String address, java.lang.String position,
		java.util.Date birthday, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.vportal.portlet.vcalendar.model.VFile updateVFile(long fileId,
		java.lang.String fullname, java.lang.String phone,
		java.lang.String address, java.lang.String position,
		java.util.Date birthday, int status)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException;

	public com.vportal.portlet.vcalendar.model.VFile deleteVFile(long fileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException;

	public com.vportal.portlet.vcalendar.model.VFile findById(long fileId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.vportal.portlet.vcalendar.NoSuchVFileException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByAll(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupId(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.vportal.portlet.vcalendar.model.VFile> findByGroupId(
		int status, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroupId(int status)
		throws com.liferay.portal.kernel.exception.SystemException;
}