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

package com.vportal.portlet.vsitemapview;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class ViewSitemap
 */
public class ViewSitemap extends MVCPortlet {
	public void processAction(ActionRequest req, ActionResponse res) {
	try {

		String themeType = ParamUtil.getString(req, "themeType");
		String themeSelected = ParamUtil.getString(req, "themeSelected");
		String titlePortlet = ParamUtil.getString(req, "titlePortlet");
		String bgcolor = ParamUtil.getString(req, "bgcolor");

		PortletPreferences prefs = req.getPreferences();

		prefs.setValue("themeType", themeType);
		prefs.setValue("themeSelected", themeSelected);
		prefs.setValue("titlePortlet", titlePortlet);
		prefs.setValue("bgcolor", bgcolor);
		prefs.store();
		} catch (Exception ex) {
		ex.printStackTrace();
	}
	res.setRenderParameter("jspPage", "/html/portlet/vsitemapview/view.jsp");

}}
