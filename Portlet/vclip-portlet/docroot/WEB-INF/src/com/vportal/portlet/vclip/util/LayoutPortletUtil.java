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
package com.vportal.portlet.vclip.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * @author donghh
 * @version 1.0.00, Jun 24, 2008
 */
public class LayoutPortletUtil {

	public static List getPortletIdsByLayout(long plid) throws Exception {

		Layout layoutSelected = (Layout) LayoutLocalServiceUtil.getLayout(plid);

		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layoutSelected
				.getLayoutType();

		List portletIds = layoutTypePortlet.getPortletIds();

		List tempPorletIds = new ArrayList();

		for (int i = 0; i < portletIds.size(); i++) {
			String portletId = (String) portletIds.get(i);

			if (portletId.indexOf("vclipcontent_WAR_vclipportlet_INSTANCE_") == 0) {
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

		long groupId = themeDisplay.getScopeGroupId();

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
						// selectPortletLayoutIds.add(portletIdLayout+"|"+layout.getPlid());
						hasLayout = true;
					}

				}
			}

			if (hasLayout) {
				selectLayouts.add(layout);
			}
		}

	}

}
