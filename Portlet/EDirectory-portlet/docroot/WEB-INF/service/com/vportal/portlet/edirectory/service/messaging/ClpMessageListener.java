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

package com.vportal.portlet.edirectory.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.vportal.portlet.edirectory.service.ClpSerializer;
import com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDDepartmentServiceUtil;
import com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDEmployeeServiceUtil;
import com.vportal.portlet.edirectory.service.EDFunctionDepartmentLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDFunctionDepartmentServiceUtil;
import com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDFunctionEmployeeServiceUtil;
import com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil;
import com.vportal.portlet.edirectory.service.EDFunctionServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			EDDepartmentLocalServiceUtil.clearService();

			EDDepartmentServiceUtil.clearService();
			EDEmployeeLocalServiceUtil.clearService();

			EDEmployeeServiceUtil.clearService();
			EDFunctionLocalServiceUtil.clearService();

			EDFunctionServiceUtil.clearService();
			EDFunctionDepartmentLocalServiceUtil.clearService();

			EDFunctionDepartmentServiceUtil.clearService();
			EDFunctionEmployeeLocalServiceUtil.clearService();

			EDFunctionEmployeeServiceUtil.clearService();
		}
	}
}