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
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@include file="/html/init.jsp" %> 

<link href="/html/portlet/edirectoryview/css/common.css" rel="stylesheet" type="text/css" />
<%
	//String language = ParamUtil.getString(request, "language", "vi_VN");
	//long groupId = themeDisplay.getPortletGroupId();
	long _parentId = 0;
	
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String titlePortlet = prefs.getValue("titlePortlet", "Danh b&#7841; &#273;i&#7879;n t&#7917;");
	String themeType = prefs.getValue("themeType","1");
	String themeSelected = prefs.getValue("themeSelected","");
	int numberItem = GetterUtil.getInteger(prefs.getValue("numberItem",""), 10);
	
	boolean showPortletBorders = GetterUtil.getBoolean(prefs.getValue("show-portlet-borders", "true"));	
%>