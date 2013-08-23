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

package com.vportal.portlet.vcms.service.persistence;

/**
 * @author hai
 */
public interface VcmsLoggerFinder {
	public java.util.List findByUser(java.lang.String createdByUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByPeriod(java.util.Date from, java.util.Date to)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByD_A_K(java.lang.String keyword, int select,
		java.util.Date datePresent)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByD_A_K(java.lang.String keyword, int select,
		java.util.Date datePresent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByD_A_K(java.lang.String keyword, int select,
		java.util.Date datePresent)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void removeByPeriod(java.util.Date from, java.util.Date to)
		throws com.liferay.portal.kernel.exception.SystemException;
}