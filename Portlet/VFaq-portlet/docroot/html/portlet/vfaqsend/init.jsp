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

<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@ page import="com.vportal.portlet.vfaq.*" %>
<%@ page import="com.vportal.portlet.vfaq.model.*" %>
<%@ page import="com.vportal.portlet.vfaq.action.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.impl.*" %>
<%@ page import="com.vportal.portlet.vfaq.util.*" %>
<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@page import="com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.vfaq.model.FAQQuestion"%>
<%@page import="com.vportal.portlet.vfaq.util.WebKeysEDDepartment"%>
<%@ page import="java.util.GregorianCalendar" %>

<%
PortletPreferences prefs = renderRequest.getPreferences(); 	
String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String titleQuestion="";
titleQuestion = prefs.getValue("titleQuestion","");
String titlePortlet = prefs.getValue("titlePortlet","G&#7917;i câu h&#7887;i");
String themeType = prefs.getValue("themeType","2");	


String language = ParamUtil.getString(request, "language", "vi_VN");
long groupId = ParamUtil.getLong(request, "groupId",0);
if(groupId == 0){
	groupId = portletGroupId.longValue();
}

%>