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

package com.vportal.portlet.vlinksmanview;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ViewAction
 */
public class ViewAction extends MVCPortlet {
	@Override
	public void processAction(ActionRequest req, ActionResponse res)
			throws IOException, PortletException {
		String[] linkGroupIds = req.getParameterValues("linkGroupIds");

		String linkgroupId = ParamUtil.getString(req, "linkgroupId",
				StringPool.BLANK);

		String titlePortlet = ParamUtil.getString(req, "titlePortlet");

		String styleTitle = ParamUtil.getString(req, "styleTitle");
		String styleBorder = ParamUtil.getString(req, "styleBorder");
		String styleBullet = ParamUtil.getString(req, "styleBullet");
		String styleContent = ParamUtil.getString(req, "styleContent");

		String themeType = ParamUtil.getString(req, "themeType");
		String themeSelected = ParamUtil.getString(req, "themeSelected");

		String selectstyleBorder = ParamUtil.getString(req,
				"selectstyleBorder", StringPool.BLANK);

		int style = ParamUtil.getInteger(req, "style");
		int typeDisplay = ParamUtil.getInteger(req, "typeDisplay");
		boolean isBorder = ParamUtil.getBoolean(req, "isBorder");
		String bgcolor = ParamUtil.getString(req, "bgcolor");

		int paddingLeft = ParamUtil.getInteger(req, "paddingLeft");
		int paddingRight = ParamUtil.getInteger(req, "paddingRight");

		PortletPreferences prefs = req.getPreferences();

		prefs.setValue("paddingLeft", String.valueOf(paddingLeft));
		prefs.setValue("paddingRight", String.valueOf(paddingRight));

		prefs.setValue("bgcolor", bgcolor);
		prefs.setValue("isBorder", String.valueOf(isBorder));
		prefs.setValue("style", String.valueOf(style));
		prefs.setValue("linkgroupId", linkgroupId);
		prefs.setValues("linkGroupIds", linkGroupIds);
		prefs.setValue("titlePortlet", titlePortlet);
		prefs.setValue("typeDisplay", String.valueOf(typeDisplay));

		prefs.setValue("selectstyleBorder", selectstyleBorder);

		prefs.setValue("styleTitle", styleTitle);
		prefs.setValue("styleBorder", styleBorder);
		prefs.setValue("styleBullet", styleBullet);
		prefs.setValue("styleContent", styleContent);

		prefs.setValue("themeType", themeType);
		prefs.setValue("themeSelected", themeSelected);

		prefs.store();
		super.processAction(req, res);
	}

}
