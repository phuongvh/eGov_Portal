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
<%
/**
 * Copyright (c) 2000-2008 VietSoftware, Inc. All rights reserved.
 */
%>

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.vportal.portlet.vcms.*" %>
<%@ page import="com.vportal.portlet.vcms.model.*" %>
<%@ page import="com.vportal.portlet.vcms.action.*" %>
<%@ page import="com.vportal.portlet.vcms.service.*" %>
<%@ page import="com.vportal.portlet.vcms.service.impl.*" %>
<%@ page import="com.vportal.portlet.vcms.service.permission.*" %>
<%@ page import="com.vportal.portlet.vcms.job.*" %>
<%@ page import="com.vportal.portlet.vcms.util.*" %>
<%@ page import="com.vportal.portlet.vcmsviewcontent.util.*" %>	
<%@ page import="com.vportal.portlet.vcmsmenu.action.*" %>
	
		
<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>  


<%
PortletPreferences prefs = renderRequest.getPreferences();
DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
//String language = ParamUtil.getString(request, "language", "vi_VN");
String language = LanguageUtil.getLanguageId(request);

long groupId = ParamUtil.getLong(request, "groupId",0);
if(groupId == 0){
	groupId = portletGroupId.longValue();
}

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}


	String categories = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_CATEGORIES,"");
	
	String categoriesStyle = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_CATEGORIES_STYLE,"");
	
	String styleDisplayed = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_STYLEDISPLAY,"1");
	
	String portletSelectId = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLET_ID,"");

	String portletIds = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLET_IDS,"");
	
	String selectPortletLayout = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLETLAYOUT,"");
	
	String layoutPortletId = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_LAYOUT_PORTLET_ID,"");
	String styleBorder = prefs.getValue("styleBorder","");
	//String styleBullet = prefs.getValue("styleBullet","");
	String styleTitle = prefs.getValue("styleTitle","");
	String portionId = prefs.getValue("portionId","");
	//String styleContent = prefs.getValue("styleContent","");
	Boolean isCheckedAllCats =  GetterUtil.getBoolean(prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_CHECKALLCAT,""),true);
	
	List selectLayouts = (List)request.getAttribute("SELECT_LAYOUTS");
		
	long currentPlid = PortalUtilExt.getPlid(request);

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
		}
	String parentId = (String)session.getAttribute("CAT_PARENT_ID");
	String categoryId = (String)session.getAttribute("CATEGORY_ID");	
%>