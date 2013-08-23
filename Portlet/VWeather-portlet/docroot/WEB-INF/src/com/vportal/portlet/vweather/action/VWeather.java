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

package com.vportal.portlet.vweather.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VWeather
 */
public class VWeather extends MVCPortlet {
	public void processDisplayStyle(ActionRequest request,
			ActionResponse response) throws Exception {

		String cmd = ParamUtil.getString(request, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		PortletPreferences prefs = request.getPreferences();

		String displayStyle = ParamUtil.getString(request, "displayStyle");

		prefs.setValue("displayStyle", displayStyle);

		prefs.store();

		response.setRenderParameter("jspPage",
				"/html/portlet/vweather/view.jsp");

	}

}
