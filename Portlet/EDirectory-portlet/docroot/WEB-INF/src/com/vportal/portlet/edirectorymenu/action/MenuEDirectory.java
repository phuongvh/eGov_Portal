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
package com.vportal.portlet.edirectorymenu.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.edirectory.util.ConstantKeysUtil;
import com.vportal.portlet.edirectory.util.LayoutPortletUtil;

/**
 * Portlet implementation class MenuEDirectory
 */
public class MenuEDirectory extends MVCPortlet {

	@Override
	public void processAction(ActionRequest req, ActionResponse res)
			throws IOException, PortletException {
		// TODO Auto-generated method stub

		try {

			String selectPortletLayout = ParamUtil.getString(req,
					"selectPortletLayout", StringPool.BLANK);

			String portletSelectId = ParamUtil.getString(req,
					"portletSelectId", StringPool.BLANK);

			String strPortletIds = ParamUtil.getString(req, "strPortletIds",
					StringPool.BLANK);

			String layoutPortletId = ParamUtil.getString(req,
					"layoutPortletId", StringPool.BLANK);

			String themeType = ParamUtil.getString(req, "themeType");
			String themeSelected = ParamUtil.getString(req, "themeSelected");
			String titlePortlet = ParamUtil.getString(req, "titlePortlet");
			boolean isBorder = ParamUtil.getBoolean(req, "isBorder");
			String bgcolor = ParamUtil.getString(req, "bgcolor");

			int paddingLeft = ParamUtil.getInteger(req, "paddingLeft");
			int paddingRight = ParamUtil.getInteger(req, "paddingRight");

			PortletPreferences prefs = req.getPreferences();

			prefs.setValue("paddingLeft", String.valueOf(paddingLeft));
			prefs.setValue("paddingRight", String.valueOf(paddingRight));

			prefs.setValue("themeSelected", themeSelected);
			prefs.setValue("bgcolor", bgcolor);
			prefs.setValue("isBorder", String.valueOf(isBorder));
			prefs.setValue("titlePortlet", titlePortlet);
			prefs.setValue("themeType", themeType);

			prefs.setValue("selectPortletLayout",
					String.valueOf(selectPortletLayout));
			prefs.setValue("portletSelectId", String.valueOf(portletSelectId));
			prefs.setValue("strPortletIds", String.valueOf(strPortletIds));
			prefs.setValue("layoutPortletId", String.valueOf(layoutPortletId));

			prefs.store();
			selectLayoutPortlet(req, res);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void render(RenderRequest req, RenderResponse res)
			throws PortletException, IOException {
		List selectLayouts = new ArrayList();

		try {
			LayoutPortletUtil.getLayoutPortletIds(selectLayouts, req,
					"EDirectoryView_WAR_EDirectoryportlet");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("SELECT_LAYOUTS", selectLayouts);
		super.render(req, res);
	}

	public void selectLayoutPortlet(PortletRequest req, ActionResponse res)
			throws Exception {

		String cmd = ParamUtil.getString(req, "cmd");
		long layoutPlid = ParamUtil.getLong(req, "layoutIdSelected");

		List selectPortletLayoutIds = null;

		if (Validator.isNotNull(cmd) && cmd.equals("SELECT_LAYOUT")) {
			selectPortletLayoutIds = LayoutPortletUtil
					.getPortletIdsByLayout(layoutPlid);
		}

		req.setAttribute("SELECT_PORTLET_LAYOUT_IDS", selectPortletLayoutIds);

		req.setAttribute("PLID_LAYOUT", String.valueOf(layoutPlid));

		List selectLayouts = new ArrayList();

		LayoutPortletUtil.getLayoutPortletIds(selectLayouts, req,
				"EDirectoryView_WAR_EDirectoryportlet");

		req.setAttribute("SELECT_LAYOUTS", selectLayouts);
	}

	public PortletURL getCategoryURL(HttpServletRequest request,
			String portletSelectId, long plId, String RENDER_PHASE)
			throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		Class cl1 = PortalClassLoaderUtil.getClassLoader().loadClass(
				"com.liferay.portlet.PortletURLImpl");
		Class[] intArgsClass = new Class[] { HttpServletRequest.class,
				String.class, long.class, String.class };
		java.lang.reflect.Constructor constructor = cl1
				.getConstructor(intArgsClass);
		PortletURL categoryURL = (PortletURL) constructor
				.newInstance(new Object[] { request, portletSelectId, plId,
						RENDER_PHASE });
		return categoryURL;
	}
}
