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

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.language.Language"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jstl/xml_rt" prefix="x" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.vportal.portlet.vdoc.service.util.ActionUtil" %>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDocumentService"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil" %>
<%@ page import="com.vportal.portlet.vdoc.service.vdocFieldService"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocFieldServiceUtil" %>
<%@ page import="com.vportal.portlet.vdoc.service.vdocOrgService"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocOrgServiceUtil" %>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDORelService"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDORelServiceUtil" %>

<%@ page import="com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl" %>
<%@ page import="com.vportal.portlet.vdoc.service.impl.vdocFieldServiceImpl" %>
<%@ page import="com.vportal.portlet.vdoc.service.impl.vdocOrgServiceImpl" %>
<%@ page import="com.vportal.portlet.vdoc.service.impl.vdocDORelServiceImpl" %>

<%@ page import="com.vportal.portlet.vdoc.model.vdocDocument" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocField" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocOrg" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocDORel" %>

<%@ page import="com.vportal.portlet.vdoc.model.impl.vdocDocumentModelImpl" %>
<%@page import="com.vportal.portlet.vdoc.model.impl.vdocDocumentImpl"%>
<%@page import="com.vportal.portlet.vdoc.model.impl.vdocOrgImpl"%>
<%@page import="com.vportal.portlet.vdoc.model.impl.vdocDORelImpl"%>
<%@page import="com.vportal.portlet.vdoc.model.impl.vdocFieldImpl"%>

<%@ page import="com.liferay.counter.service.CounterLocalServiceUtil" %>
<%@ page import="com.liferay.portal.NoSuchUserException" %>
<%@ page import="com.liferay.portal.PortalException" %>
<%@ page import="com.liferay.portal.SystemException" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanPropertiesUtil" %>
<%@ page import="com.liferay.portal.kernel.cal.Recurrence" %>
<%@ page import="com.liferay.portal.kernel.configuration.Filter" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.DAOParamUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.DisplayTerms" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.TextSearchEntry" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageWrapper" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.log.LogUtil" %>
<%@ page import="com.liferay.portal.kernel.messaging.DestinationNames" %>
<%@ page import="com.liferay.portal.kernel.portlet.DynamicRenderRequest" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletMode" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.kernel.servlet.BrowserSnifferUtil" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@ page import="com.liferay.portal.kernel.servlet.StringServletResponse" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="com.liferay.portal.kernel.util.BooleanWrapper" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ContentTypes" %>
<%@ page import="com.liferay.portal.kernel.util.DateFormats" %>
<%@ page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@ page import="com.liferay.portal.kernel.util.FileUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Http" %>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.IntegerWrapper" %>
<%@ page import="com.liferay.portal.kernel.util.JavaConstants" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePairComparator" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.kernel.util.LongWrapper" %>
<%@ page import="com.liferay.portal.kernel.util.ObjectValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.ObjectValuePairComparator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderedProperties" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropertiesParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropertiesUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Randomizer" %>
<%@ page import="com.liferay.portal.kernel.util.ReleaseInfo" %>
<%@ page import="com.liferay.portal.kernel.util.ServerDetector" %>
<%@ page import="com.liferay.portal.kernel.util.SortedProperties" %>
<%@ page import="com.liferay.portal.kernel.util.StackTraceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringComparator" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Time" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeProperties" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.model.*" %>
<%@ page import="com.liferay.portal.model.impl.*" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.portal.service.*" %>
<%@ page import="com.liferay.portal.service.permission.GroupPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.LayoutPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="com.liferay.portal.theme.PortletDisplay" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ page import="com.liferay.portal.util.SessionClicks" %>
<%@ page import="com.liferay.portal.util.comparator.PortletCategoryComparator" %>
<%@ page import="com.liferay.portal.util.comparator.PortletTitleComparator" %>
<%@ page import="com.liferay.portlet.InvokerPortlet" %>
<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portlet.PortletConfigFactory" %>
<%@ page import="com.liferay.portlet.PortletInstanceFactory" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portlet.UserAttributes" %>

<%@ page import="com.liferay.util.CreditCard" %>
<%@ page import="com.liferay.util.JS" %>
<%@ page import="com.liferay.util.LocalizationUtil" %>
<%@ page import="com.liferay.util.MathUtil" %>
<%@ page import="com.liferay.util.PKParser" %>
<%@ page import="com.liferay.util.PwdGenerator" %>
<%@ page import="com.liferay.util.SetUtil" %>
<%@ page import="com.liferay.util.State" %>
<%@ page import="com.liferay.util.StateUtil" %>

<%@ page import="com.liferay.util.UniqueList" %>
<%@ page import="com.liferay.util.format.PhoneNumberUtil" %>
<%@ page import="com.liferay.util.log4j.Levels" %>
<%@ page import="com.liferay.util.mail.InternetAddressUtil" %>
<%@ page import="com.liferay.util.portlet.PortletRequestUtil" %>
<%@ page import="com.liferay.util.servlet.DynamicServletRequest" %>
<%@ page import="com.liferay.util.servlet.SessionParameters" %>

<%@ page import="com.liferay.util.xml.XMLFormatter" %>

<%@ page import="java.io.ByteArrayInputStream" %>
<%@ page import="java.io.StringReader" %>

<%@ page import="java.math.BigDecimal" %>

<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.MessageFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Currency" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.LinkedHashSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Stack" %>
<%@ page import="java.util.TimeZone" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.TreeSet" %>

<%@ page import="javax.portlet.PortletConfig" %>
<%@ page import="javax.portlet.PortletContext" %>
<%@ page import="javax.portlet.PortletException" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="javax.portlet.PortletSession" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="javax.portlet.RenderResponse" %>
<%@ page import="javax.portlet.ResourceURL"%>
<%@ page import="javax.portlet.UnavailableException" %>
<%@ page import="javax.portlet.ValidatorException" %>
<%@ page import="javax.portlet.WindowState" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
		PortletPreferences prefs = renderRequest.getPreferences();
		
		String portletResource = ParamUtil.getString(request, "portletResource");
		
// 		if (Validator.isNotNull(portletResource)) {
// 			prefs = PortletPreferenceFactoryUtil.getPortletSetup(request, portletResource);
// 		}
		
		String language = ParamUtil.getString(request, "language", "vi_VN");
		long groupId = ParamUtil.getLong(request, "groupId", portletGroupId.longValue());
		String tabs1 = ParamUtil.getString(request, "tabs1");
		String tabs2 = ParamUtil.getString(request, "tabs2","approval-pending");
		
		DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
		Locale[] locales = LanguageUtil.getAvailableLocales();
		
		long companyId = PortalUtil.getCompanyId(request);
		long userId = themeDisplay.getUserId();	
		
		String parentId1 = ParamUtil.get(request, "parentId1", "0"); // field
		String parentId2 = ParamUtil.get(request, "parentId2", "0"); // org
		
		String monthParam = request.getParameter("month");
		String dayParam = request.getParameter("day");
		String yearParam = request.getParameter("year");
		
		Calendar selCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
		
		try {
			selCal.set(Calendar.YEAR, Integer.parseInt(yearParam));
		}
		catch (NumberFormatException nfe) {
		}
		
		try {
			if (dayParam != null) {
				selCal.set(Calendar.DATE, 1);
			}
		
			selCal.set(Calendar.MONTH, Integer.parseInt(monthParam));
		}
		catch (NumberFormatException nfe) {
		}
		
		try {
			int maxDayOfMonth = selCal.getActualMaximum(Calendar.DATE);
		
			int dayParamInt = Integer.parseInt(dayParam);
		
			if (dayParamInt > maxDayOfMonth) {
				dayParamInt = maxDayOfMonth;
			}
		
			selCal.set(Calendar.DATE, dayParamInt);
		}catch (NumberFormatException nfe) { }
		
		
		int selMonth = selCal.get(Calendar.MONTH);
		int selDay = selCal.get(Calendar.DATE);
		int selYear = selCal.get(Calendar.YEAR);
		
		Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
		
		int curMonth = curCal.get(Calendar.MONTH);
		int curDay = curCal.get(Calendar.DATE);
		int curYear = curCal.get(Calendar.YEAR);
		
		int[] monthIds = CalendarUtil.getMonthIds();
		String[] months = CalendarUtil.getMonths(locale);
		
		String[] days = CalendarUtil.getDays(locale);
		
		if (Validator.isNull(parentId1)) {
// 			parentId1 = ActionUtil.DEFAULT_FIELD_ID;
		}
		
		if (Validator.isNull(parentId2)){
// 			parentId2 = ActionUtil.DEFAULT_ORG_ID;
		}
		
		int maxAttachmentDocument = GetterUtil.getInteger(prefs.getValue("numberFile", "5"));
		
%>

