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
package com.vportal.portlet.vcounter.util;

public class ECounterUtil {
	
	private static int counter = 0;
	private static int online = 0;
	private static int numberAccess = 0;

	public static void online() {
		online++;
		System.out.print(online);
	}

	public static void offline() {
		online--;
	}

	public static int getNumberAccess() {
		return numberAccess;
	}

	public static int getOnline() {
		return online;
	}
}
