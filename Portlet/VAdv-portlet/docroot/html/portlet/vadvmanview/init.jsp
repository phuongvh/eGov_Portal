<%--/**
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
 */ --%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ include file="/html/portlet/init.jsp" %>
<%@ include file="css.jsp"%>
<%@ page import="com.vportal.portlet.vadvman.*" %>
<%@ page import="com.vportal.portlet.vadvman.model.*" %>
<%@ page import="com.vportal.portlet.vadvman.model.impl.*" %>
<%@ page import="com.vportal.portlet.vadvman.action.*" %>
<%@ page import="com.vportal.portlet.vadvman.service.*" %>
<%@ page import="com.vportal.portlet.vadvman.service.impl.*" %>
<%@ page import="com.vportal.portlet.vadvman.service.permission.*" %>
<%@ page import="com.vportal.portlet.vadvman.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="java.util.*" %>
	
<%@ page import="com.liferay.portlet.documentlibrary.*" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.*" %>
<%@ page import="com.liferay.portlet.documentlibrary.util.*" %>	

	
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String portletResource = ParamUtil.getString(request, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String styleBorder = prefs.getValue("styleBorder","");
	String styleBullet = prefs.getValue("styleBullet","");
	String styleTitle = prefs.getValue("styleTitle","");
	String styleContent = prefs.getValue("styleContent","");
	 
	String themeType = prefs.getValue("themeType","1");
	String themeSelected = prefs.getValue("themeSelected",""); 
	
	boolean isBorder = GetterUtil.getBoolean(prefs.getValue("isBorder",""), false);
	String bgcolor = prefs.getValue("bgcolor","#ffffff");
	int paddingLeft = GetterUtil.getInteger(prefs.getValue("paddingLeft",""),0);
	int paddingRight = GetterUtil.getInteger(prefs.getValue("paddingRight",""),0);
%>