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
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<%@ page import="com.vportal.portlet.vcms.*" %>
<%@ page import="com.vportal.portlet.vcms.model.*" %>
<%@ page import="com.vportal.portlet.vcms.action.*" %>
<%@ page import="com.vportal.portlet.vcms.service.*" %>
<%@ page import="com.vportal.portlet.vcms.service.impl.*" %>
<%@ page import="com.vportal.portlet.vcms.service.permission.*" %>
<%@ page import="com.vportal.portlet.vcms.job.*" %>
<%@ page import="com.vportal.portlet.vcms.util.*" %>
<%@ page import="com.vportal.portlet.vcmsviewcontent.util.*" %>	
<%@ page import="com.vportal.portlet.vcmsviewnews.action.*" %>
		
<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="com.vportal.portlet.vcmsmenu.action.*" %>	
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ include file="/html/portlet/vcmsviewnews/css.jsp"%>   

<%
PortletPreferences prefs = renderRequest.getPreferences();

DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
String language = ParamUtil.getString(request, "language", "vi_VN");

long groupId = ParamUtil.getLong(request, "groupId",0);
if(groupId == 0){
	groupId = portletGroupId.longValue();
}
String portionId = prefs.getValue("portionId","");
String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

	String categories = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_CATEGORIES,"");
	
	String styleDisplayed = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_STYLEDISPLAY,"1");
	
	String portletSelectId = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLET_ID,"");

	String portletIds = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLET_IDS,"");
	
	String selectPortletLayout = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_PORTLETLAYOUT,"");
	
	String layoutPortletId = prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_TYPE_SELECT_LAYOUT_PORTLET_ID,"");
	
	
	String stickyportletSelectId = prefs.getValue(PropsUtilExt.VCMS_VIEW_STICKY_TYPE_SELECT_PORTLET_ID,"");

	String stickyportletIds = prefs.getValue(PropsUtilExt.VCMS_VIEW_STICKY_TYPE_SELECT_PORTLET_IDS,"");
	
	String selectStickyPortletLayout = prefs.getValue(PropsUtilExt.VCMS_VIEW_STICKY_TYPE_SELECT_PORTLETLAYOUT,"");
	
	String layoutStickyPortletId = prefs.getValue(PropsUtilExt.VCMS_VIEW_STICKY_TYPE_SELECT_LAYOUT_PORTLET_ID,"");
	
	
	
	Boolean isCheckedAllCats =  GetterUtil.getBoolean(prefs.getValue(PropsUtilExt.VCMS_VIEW_MENU_CHECKALLCAT,""),true);
	
	int numberNextArticle = GetterUtil.getInteger(prefs.getValue(PropsUtilExt.VCMS_VIEW_NEWS_NEXT_ARTICLES,"5"),5);
		
	List selectLayouts = (List)request.getAttribute("SELECT_LAYOUTS");
		
	long currentPlid = PortalUtilExt.getPlid(request);

	long plId = 0;
	long plStickyId = 0;
	
	
		try{
			if(Validator.isNotNull(selectPortletLayout) && selectPortletLayout.equals("1")){
				//Automatically find layout & portlet id
				
				Layout firstLayout = (Layout)selectLayouts.get(0);
				long firstLayoutId = firstLayout.getPlid();
				
				String firstPortletId = LayoutPortletUtil.getPortletIdsByLayout(firstLayoutId).get(0).toString();
				
				plId = PortalUtilExt.getPlid(groupId, currentPlid, firstPortletId);
				plStickyId = PortalUtilExt.getPlid(groupId, currentPlid, firstPortletId);
				portletSelectId = firstPortletId;
				stickyportletSelectId = firstPortletId;
				
			}else{
				plId = PortalUtilExt.getPlid(groupId, currentPlid, portletSelectId);
				plStickyId = PortalUtilExt.getPlid(groupId, currentPlid, stickyportletSelectId);
			}
		}catch(Exception ex){
		}

	//in some where in your jsp code:
	
	PortletURL categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
	categoryURL.setParameter("struts_action", "/vcmsviewcontent/view");
	categoryURL.setParameter("categoriesSelectedCats", categories);
	categoryURL.setParameter("groupId", String.valueOf(groupId));
	categoryURL.setParameter("language", language);
	categoryURL.setWindowState(WindowState.NORMAL);
	
	String parentId = (String)session.getAttribute("CAT_PARENT_ID");
	String categoryId = (String)session.getAttribute("CATEGORY_ID");
	
%>
