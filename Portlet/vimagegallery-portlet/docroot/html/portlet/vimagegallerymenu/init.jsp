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

<%@page import="com.liferay.portal.service.PortletLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.PortletLocalService"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@ page import="com.vportal.portlet.vimagegallery.*"%>
<%@ page import="com.vportal.portlet.vimagegallery.model.*"%>
<%@ page import="com.vportal.portlet.vimagegallery.model.impl.*"%>
<%@ page import="com.vportal.portlet.vimagegallery.service.*"%>
<%@ page import="com.vportal.portlet.vimagegallerymenu.*"%>	

<%@ page import="com.liferay.portal.theme.*"%>
<%@ page import="com.liferay.portal.util.*"%>
<%@ page import="com.vportal.portal.model.*"%>
<%@ page import="com.vportal.portal.service.*"%>

<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.vportal.portlet.vimagegallerymenu.util.LayoutPortletUtil" %>
<%@ page import="com.vportal.portlet.vimagegallery.model.TFCategory" %>
<%@ page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil" %>
	
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>	

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
		
	
	String language = ParamUtil.getString(request, "language", "vi_VN");
	 	
 	String style = prefs.getValue("style", "3");
 	
 	String[] selectCategories = prefs.getValues("selectCategories",null); 
 	
 	String url = prefs.getValue("url","");
 	
 	String _category = prefs.getValue("_category","");
 	
 	String portletSelectId = prefs.getValue("portletSelectId","");

	String portletIds = prefs.getValue("portletIds","");
	
	
	String selectPortletLayout = prefs.getValue("selectPortletLayout","");
	
	String layoutPortletId = prefs.getValue("layoutPortletId","");
	
	List selectLayouts = (List)request.getAttribute("SELECT_LAYOUTS");
// 	List selectLayouts = LayoutLocalServiceUtil.getLayouts(groupId, false);
	
	long currentPlid = PortalUtilExt.getPlid(request);	
	
	boolean isBorder = GetterUtil.getBoolean(prefs.getValue("isBorder",""), false);
	
	String themeType = prefs.getValue("themeType","3");
	String themeSelected = prefs.getValue("themeSelected","");
	String title = prefs.getValue("title","Chuyên m&#7909;c &#7843;nh");
	
	int paddingLeft = GetterUtil.getInteger(prefs.getValue("paddingLeft",""),4);
	int paddingRight = GetterUtil.getInteger(prefs.getValue("paddingRight",""),4);
	
	long plId = 0;
	try{
		if(Validator.isNotNull(selectPortletLayout) && selectPortletLayout.equals("1")){
			//Automatically find layout & portlet id
			
			Layout firstLayout = (Layout)selectLayouts.get(0);
			long firstLayoutId = firstLayout.getPlid();
			String firstPortletId = LayoutPortletUtil.getPortletIdsByLayout(firstLayoutId).get(0).toString();
			
			plId = PortalUtilExt.getPlid(groupId, currentPlid, firstPortletId);
			
			portletSelectId = firstPortletId;
			
		}else{
			//System.out.println("firstPortletId");
			plId = PortalUtilExt.getPlid(groupId, currentPlid, portletSelectId);
		}
	}catch(Exception ex){
		System.out.println(ex.toString());
	}
%>
