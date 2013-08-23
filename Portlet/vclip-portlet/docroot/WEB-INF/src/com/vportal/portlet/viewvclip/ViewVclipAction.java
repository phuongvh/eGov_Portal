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
package com.vportal.portlet.viewvclip;

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

import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.vclip.model.Clip;
import com.vportal.portlet.vclip.model.ClipType;
import com.vportal.portlet.vclip.model.impl.ClipTypeImpl;
import com.vportal.portlet.vclip.service.ClipServiceUtil;
import com.vportal.portlet.vclip.service.ClipTypeServiceUtil;
import com.vportal.portlet.vclip.util.LayoutPortletUtil;
import com.vportal.portlet.vclip.util.WebKeysVClip;
import com.vportal.portlet.viewvclip.util.ConstantsExt;

/**
 * Portlet implementation class ViewVclipAction
 */
public class ViewVclipAction extends MVCPortlet {

	@Override
	public void processAction(ActionRequest req, ActionResponse res)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		String cmd = ParamUtil.getString(req, Constants.CMD);
		String id = ParamUtil.getString(req, "clipId");
		try {
			if (cmd.equals(ConstantsExt.HITCOUNT)) {
				ClipServiceUtil.increaseHitCount(id);
			}
			if (cmd.equals(ConstantsExt.HITCOUNTVIEW)) {
				ClipServiceUtil.increaseHitCountView(id);
			}
		} catch (Exception ex) {

		}

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
			// SessionMessages.add(req, config.getPortletName() + ".doEdit");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		super.processAction(req, res);
	}

	@Override
	public void render(RenderRequest req, RenderResponse res)
			throws PortletException, IOException {
		// TODO Auto-generated method stub

		PortletPreferences prefs = req.getPreferences();
		try {
			List listCategory = ClipTypeServiceUtil.findAll();
			List listTopClip = ClipServiceUtil.getAll(0, 5);
			req.setAttribute(WebKeysVClip.CLIP_TYPE_RESULT_SEARCH, listCategory);

			String obj = ParamUtil.getString(req, WebKeysVClip.OBJECT);

			if (obj.equals(ClipType.class.getName())) {
				String clipTypeId = ParamUtil.getString(req,
						WebKeysVClip.CLIP_TYPE_ID);
				ClipType tfCategory = new ClipTypeImpl();
				if (Validator.isNotNull(Long.valueOf(clipTypeId))) {
					tfCategory = ClipTypeServiceUtil.findById(clipTypeId);
				}
				req.setAttribute("tfCategory", tfCategory);

				Clip clipFirst = ClipServiceUtil.getByClipTypeId(clipTypeId);
				req.setAttribute(WebKeysVClip.CLIP, clipFirst);

			} else {
				Clip clipSecond = ClipServiceUtil.getFirst();
				req.setAttribute(WebKeysVClip.CLIP, clipSecond);
				req.setAttribute(WebKeysVClip.LIST_TOP_CLIP, listTopClip);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		List selectLayouts = new ArrayList();

		try {
			LayoutPortletUtil.getLayoutPortletIds(selectLayouts, req,
					"vclipcontent_WAR_vclipportlet_INSTANCE_");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("SELECT_LAYOUTS", selectLayouts);

		super.render(req, res);
	}

	public void EditPreferenceAction(ActionRequest req, ActionResponse res) {
		String cmd = ParamUtil.getString(req, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		PortletPreferences prefs = req.getPreferences();
		int displayStyle = ParamUtil.getInteger(req, "displayStyle");
		// String styleSelected = ParamUtil.getString(req, "displayStyle","1");
		String[] selectCategories = req.getParameterValues("selectCategories");
		String defaultSize = ParamUtil.getString(req, "defaultSize");
		String widthSize = ParamUtil.getString(req, "widthSize");
		String heightSize = ParamUtil.getString(req, "heightSize");
		try {
			prefs.setValues("selectCategories", selectCategories);
			prefs.setValue("displayStyleExt", String.valueOf(displayStyle));
			prefs.setValue("defaultSize", defaultSize);
			prefs.setValue("widthSize", widthSize);
			prefs.setValue("heightSize", heightSize);

			prefs.store();
			res.setRenderParameter("jspPage",
					"/html/portlet/view_vclip/view.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}

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
				"vclipcontent_WAR_vclipportlet_INSTANCE_");

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
