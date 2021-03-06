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
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>

<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.lang.Integer" %>
<%@ page import="java.lang.Long" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil  " %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>

<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="javax.portlet.PortletPreferences " %>

<%@ page import="com.vportal.portlet.edirectory.action.ActionUtil" %>
<%@ page import="com.vportal.portlet.edirectory.model.EDEmployee" %>
<%@ page import="com.vportal.portlet.edirectory.model.EDDepartment" %>
<%@ page import="com.vportal.portlet.edirectory.model.EDFunction" %>
<%@ page import="com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil" %>
<%@ page import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil" %>
<%@ page import="com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String tab1 = ParamUtil.getString(request, "tab1");
	String tab2 = ParamUtil.getString(request, "tab2");
	String tab3 = ParamUtil.getString(request, "tab3");
%>