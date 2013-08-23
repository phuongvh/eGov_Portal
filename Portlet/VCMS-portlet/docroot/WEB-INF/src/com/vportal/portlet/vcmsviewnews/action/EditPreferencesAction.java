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

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portal.util.PropsUtilExt;
import com.vportal.portlet.vcmsviewcontent.util.LayoutPortletUtil;

/**
 * 
 * @author donghh
 * @version 1.0.00, Jun 23, 2008
 */

public class EditPreferencesAction extends MVCPortlet {

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {

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

		selectLayoutPortlet(req);
/*
		sendRedirect(req, res);*/
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		selectLayoutPortlet(req);		
		return mapping.findForward("vportlet.vcmsviewnews.editviewnews");
		
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