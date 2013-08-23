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
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.vportal.portlet.vclip.util.LayoutPortletUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<jsp:directive.page import="com.vportal.portlet.vclip.util.WebKeysVClip"/>
<jsp:directive.page import="com.liferay.portal.model.Portlet"/>
<jsp:directive.page import="javax.portlet.PortletURL"/>
<%@page import="com.vportal.portal.model.Attachment"%>
<%@ page import="com.vportal.portlet.vclip.*"%>
<%@ page import="com.vportal.portlet.vclip.model.*"%>
<%@ page import="com.vportal.portlet.vclip.model.impl.*"%>
<%@ page import="com.vportal.portlet.vclip.service.*"%>
<%@ page import="com.vportal.portlet.vclip.*"%>
<%@ page import="com.liferay.portal.theme.*"%>
<%@ page import="com.liferay.portal.util.*"%>
<%@ page import="com.vportal.portal.model.*"%>
<%@ page import="com.vportal.portal.service.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Hashtable"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.vportal.portal.util.PortalUtilExt"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.vportal.portlet.viewvclip.util.ConstantsExt"%>
<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="java.util.ArrayList"/>
<jsp:directive.page import="com.liferay.portal.model.Portlet"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.WebKeys"/>
<jsp:directive.page import="javax.portlet.PortletURL"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.ParamUtil"/>
<jsp:directive.page import="com.liferay.portal.kernel.util.HttpUtil"/>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ include file="/html/portlet/init.jsp"%>
<portlet:defineObjects/>
<liferay-theme:defineObjects/>
<%
 	
	PortletPreferences prefs = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	if(Validator.isNotNull(portletResource)){
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	String portletSelectId = prefs.getValue("portletSelectId","");
	System.out.println("portletSelectId"+portletSelectId);
	String portletIds = prefs.getValue("portletIds","");
	String selectPortletLayout = prefs.getValue("selectPortletLayout","");	
	String titlePortlet = prefs.getValue("titlePortlet","Chuyên m&#7909;c");
	String language = ParamUtil.getString(request, "language", "vi_VN");
	List selectLayouts = (List)request.getAttribute("SELECT_LAYOUTS");
	String displayStyle1 = prefs.getValue("displayStyle","");
	String allowDescription = prefs.getValue("allowDescription","false");
	String allowDownload = prefs.getValue("allowDownload","false");
	String displayClipNumber = prefs.getValue("displayClipNumber","9");	
	String layoutPortletId = prefs.getValue("layoutPortletId","");
	if(portletSelectId.equals("")){
	List ListportletSelectId = LayoutPortletUtil.getPortletIdsByLayout(Long.valueOf(plid));
	if(ListportletSelectId.size()>0){
	portletSelectId = (String)ListportletSelectId.get(0);}
	}


%>	

<%
 	
 	if (Validator.isNotNull(portletResource)) {
 	        prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
 	}	
// 	if(portletResource.equals("")){
//  		List ListportletSelectId = LayoutPortletUtil.getPortletIdsByLayout(Long.valueOf(plid));
//  		portletResource = (String)ListportletSelectId.get(0);
//  		}
 	
 	String[] selectCategories = prefs.getValues("selectCategories",null);	
 	
 	String _category = prefs.getValue("_category","");
	String widthSize = prefs.getValue("widthSize","190");
 	String heightSize = prefs.getValue("heightSize","180");
 	String defaultSize = prefs.getValue("defaultSize","0");
 	long openNewTab = 0; //(Long)request.getAttribute(ConstantsExt.OPEN_NEW_TAB);
 	String receivedPortletId = "vclipcontent_WAR_vclipportlet";
 	String receivedPortletAction = "/html/portlet/vclipcontent/view.jsp";
 	long groupId1 = portletGroupId;
 	long currentPlid1 = PortalUtilExt.getPlid(request);
 	long plId1 = 0;
 	try{
 		plId1 = PortalUtilExt.getPlid(groupId1, currentPlid1, receivedPortletId);
 	}
 	catch(Exception ex){
 		
 	}
 %>
