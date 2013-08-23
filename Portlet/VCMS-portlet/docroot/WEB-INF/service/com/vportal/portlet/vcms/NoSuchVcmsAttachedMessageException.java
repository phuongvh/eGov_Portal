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

package com.vportal.portlet.vcms;

import com.liferay.portal.NoSuchModelException;

/**
 * @author hai
 */
public class NoSuchVcmsAttachedMessageException extends NoSuchModelException {

	public NoSuchVcmsAttachedMessageException() {
		super();
	}

	public NoSuchVcmsAttachedMessageException(String msg) {
		super(msg);
	}

	public NoSuchVcmsAttachedMessageException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchVcmsAttachedMessageException(Throwable cause) {
		super(cause);
	}

}