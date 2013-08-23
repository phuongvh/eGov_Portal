
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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class VDocContent extends MVCPortlet{

	@Override
	public void processEvent(EventRequest request, EventResponse response)
			throws PortletException, IOException {
		Event event = request.getEvent();
		String orgId = (String)event.getValue();
		String fieldId = (String) event.getValue();
		response.setRenderParameter("orgId", orgId);
		response.setRenderParameter("fieldId", fieldId);
	}
	
	public void viewVDoc(ActionRequest req, ActionResponse res) throws ReadOnlyException, ValidatorException, IOException{
		String title = ParamUtil.getString(req, "titlePortlet", StringPool.BLANK);
		String numberItem = ParamUtil.getString(req, "numberItem");
		
		PortletPreferences prefs = req.getPreferences();
		prefs.setValue("title", title);
		prefs.setValue("numberItem", numberItem);
		
		prefs.store();
		res.setRenderParameter("jspPage", "/html/portlet/vdocview/view.jsp");
	}
}
