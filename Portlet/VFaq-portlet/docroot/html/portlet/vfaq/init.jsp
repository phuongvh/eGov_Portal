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

<%@ include file="/html/portlet/init.jsp" %>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.vportal.portlet.vfaq.*" %>
<%@ page import="com.vportal.portlet.vfaq.model.*" %>
<%@ page import="com.vportal.portlet.vfaq.action.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.impl.*" %>
<%@ page import="com.vportal.portlet.vfaq.service.permission.*" %>
<%@page import="com.vportal.portlet.vfaq.util.FAQUtil"%>
<%@page import="com.vportal.portal.model.Attachment"%>
<%@page import="com.vportal.portlet.vfaq.util.WebKeysExt"%>
<%@page import="com.vportal.portlet.vfaq.util.ActionKeysExt"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.vportal.portal.service.AttachmentServiceUtil"%>
<%@page import="com.vportal.portal.util.PortalUtilExt"%>

<%
		String language = ParamUtil.getString(request, "language", "vi_VN");
		long groupId = ParamUtil.getLong(request, "groupId", portletGroupId.longValue());
		String parentId1 = ParamUtil.get(request, "parentId1", "0");
		String tabs1 = ParamUtil.getString(request, "tabs1");	
		String tabs2 = ParamUtil.getString(request, "tabs2");
		String tabs3 = ParamUtil.getString(request, "tabs3");
		
		boolean showButtons = false;	
		boolean showAddAnswer = false;
		boolean showTabReportAC = true;
		boolean showTabReportQC = true;
		boolean showTabReportQByDate = true;
		boolean showTabReportAByDate = true;
		//boolean showTabs = false;
		if (portletConfig.getPortletName().equals("vfaq")) {
			showButtons = true;				
		//	showTabs = true;
		}	
		
		if (tabs2.equals("approved")){
			showAddAnswer = true;		
		}
%>

<script language="javascript">	
	function <portlet:namespace />updateQuestion(cmd, render) {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = cmd;		
		if (render) {
			submitForm(document.<portlet:namespace />fm, '<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="jspPage" value="/html/portlet/vfaq/edit_question.jsp" /></portlet:renderURL>');
		} else {
			submitForm(document.<portlet:namespace />fm, '<portlet:actionURL name="updateQuestion" windowState="<%= WindowState.MAXIMIZED.toString() %>" ></portlet:actionURL>');
		}
	}	
</script>	