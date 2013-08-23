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
package com.vportal.portlet.vcalendar.util;

import java.util.Calendar;

public class VCalUtil {

	public static Calendar getFirstDayOfWeek(Calendar cal) {

		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			break;
		case 2:
			cal.add(Calendar.DATE, -1);
			break;
		case 3:
			cal.add(Calendar.DATE, -2);
			break;
		case 4:
			cal.add(Calendar.DATE, -3);
			break;
		case 5:
			cal.add(Calendar.DATE, -4);
			break;
		case 6:
			cal.add(Calendar.DATE, -5);
			break;
		case 7:
			cal.add(Calendar.DATE, -6);
			break;
		}

		return cal;
	}
}
