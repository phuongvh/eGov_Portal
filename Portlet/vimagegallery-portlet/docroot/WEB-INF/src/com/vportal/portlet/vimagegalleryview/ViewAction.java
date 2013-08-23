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

package com.vportal.portlet.vimagegalleryview;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * 
 * @author thuynv
 * 
 */
public class ViewAction extends MVCPortlet {
	public static List getPortletIdsByLayout(long plid) throws Exception {

		Layout layoutSelected = (Layout) LayoutLocalServiceUtil.getLayout(plid);

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layoutSelected
				.getLayoutType();

		List portletIds = layoutTypePortlet.getPortletIds();

		List tempPorletIds = new ArrayList();

		for (int i = 0; i < portletIds.size(); i++) {
			String portletId = (String) portletIds.get(i);

			if (portletId.indexOf("vphotogalleryview_INSTANCE_") == 0) {
				tempPorletIds.add(portletId);
			}
		}

		return tempPorletIds;
	}

	public static void getLayoutPortletIds(List selectLayouts,
			PortletRequest req, String currentPortletId) throws Exception {

		boolean privateLayout = false;

		boolean hasLayout = false;

		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getPortletGroupId();

		long currentPlId = themeDisplay.getPlid();

		// get current portlet layout
		Layout currentLayout = LayoutLocalServiceUtil.getLayout(currentPlId);
		privateLayout = currentLayout.getPrivateLayout();

		// find portlet in layout
		List layouts = LayoutLocalServiceUtil
				.getLayouts(groupId, privateLayout);

		for (int i = 0; i < layouts.size(); i++) {
			Layout layout = (Layout) layouts.get(i);

			hasLayout = false;
			// layout.get
			if (!layout.getType().equals(LayoutConstants.TYPE_PORTLET)) {
				continue;
			}

			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
					.getLayoutType();

			List portletIds = layoutTypePortlet.getPortletIds();
			if (portletIds != null && portletIds.size() > 0) {
				for (int count = 0; count < portletIds.size(); count++) {
					String portletIdLayout = String.valueOf(portletIds
							.get(count));

					if (portletIdLayout.indexOf(currentPortletId) >= 0) {
						//selectPortletLayoutIds.add(portletIdLayout+"|"+layout.
						// getPlid());
						hasLayout = true;
					}
				}
			}

			if (hasLayout) {
				selectLayouts.add(layout);
			}
		}

	}
	
	public void processAction(PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		try {
			String numOfImagePerPage = ParamUtil.getString(req,
					"numOfImagePerPage", StringPool.BLANK);

			String speed = ParamUtil.getString(req, "speed", StringPool.BLANK);

			boolean showDesc = ParamUtil.getBoolean(req, "showDesc", true);

			boolean showControl = ParamUtil
					.getBoolean(req, "showControl", true);

			String styleTitle = ParamUtil.getString(req, "styleTitle");
			String styleBorder = ParamUtil.getString(req, "styleBorder");
			String styleBullet = ParamUtil.getString(req, "styleBullet");
			String styleContent = ParamUtil.getString(req, "styleContent");

			String themeType = ParamUtil.getString(req, "themeType");
			String themeSelected = ParamUtil.getString(req, "themeSelected");

			PortletPreferences prefs = req.getPreferences();

			prefs.setValue("numofImagePerPage", numOfImagePerPage);
			prefs.setValue("speed", speed);
			prefs.setValue("showDesc", String.valueOf(showDesc));
			prefs.setValue("showControl", String.valueOf(showControl));

			prefs.setValue("styleTitle", styleTitle);
			prefs.setValue("styleBorder", styleBorder);
			prefs.setValue("styleBullet", styleBullet);
			prefs.setValue("styleContent", styleContent);

			prefs.setValue("themeType", themeType);
			prefs.setValue("themeSelected", themeSelected);

			prefs.store();

			SessionMessages.add(req, config.getPortletName() + ".doEdit");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
