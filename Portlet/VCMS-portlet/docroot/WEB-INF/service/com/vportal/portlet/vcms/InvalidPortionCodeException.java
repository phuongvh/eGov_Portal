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

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author hai
 */
public class InvalidPortionCodeException extends PortalException {

	public InvalidPortionCodeException() {
		super();
	}

	public InvalidPortionCodeException(String msg) {
		super(msg);
	}

	public InvalidPortionCodeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidPortionCodeException(Throwable cause) {
		super(cause);
	}

}