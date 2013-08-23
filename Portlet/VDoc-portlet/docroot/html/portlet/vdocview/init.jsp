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

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl"%>
<%@ page import="com.vportal.portlet.vdoc.service.util.ActionUtil"%>
<%@ page import="com.vportal.portlet.vdoc.service.persistence.vdocDocumentPersistence"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool"%>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.util.List"%>

<%@ page import="com.vportal.portlet.vdoc.model.vdocDocument"%>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDocumentService"%>

<%@ page import="com.vportal.portlet.vdoc.model.vdocDocument" %>
<%@ page import="com.vportal.portlet.vdoc.service.vdocDORelService"%>

<%@ page import="com.vportal.portlet.vdoc.service.vdocOrgServiceUtil" %>
<%@ page import="com.vportal.portlet.vdoc.model.impl.vdocOrgImpl" %>

<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/sql_rt" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jstl/xml_rt" prefix="x" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<portlet:defineObjects />
<liferay-theme:defineObjects/>


<%
	String language = ParamUtil.getString(request, "language", "vi_VN");
	long groupId = ParamUtil.getLong(request, "groupId", portletGroupId.longValue());
	
	PortletPreferences prefs = renderRequest.getPreferences();

	String titlePortlet = prefs.getValue("titlePortlet", "Thủ tục hành chính");
	int numberItem = GetterUtil.getInteger(prefs.getValue("numberItem",""), 10);
%>









