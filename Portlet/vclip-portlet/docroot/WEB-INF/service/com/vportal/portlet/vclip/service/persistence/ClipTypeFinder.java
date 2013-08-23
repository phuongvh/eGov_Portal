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

package com.vportal.portlet.vclip.service.persistence;

/**
 * @author HOAN
 */
public interface ClipTypeFinder {
	public java.util.List findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception;

	public java.util.List findClipType(
		com.vportal.portlet.vclip.model.ClipType clipType, int start, int end)
		throws java.lang.Exception;

	public int countClipType(com.vportal.portlet.vclip.model.ClipType clipType)
		throws java.lang.Exception;
}