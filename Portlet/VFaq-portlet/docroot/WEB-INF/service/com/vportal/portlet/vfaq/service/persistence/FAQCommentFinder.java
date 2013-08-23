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

package com.vportal.portlet.vfaq.service.persistence;

/**
 * @author DucNN
 */
public interface FAQCommentFinder {
	public java.util.List findByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByGroupId(long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List findByPara(long groupId, java.lang.String title,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByPara(long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;
}