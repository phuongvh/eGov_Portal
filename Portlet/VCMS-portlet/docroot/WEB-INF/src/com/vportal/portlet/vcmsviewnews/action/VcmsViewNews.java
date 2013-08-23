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

package com.vportal.portlet.vcmsviewnews.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.util.PropsUtilExt;
import com.vportal.portlet.vcmsviewcontent.util.LayoutPortletUtil;

/**
 * Portlet implementation class VcmsViewContent
 */
public class VcmsViewNews extends MVCPortlet {

	@Override
	public void processAction(ActionRequest req,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String selectPortletLayout = ParamUtil.getString(req,
				"selectPortletLayout", StringPool.BLANK);

		String portletSelectId = ParamUtil.getString(req, "portletSelectId",
				StringPool.BLANK);

		String strPortletIds = ParamUtil.getString(req, "strPortletIds",
				StringPool.BLANK);

		String layoutPortletId = ParamUtil.getString(req, "layoutPortletId",
				StringPool.BLANK);
		String portionId = ParamUtil.getString(req, "portionId",
				StringPool.BLANK);
		int numberNextArticle = ParamUtil.getInteger(req, "numberNextArticle" , 5);


		// Save these settings to preferences
		PortletPreferences prefs = req.getPreferences();

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLETLAYOUT,
				String.valueOf(selectPortletLayout));

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLET_ID,
				String.valueOf(portletSelectId));

		prefs.setValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLET_IDS,
				String.valueOf(strPortletIds));

		prefs.setValue(
				PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_LAYOUT_PORTLET_ID,
				String.valueOf(layoutPortletId));
		
		prefs.setValue(PropsUtilExt.VCMS_VIEW_NEWS_NEXT_ARTICLES,
				String.valueOf(numberNextArticle));
		prefs.setValue("portionId",portionId);

		prefs.store();

		try {
			selectLayoutPortlet(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.processAction(req, actionResponse);
	}
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		List selectLayouts = new ArrayList();
		
		try {
			LayoutPortletUtil.getLayoutPortletIds(selectLayouts ,request,"vcmsviewcontent_WAR_VCMSportlet_INSTANCE_");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("SELECT_LAYOUTS", selectLayouts);
		
		super.render(request, response);
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
				"vcmsviewcontent_WAR_VCMSportlet_INSTANCE_");

		req.setAttribute("SELECT_LAYOUTS", selectLayouts);
	}
}
