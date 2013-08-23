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

<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ include file="/html/portlet/init.jsp"%>

<%@page import="com.vportal.portal.util.PortalUtilExt"%>
<%@ page import="com.vportal.portlet.vfaq.*" %>
<%@ page import="com.vportal.portlet.vfaq.model.*" %>
<%@ page import="com.vportal.portlet.vfaq.action.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.impl.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.permission.*" %>
<%@ page import="com.vportal.portlet.vfaq.util.*" %>
	
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="java.util.ArrayList"/>
<jsp:directive.page import="com.liferay.portal.model.Portlet"/>
<jsp:directive.page import="javax.portlet.PortletURL"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.ParamUtil"/>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<link href="/html/portlet/vfaqmenu/css/vfaq.css" rel="stylesheet" type="text/css" />
	
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource"); 	
 	if (Validator.isNotNull(portletResource)) {
 	        prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
 	}
 	
 	
	String portletSelectId = prefs.getValue("portletSelectId","");

	String portletIds = prefs.getValue("portletIds","");
	
	String selectPortletLayout = prefs.getValue("selectPortletLayout","");
	
	String layoutPortletId = prefs.getValue("layoutPortletId","");
	
	List selectLayouts = (List)request.getAttribute("SELECT_LAYOUTS");
	
	long currentPlid = PortalUtilExt.getPlid(request);	
 	
 	long groupId = ParamUtil.getLong(request, "groupId",0);
	if(groupId == 0){
		groupId = portletGroupId.longValue();
	}

	String language = ParamUtil.getString(request, "language", "vi_VN");
	
	boolean isBorder = GetterUtil.getBoolean(prefs.getValue("isBorder",""), false);
	String bgcolor = prefs.getValue("bgcolor","#ffffff");
	String titlePortlet = prefs.getValue("titlePortlet","Chuyên m&#7909;c");
	String themeType = prefs.getValue("themeType","1");
	String themeSelected = prefs.getValue("themeSelected","");
	
	int paddingLeft = GetterUtil.getInteger(prefs.getValue("paddingLeft",""),4);
	int paddingRight = GetterUtil.getInteger(prefs.getValue("paddingRight",""),4);
	
	long plId = 0;
	try{
		if(Validator.isNotNull(selectPortletLayout) && selectPortletLayout.equals("1")){
			
			Layout firstLayout = (Layout)selectLayouts.get(0);
			long firstLayoutId = firstLayout.getPlid();
			
			String firstPortletId = LayoutPortletUtil.getPortletIdsByLayout(firstLayoutId).get(0).toString();
			
			plId = PortalUtilExt.getPlid(groupId, currentPlid, firstPortletId);
			
			portletSelectId = firstPortletId;
			
		}else{
			/* System.out.println("firstPortletId"); */
			plId = PortalUtilExt.getPlid(groupId, currentPlid, portletSelectId);
		}
	}catch(Exception ex){
		System.out.println(ex.toString());
	}
%>	
