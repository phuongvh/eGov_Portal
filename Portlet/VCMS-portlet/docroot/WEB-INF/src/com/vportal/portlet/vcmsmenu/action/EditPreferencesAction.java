
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

package com.vportal.portlet.vcmsmenu.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.vportal.portal.util.PropsUtilExt;
import com.vportal.portlet.vcmsview.util.ConstantsExt;
import com.vportal.portlet.vcmsviewcontent.util.LayoutPortletUtil;

public class EditPreferencesAction implements ConfigurationAction {

	public void processAction(PortletConfig arg0, ActionRequest req,
			ActionResponse res) throws Exception {
		// TODO Auto-generated method stub
		int displayStyle = ParamUtil.getInteger(req, "displayStyle");

		String categories = ParamUtil.getString(req, "categories",
				StringPool.BLANK);
		String portionId = ParamUtil.getString(req, "portionId",
				StringPool.BLANK);
		String categoriesStyle = ParamUtil.getString(req, "categoriesStyle",
				StringPool.BLANK);
		
		String styleSelected = ParamUtil.getString(req, "styleMenu_", "1");

		String selectPortletLayout = ParamUtil.getString(req,
				"selectPortletLayout", StringPool.BLANK);

		String portletSelectId = ParamUtil.getString(req, "portletSelectId",
				StringPool.BLANK);

		String strPortletIds = ParamUtil.getString(req, "strPortletIds",
				StringPool.BLANK);

		String layoutPortletId = ParamUtil.getString(req, "layoutPortletId",
				StringPool.BLANK);
		String styleBorder = ParamUtil.getString(req, "styleBorder",
				StringPool.BLANK);
		String styleBullet = ParamUtil.getString(req, "styleBullet",
				StringPool.BLANK);
		String styleTitle = ParamUtil.getString(req, "styleTitle",
				StringPool.BLANK);
		String styleContent = ParamUtil.getString(req, "styleContent",
				StringPool.BLANK);
		boolean checkedAllCat = ParamUtil.getBoolean(req, "checkboxAll");

		// Save these settings to preferences
		PortletPreferences prefs = req.getPreferences();

		prefs
				.setValue(ConstantsExt.DISPLAY_STYLE, String
						.valueOf(displayStyle));

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_CATEGORIES, categories);
		
		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_CATEGORIES_STYLE, categoriesStyle);

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_STYLEDISPLAY, styleSelected);

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_CHECKALLCAT, String
				.valueOf(checkedAllCat));

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLETLAYOUT,
				String.valueOf(selectPortletLayout));

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLET_ID,
				String.valueOf(portletSelectId));

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLET_IDS,
				String.valueOf(strPortletIds));

		prefs.setValue(
				PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_LAYOUT_PORTLET_ID,
				String.valueOf(layoutPortletId));
		prefs.setValue("portionId",portionId);
		prefs.setValue("styleBorder",styleBorder);
		prefs.setValue("styleBullet",styleBullet);
		prefs.setValue("styleTitle",styleTitle);
		prefs.setValue("styleContent",styleContent);

		prefs.store();

		selectLayoutPortlet(req);
		/*sendRedirect(req, res);*/
	}

	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		// TODO Auto-generated method stub
		try{
			List selectLayouts = new ArrayList();
			LayoutPortletUtil.getLayoutPortletIds(selectLayouts ,renderRequest,"vcmsviewcontent_INSTANCE_");
			renderRequest.setAttribute("SELECT_LAYOUTS", selectLayouts);
			selectLayoutPortlet(renderRequest);
			}catch (Exception e) {
				// TODO: handle exception
			}
		return null;
	}

	private void selectLayoutPortlet(PortletRequest req) throws Exception {

		String cmd = ParamUtil.getString(req, "cmd");
		long layoutPlid = ParamUtil.getLong(req, "layoutIdSelected");

		List selectPortletLayoutIds = null;

		// StringBuffer strPortletIds = new StringBuffer();

		if (Validator.isNotNull(cmd) && cmd.equals("SELECT_LAYOUT")) {
			selectPortletLayoutIds = LayoutPortletUtil
					.getPortletIdsByLayout(layoutPlid);
		}

		req.setAttribute("SELECT_PORTLET_LAYOUT_IDS", selectPortletLayoutIds);

		req.setAttribute("PLID_LAYOUT", String.valueOf(layoutPlid));

		List selectLayouts = new ArrayList();

		LayoutPortletUtil.getLayoutPortletIds(selectLayouts, req,
				"vcmsviewcontent_INSTANCE_");

		req.setAttribute("SELECT_LAYOUTS", selectLayouts);
	}
}
