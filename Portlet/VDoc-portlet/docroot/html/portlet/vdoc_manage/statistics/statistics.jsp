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

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="java.util.List" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.vportal.portlet.vdoc.service.impl.vdocDocumentServiceImpl"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocFieldServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocOrgServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentService"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil" %>

<%@ page import="com.vportal.portlet.vdoc.model.vdocDocument" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocField" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocOrg" %>
<%@ page import="com.vportal.portlet.vdoc.model.vdocDORel" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.persistence.UserUtil" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>
<%
	int approvalPendingDocuments = 0 ; // văn bản chưa duyệt
	int publishingPendingDocuments = 0; // văn bản đã duyệt
	int publishedDocuments = 0; // văn bản đã xuất bản
	
	int orgNum = 0; // số cơ quan đơn vị
	int field = 0; // số lĩnh vực
	
	approvalPendingDocuments = vdocDocumentServiceUtil.countDocByG_L_S(groupId, language, vdocDocumentServiceImpl.APPROVAL_PENDING);
	publishingPendingDocuments = vdocDocumentServiceUtil.countDocByG_L_S(groupId, language, vdocDocumentServiceImpl.PUBLISH_PENDING);
	publishedDocuments = vdocDocumentServiceUtil.countDocByG_L_S(groupId, language, vdocDocumentServiceImpl.PUBLISHED);
	
	orgNum = vdocOrgServiceUtil.getOrgByG_L(groupId, language).size();
	field = vdocFieldServiceUtil.getFieldByG_L(groupId, language).size();
	String tab_report = "portlet.vdoc.report.bydate";
	tab_report+= ",portlet.vdoc.report.byorg";
	String tabsreport = ParamUtil.getString(request, "tabsreport");
	PortletURL renderURL = renderResponse.createRenderURL();
	renderURL.setParameter("jspPage", "/html/portlet/vdoc_manage/view.jsp");
%>

<table width="100%" border="0" cellspacing="2" cellpadding="2">
<tr>
	<td width="50%" valign="top"><fieldset style="width:95%">
		<legend><strong><%=LanguageUtil.get(pageContext,"portlet.vdoc.information-tab")%></strong></legend>
		<table width="100%" border="0" cellspacing="2" cellpadding="2" style="border: 1px solid #CCCCCC">
		<tr>	
			<td width="25%" align="center">&nbsp;</td>
			<td width="25%" align="center"><b><%=LanguageUtil.get(pageContext, "portlet.vdoc.information-tab.not-approve")%>  </b></td>
			<td width="25%" align="center"><b><%=LanguageUtil.get(pageContext, "portlet.vdoc.information-tab.approved")%></b></td>
			<td align="center"><b><%=LanguageUtil.get(pageContext, "portlet.vdoc.information-tab.published")%></b></td>
		</tr>
		<tr>
			<td align="center"><b><%=LanguageUtil.get(pageContext, "portlet.vdoc.information-tab.doc")%></b></td>
			<td align="center"><%=approvalPendingDocuments%></td>
			<td align="center"><%=publishingPendingDocuments%></td>
			<td align="center"><%=publishedDocuments%></td>
		</tr>	
		</table>
	</td>	
	
	<td width="50%" valign="top"><fieldset style="width:95%" >
		<legend><strong><%=LanguageUtil.get(pageContext,"portlet.vdoc.information-tab")%></strong></legend>
		<table width="100%" border="0" cellspacing="2" cellpadding="2" style="border: 1px solid #CCCCCC">
		<tr>
			<td style="padding-left:20px;"><b><%=LanguageUtil.get(pageContext,"portlet.vdoc.information-tab.number-organizations")%></b></td>
			<td align="center"><%=orgNum%></td>
		</tr>			
		<tr>	
			<td style="padding-left:20px;"><b><%=LanguageUtil.get(pageContext,"portlet.vdoc.information-tab.number-fields")%></b></td>	
			<td align="center"><%=field%></td>
		</tr>
		</table>
	</td>
</tr>	
</table>
<liferay-ui:tabs names="<%=tab_report%>" url="<%=renderURL.toString()%>" param="tabsreport"/>
	<c:choose>
		<c:when test="<%=tabsreport.equals(\"portlet.vdoc.report.byorg\")%>">
			<%@ include file="/html/portlet/vdoc_manage/statistics/report_byorg.jsp" %>
		</c:when>
	
		<c:otherwise>
			<%@ include file="/html/portlet/vdoc_manage/statistics/report_bydate.jsp" %>
		</c:otherwise>
	</c:choose>






