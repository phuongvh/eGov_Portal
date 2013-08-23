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
<jsp:directive.page import="com.vportal.portal.util.WebKeysExt"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
<jsp:directive.page import="com.liferay.portal.theme.ThemeDisplay"/>
<jsp:directive.page import="java.util.Locale"/>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="com.liferay.portal.kernel.language.LanguageUtil"/>
<jsp:directive.page import="javax.portlet.PortletURL"/>
<jsp:directive.page import="com.vportal.portlet.vclip.util.*"/>
<jsp:directive.page import="javax.portlet.WindowState"/>

<jsp:directive.page import="com.liferay.portal.kernel.util.*"/>

<jsp:directive.page import="com.vportal.portlet.vclip.service.*"/>
<jsp:directive.page import="com.vportal.portlet.vclip.model.*"/>
<jsp:directive.page import="com.vportal.portlet.vclip.model.impl.*"/>
<jsp:directive.page import="java.util.ArrayList"/>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jstl/xml_rt" prefix="x" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.portlet.polls.model.*" %>
<%@ page import="com.liferay.portlet.polls.service.*" %>
<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.kernel.security.permission.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="com.vportal.portlet.vclip.service.*" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>

<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.portal.service.*" %>
<%@ page import="com.liferay.portal.service.permission.GroupPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.LayoutPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%

WindowState windowState = null;
PortletMode portletMode = null;

PortletURL currentURLObj = null;

if (renderRequest != null) {
	windowState = renderRequest.getWindowState();
	portletMode = renderRequest.getPortletMode();

	currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
}
else if (resourceRequest != null) {
	windowState = resourceRequest.getWindowState();
	portletMode = resourceRequest.getPortletMode();

	//currentURLObj = PortletURLUtil.getCurrent(resourceRequest, resourceResponse);
}

//String currentURL = currentURLObj.toString();
String currentURL = PortalUtil.getCurrentURL(request);
%>

<%
boolean showTabs = false;
boolean showButtons = false;
if (portletConfig.getPortletName().equals("vclip")) {
	showTabs = true;
	showButtons = true;
}
%>

<%
	Locale[] locales = LanguageUtil.getAvailableLocales();
	String language = ParamUtil.getString(request, "language", "vi_VN");

	String tabs1 = ParamUtil.getString(request, "tabs1","vportal.vclip.clip");
	PortletURL portletURL = renderResponse.createRenderURL();
	
	String idName=WebKeysVClip.CLIP_TYPE_ID;
	
	if(tabs1.equalsIgnoreCase("Clip")){
		idName=WebKeysVClip.CLIP_ID;
		portletURL.setParameter("struts_action","/vclip/clip");
	}else{
		idName=WebKeysVClip.CLIP_TYPE_ID;
		portletURL.setParameter("struts_action","/vclip/cliptype");
	}	
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("tabs1", tabs1);
	
	SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");

	String tab1Names="vportal.vclip.clip,vportal.vclip.clipType";	
%>
<script language="javascript">
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
</script>