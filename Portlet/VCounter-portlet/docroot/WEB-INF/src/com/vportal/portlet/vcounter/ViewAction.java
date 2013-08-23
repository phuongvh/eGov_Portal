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
package com.vportal.portlet.vcounter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {
 
	public void savePreferences(ActionRequest req, ActionResponse res) {
		try {

			String titlePortlet = ParamUtil.getString(req, "titlePortlet");
			boolean isBorder = ParamUtil.getBoolean(req, "isBorder");
			String bgcolor = ParamUtil.getString(req, "bgcolor");

			String themeType = ParamUtil.getString(req, "themeType");
			String themeSelected = ParamUtil.getString(req, "themeSelected");

			String style = ParamUtil.getString(req, "style", StringPool.BLANK);
			String styleBorder = ParamUtil.getString(req, "styleBorder",
					StringPool.BLANK);
			String styleBullet = ParamUtil.getString(req, "styleBullet",
					StringPool.BLANK);
			String styleTitle = ParamUtil.getString(req, "styleTitle",
					StringPool.BLANK);

			// Save these settings to preferences
			int paddingLeft = ParamUtil.getInteger(req, "paddingLeft");
			int paddingRight = ParamUtil.getInteger(req, "paddingRight");

			PortletPreferences prefs = req.getPreferences();

			prefs.setValue("paddingLeft", String.valueOf(paddingLeft));
			prefs.setValue("paddingRight", String.valueOf(paddingRight));

			prefs.setValue("bgcolor", bgcolor);
			prefs.setValue("isBorder", String.valueOf(isBorder));
			prefs.setValue("themeType", themeType);
			prefs.setValue("themeSelected", themeSelected);
			prefs.setValue("titlePortlet", titlePortlet);

			prefs.setValue("style", style);
			prefs.setValue("styleBorder", styleBorder);
			prefs.setValue("styleBullet", styleBullet);
			prefs.setValue("styleTitle", styleTitle);

			prefs.store();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
