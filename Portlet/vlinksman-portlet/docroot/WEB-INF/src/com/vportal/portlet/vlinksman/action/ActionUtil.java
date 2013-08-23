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

package com.vportal.portlet.vlinksman.action;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.vportal.portlet.vlinksman.model.LinkGroup;
import com.vportal.portlet.vlinksman.model.Links;
import com.vportal.portlet.vlinksman.service.LinkGroupServiceUtil;
import com.vportal.portlet.vlinksman.service.LinksServiceUtil;

public class ActionUtil  {
	
	public static void getLinkGroup(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getLinkGroup(httpReq);
	}

	public static void getLinkGroup(RenderRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
		
		getLinkGroup(httpReq);
	}
	
	public static void getLinkGroup(HttpServletRequest req) throws Exception {

		long Id = ParamUtil.getLong(req, "Id");

		LinkGroup linkGroup = null;

		if (Id > 0) {
			linkGroup = LinkGroupServiceUtil.getLinkGroup(Id);
		}
		req.setAttribute("linkGroup", linkGroup);
	}

	public static void getLinks(ActionRequest req) throws Exception {
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);

		getLinks(httpReq);
	}

	public static void getLinks(RenderRequest req) throws Exception {

		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(req);
	}

	public static void getLinks(HttpServletRequest req) throws Exception {

		long linkId = ParamUtil.getLong(req, "linkId");

		Links link = null;

		if (linkId > 0) {

			link = LinksServiceUtil.getLinks(linkId);
		}

		req.setAttribute("link", link);
	}
}
