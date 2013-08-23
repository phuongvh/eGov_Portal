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
<%@ page import="com.vportal.portlet.vcms.job.*" %>
<%@ page import="com.vportal.portlet.vcms.util.*" %>
<%@ page import="com.vportal.portlet.vcmsviewcontent.util.*" %>	

<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="com.vportal.portlet.vcms.model.VcmsPortion" %>
<%@ page import="com.vportal.portlet.vcmsview.util.ConstantsExt" %>	
<%@ page import="com.vportal.portlet.vcmsmenu.action.ActionUtilMenu" %>	
<%@ page import="com.vportal.portal.util.PortalUtilExt" %>	
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>  


<%@ page import="java.util.*" %>


<%

DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);

//hoan
String language = themeDisplay.getLanguageId();
//hoan

PortletPreferences prefs = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String categories = prefs.getValue(ConstantsExt.IS_DISPLAY_DEFAULT_CATEGORY,"");
String layoutPortletId = prefs.getValue(ConstantsExt.LAYOUT_PORTLET_ID,"");
/* out.println("ttttttttttttttttttttttttttt"+layoutPortletId); */
String portletSelectId = prefs.getValue(ConstantsExt.PORTLET_SELECTED_ID,"vcmsviewcontent_WAR_VCMSportlet");
String portionId = prefs.getValue("portionId","");
String showMenuContent = prefs.getValue("showMenuContent","");
String defaultShowNews = prefs.getValue("defaultShowNews","");
String titlecategory = prefs.getValue("titlecategory", "");
int numberOfNews = GetterUtil.getInteger(prefs.getValue(ConstantsExt.NUMBER_OF_NEWS,"5"));
long companyId = PortalUtil.getCompanyId(request);

long groupId = PortalUtilExt.getPortletGroupId(request);

long currentPlid = PortalUtilExt.getPlid(request);

long plId = 0;

try{
	plId = PortalUtilExt.getPlid(groupId, currentPlid, portletSelectId);
}catch(Exception ex){
}


Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);

int curMonth = curCal.get(Calendar.MONTH);
int curDay = curCal.get(Calendar.DATE);
int curYear = curCal.get(Calendar.YEAR);

long statusId = 0;
try{
	VcmsStatus vcmsStatus = VcmsStatusLocalServiceUtil.getByC_G_A(companyId, groupId, true);	
	statusId = vcmsStatus.getStatusId();
} catch(Exception ex){}


%>
