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
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="init.jsp" %>

<%
	ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	String tabs1 = ParamUtil.getString(request, "tabs1");
	Object contentObj = row.getObject();
	int status=ParamUtil.getInteger(request,"status",0);
	String parameter = "calId";
	long id=0;
	VCal content = (VCal)contentObj;
	id = content.getCalId();
%>
<liferay-ui:icon-menu><%-- 
<c:if test="<%= (content.getStatus() == 1) %>">
		<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="publishURL">
			<portlet:param name="struts_action" value="/html/portlet/vcalendar/view.jsp" />
			<portlet:param name="<%= Constants.CMD %>" value="publish" />
			<portlet:param name="<%=parameter %>" value="<%= Long.toString(id) %>" />
			<portlet:param name="tabs" value="<%=tabs%>" />
			<portlet:param name="tabs1" value="day" />
			<portlet:param name="status" value="<%=Integer.toString(status)%>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="type" value="1" />
	    </portlet:actionURL>
		<liferay-ui:icon image="publish" url="<%= publishURL %>"  message="<%= LanguageUtil.get(pageContext, \"portlet.vcms.tooltip.publish-article\") %>"/>
</c:if>
<c:if test="<%= (content.getStatus() == 0) %>">
<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="unpublishURL">
	<portlet:param name="jspPage" value="/html/portlet/vcalendar/edit_vcalendar.jsp" />
	<portlet:param name="<%= Constants.CMD %>" value="unpublish" />
	<portlet:param name="<%=parameter %>" value="<%= Long.toString(id) %>" />
	<portlet:param name="status" value="<%=Integer.toString(status)%>" />
	<portlet:param name="comment" value="comment" />
	<portlet:param name="type" value="2" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>  
<liferay-ui:icon image="edit" url="<%= unpublishURL %>" message="<%= LanguageUtil.get(pageContext, \"portlet.vcms.tooltip.cancel-publish-article\") %>"/>
</c:if> --%>
<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL">
	<portlet:param name="jspPage" value="/html/portlet/vcalendar/update_vcalendar.jsp" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE %>" />
	<portlet:param name="<%=parameter %>" value="<%= Long.toString(id) %>" />
	<portlet:param name="status" value="<%=Integer.toString(status)%>" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>
<liferay-ui:icon image="edit" url="<%= editURL %>" />

<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="deleteURL" name="deletevCal">
	<portlet:param name="jspPage" value= "/html/portlet/vcalendar/view.jsp"/>
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
	<portlet:param name="<%=parameter %>" value="<%= Long.toString(id) %>" />
	<portlet:param name="tabs" value="<%=tabs%>" />
	<portlet:param name="tabs1" value="day" />
	<portlet:param name="status" value="<%=Integer.toString(status)%>" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:actionURL>
<liferay-ui:icon-delete url="<%= deleteURL %>" />
</liferay-ui:icon-menu>