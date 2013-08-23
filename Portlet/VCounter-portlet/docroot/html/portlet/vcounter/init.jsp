<%--
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
--%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>	
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="com.vportal.portal.service.persistence.*" %>
<%@ page import="com.vportal.portal.service.impl.*" %>
<%@ page import="java.util.*" %>
<%
 	PortletPreferences prefs = renderRequest.getPreferences();
 	
 	String portletResource = ParamUtil.getString(request, "portletResource");
 	
 	if (Validator.isNotNull(portletResource)) {
 	        prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
 	}
 	
 	long groupId = ParamUtil.getLong(request, "groupId",0);
	if(groupId == 0){
		groupId = portletGroupId.longValue();
	}
 	
 	String style = prefs.getValue("style", "1");
 	long companyId = PortalUtil.getCompanyId(request);	
			
	String titlePortlet = prefs.getValue("titlePortlet","Th&#7889;ng kê");
	

%>	