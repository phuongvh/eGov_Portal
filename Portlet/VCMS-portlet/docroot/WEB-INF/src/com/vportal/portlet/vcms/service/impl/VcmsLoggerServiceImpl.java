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
import com.vportal.portlet.vcms.model.VcmsLogger;
import com.vportal.portlet.vcms.service.base.VcmsLoggerServiceBaseImpl;
import com.vportal.portlet.vcms.service.persistence.VcmsLoggerUtil;

/**
 * The implementation of the vcms logger remote service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vportal.portlet.vcms.service.VcmsLoggerService} interface.
 * </p>
 * 
 * <p>
 * Never reference this interface directly. Always use
 * {@link com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil} to access the
 * vcms logger remote service.
 * </p>
 * 
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 * 
 * @author HOAN
 * @see com.vportal.portlet.vcms.service.base.VcmsLoggerServiceBaseImpl
 * @see com.vportal.portlet.vcms.service.VcmsLoggerServiceUtil
 */
public class VcmsLoggerServiceImpl extends VcmsLoggerServiceBaseImpl {
	public VcmsLogger log(String content) throws PortalException,
			SystemException, RemoteException {

		// Could not create log once the log content is null

		if (Validator.isNull(content)) {
			return null;
		}

		String logId = Long.toString(CounterLocalServiceUtil
				.increment(VcmsLogger.class.getName()));

		VcmsLogger logger = VcmsLoggerUtil.create(logId);

		logger.setCreatedDate(new Date());
		logger.setCreatedByUser(String.valueOf(getUserId()));
		logger.setContent(content);

		VcmsLoggerUtil.update(logger, false);

		return logger;
	}

	public List<VcmsLogger> findLogsByUser(String userId)
			throws PortalException, SystemException, RemoteException {
		return vcmsLoggerFinder.findByUser(userId);
	}

	public List<VcmsLogger> findLogs(Date from, Date to)
			throws PortalException, SystemException, RemoteException {
		return vcmsLoggerFinder.findByPeriod(from, to);
	}

	// add by Donghh
	public List<VcmsLogger> findLogersByD_A_K(String keyword, int select,
			Date datePresent) throws PortalException, SystemException,
			RemoteException {

		return (List) vcmsLoggerFinder
				.findByD_A_K(keyword, select, datePresent);
	}

	public List<VcmsLogger> findLogersByD_A_K(String keyword, int select,
			Date datePresent, int start, int end) throws PortalException,
			SystemException, RemoteException {

		return (List) vcmsLoggerFinder.findByD_A_K(keyword, select,
				datePresent, start, end);
	}

	public int countLogersByD_A_K(String keyword, int select, Date datePresent)
			throws PortalException, SystemException, RemoteException {

		return vcmsLoggerFinder.countByD_A_K(keyword, select, datePresent);
	}

	public List<VcmsLogger> findLogs() throws PortalException, SystemException,
			RemoteException {

		return vcmsLoggerPersistence.findAll();
	}

	public int countLogs() throws SystemException {
		return vcmsLoggerPersistence.countAll();

	}

	public List<VcmsLogger> findLogs(int start, int end)
			throws PortalException, SystemException, RemoteException {
		return vcmsLoggerPersistence.findAll(start, end);
	}

	public void removeLogs(Date from, Date to) throws PortalException,
			SystemException, RemoteException {

		if (!CalendarUtil.beforeByDay(from, to)) {
			return;
		}

		vcmsLoggerFinder.removeByPeriod(from, to);
	}

	public void removeLog(String loggerId) throws PortalException,
			SystemException, RemoteException {

		if (Validator.isNull(loggerId)) {
			return;
		}

		VcmsLoggerUtil.remove(loggerId);
	}
}