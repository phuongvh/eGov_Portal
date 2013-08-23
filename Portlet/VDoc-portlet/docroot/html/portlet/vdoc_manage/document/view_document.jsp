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
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%@taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>

<%
	String tabs2Names = "portlet.vdoc.information-tab.not-approve,portlet.vdoc.information-tab.approved,portlet.vdoc.information-tab.published";
%>

<liferay-ui:tabs names="<%=tabs2Names%>" param="tabs2" url="<%=portletURL.toString()%>" />
	<c:choose>
	<c:when test='<%=tabs2.equals("portlet.vdoc.information-tab.approved")%>'>
		<%@include file="/html/portlet/vdoc_manage/document/approved.jsp" %>
	</c:when>
	<c:when test='<%=tabs2.equals("portlet.vdoc.information-tab.published")%>'>
		<%@include file="/html/portlet/vdoc_manage/document/published.jsp" %>
	</c:when>		
	<c:otherwise>
		<%@include file="/html/portlet/vdoc_manage/document/approval_pending.jsp" %>
	</c:otherwise>
	</c:choose>

	<input type="hidden" name="<portlet:namespace />cmd-search-flag" value="true"/>		



