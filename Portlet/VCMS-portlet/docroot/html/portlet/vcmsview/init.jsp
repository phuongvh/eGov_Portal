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
<%@ page import="com.vportal.portlet.vcms.job.*" %>
<%@ page import="com.vportal.portlet.vcms.util.*" %>

<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="com.vportal.portlet.vcms.model.VcmsPortion" %>
<%@ page import="com.vportal.portlet.vcmsview.util.ConstantsExt" %>	
	
<%@ page import="com.vportal.portal.util.PortalUtilExt" %>	
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>

<%
DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
//String language = ParamUtil.getString(request, "language", "vi_VN");

PortletPreferences prefs = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

long openNewTab = 1;
/* long openNewTab = (Long)request.getAttribute(ConstantsExt.OPEN_NEW_TAB); */

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String receivedPortletId = "vcmsviewcontent";
String receivedPortletAction = "/vcmsviewcontent/view";
long groupId = PortalUtilExt.getPortletGroupId(request);
long currentPlid = PortalUtilExt.getPlid(request);
long plId = PortalUtilExt.getPlid(groupId, currentPlid, receivedPortletId);


//long groupId = ParamUtil.getLong(request, "groupId",0);
//if(groupId == 0){
//	groupId = portletGroupId.longValue();
//}

//String[] selectCategories = prefs.getValues(language + "_categories", null);
//String style = prefs.getValue(language + "_style", "1");
//String numOfOtherItem = prefs.getValue(language + "_numOfOtherItem", "5");
//String numOfItemPerPage = prefs.getValue(language + "_numOfItemPerPage", "10");
//String numOfItemDetail = prefs.getValue(language + "_numOfItemDetail", "3");
%>