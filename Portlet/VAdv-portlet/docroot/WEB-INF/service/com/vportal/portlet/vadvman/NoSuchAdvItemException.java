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

package com.vportal.portlet.vadvman;

import com.liferay.portal.NoSuchModelException;

/**
 * @author DucNN
 */
public class NoSuchAdvItemException extends NoSuchModelException {

	public NoSuchAdvItemException() {
		super();
	}

	public NoSuchAdvItemException(String msg) {
		super(msg);
	}

	public NoSuchAdvItemException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchAdvItemException(Throwable cause) {
		super(cause);
	}

}