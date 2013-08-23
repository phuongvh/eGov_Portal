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

<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.DateFormats"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ include file="/html/portlet/init.jsp"%>
<%@ page import="com.vportal.portlet.vfaq.*" %>
<%@ page import="com.vportal.portlet.vfaq.model.*" %>
<%@ page import="com.vportal.portlet.vfaq.action.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.impl.*" %>
<%@ page import="com.vportal.portlet.vfaq.util.*" %>
<%@ page import="com.liferay.portlet.polls.model.*" %>
<%@ page import="com.liferay.portlet.polls.service.*" %>
<%@ page import="com.vportal.portal.util.*" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.vportal.portal.util.PortalUtilExt" %>	
<%@ page import="com.vportal.portal.model.*" %>
<%@ page import="com.vportal.portal.service.*" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@page import="com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.vportal.portlet.vfaq.model.FAQCategory"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.vfaq.model.FAQQuestion"%>
<%@page import="com.vportal.portlet.vfaq.util.WebKeysEDDepartment"%>
<%@ page import="java.util.GregorianCalendar" %>	
<link href="/html/portlet/vfaqcontent/css/vfaq.css" rel="stylesheet" type="text/css" /> 

<%
PortletPreferences prefs = renderRequest.getPreferences(); 	
String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

int defaultQuestionNumber = 10;
String sendQuestionTitle="";

String defaultCategory = prefs.getValue("defaultCategory","");
String questionNumber = prefs.getValue("questionNumber",String.valueOf(defaultQuestionNumber));
String otherQuestionNumber= prefs.getValue("otherQuestionNumber","5");

String titlePortlet = prefs.getValue("titlePortlet","H&#7887;i &#273;áp tr&#7921;c tuy&#7871;n");
String themeType = prefs.getValue("themeType","1");	
String url = prefs.getValue("url","");

DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Locale[] locales = LanguageUtil.getAvailableLocales();

String language = ParamUtil.getString(request, "language", "vi_VN");
long groupId = ParamUtil.getLong(request, "groupId",0);
if(groupId == 0){
	groupId = portletGroupId.longValue();
}

%>