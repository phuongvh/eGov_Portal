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

package com.vportal.portlet.vdoc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.vportal.portlet.vdoc.service.util.LayoutPortletUtil;

public class VDocMenu extends MVCPortlet {

	public void ipcVdoc(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		String orgId = actionRequest.getParameter("orgId");
		QName qName = new QName("http://liferay.com/events", "ipc.vdoc");
		actionResponse.setEvent(qName, orgId);
	}

	public void savePreferences(ActionRequest req, ActionResponse res)
			throws ReadOnlyException, ValidatorException, IOException {
		String title = ParamUtil.getString(req, "title", StringPool.BLANK);
		String url = ParamUtil.getString(req, "url");

		String fields = ParamUtil.getString(req, "fields", StringPool.BLANK);
		String orgs = ParamUtil.getString(req, "orgs", StringPool.BLANK);
		String orgsHN = ParamUtil.getString(req, "orgsHN", StringPool.BLANK);

		int styleDisplay = ParamUtil.getInteger(req, "styleDisplay");

		int documentPerPortlet = ParamUtil
				.getInteger(req, "documentPerPortlet");
		int period = ParamUtil.getInteger(req, "period");

		String selectPortletLayout = ParamUtil.getString(req,
				"selectPortletLayout", StringPool.BLANK);

		String portletSelectId = ParamUtil.getString(req, "portletSelectId",
				StringPool.BLANK);

		String strPortletIds = ParamUtil.getString(req, "strPortletIds",
				StringPool.BLANK);

		String layoutPortletId = ParamUtil.getString(req, "layoutPortletId",
				StringPool.BLANK);

		PortletPreferences prefs = req.getPreferences();
		prefs.setValue("selectPortletLayout",
				String.valueOf(selectPortletLayout));
		prefs.setValue("portletSelectId", String.valueOf(portletSelectId));
		prefs.setValue("strPortletIds", String.valueOf(strPortletIds));
		prefs.setValue("layoutPortletId", String.valueOf(layoutPortletId));
		prefs.setValue("title", title);
		prefs.setValue("url", url);
		prefs.setValue("fields", fields);
		prefs.setValue("orgs", orgs);
		prefs.setValue("orgsHN", orgsHN);
		prefs.setValue("styleDisplay", String.valueOf(styleDisplay));
		prefs.setValue("documentPerPortlet", String.valueOf(documentPerPortlet));
		prefs.setValue("period", String.valueOf(period));

		prefs.store();
		res.setRenderParameter("jspPage", "/html/portlet/vdocmenu/view.jsp");

	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		List selectLayouts = new ArrayList();

		try {
			LayoutPortletUtil.getLayoutPortletIds(selectLayouts, request,
					"vdocview_WAR_VDocportlet_INSTANCE_");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("SELECT_LAYOUTS", selectLayouts);

		// TODO Auto-generated method stub
		super.render(request, response);
	}

}
