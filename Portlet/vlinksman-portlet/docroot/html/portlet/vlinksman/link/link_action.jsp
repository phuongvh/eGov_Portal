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

<%@include file="/html/portlet/vlinksman/init.jsp"%>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);	
	Links link = (Links) row.getObject();
%>
<liferay-ui:icon-menu>
	<!-- Edit category -->
	<c:if test="<%= LinksPermission.contains(permissionChecker, link, ActionKeysExt.UPDATE) %>">	
		<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL">
			<portlet:param name="jspPage" value= "/html/portlet/vlinksman/link/edit_link.jsp"/>
			<portlet:param name="cmd" value="doupdate" />
			<portlet:param name="linkIds" value="<%= Long.toString(link.getLinkId()) %>" />	
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="linkId" value="<%= Long.toString(link.getLinkId()) %>" />			
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="<%= editURL %>" />		
	</c:if>
	
	<!-- Permissions -->
	<c:if test="<%= LinksPermission.contains(permissionChecker, link, ActionKeysExt.PERMISSIONS) %>">	
		<liferay-security:permissionsURL
			modelResource="<%= Links.class.getName() %>"
			modelResourceDescription="<%= link.getName() %>"
			resourcePrimKey="<%= String.valueOf(link.getPrimaryKey()) %>"
			var="permissionsURL" />
		<liferay-ui:icon image="permissions" url="<%= permissionsURL.toString() %>" />
	</c:if>
		
	<!-- Delete category -->
	<c:if test="<%= LinksPermission.contains(permissionChecker, link, ActionKeysExt.DELETE) %>">
		<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="deleteURL" name="_deleteLink">
			<portlet:param name="cmd" value="dodelete" />
			<portlet:param name="linkIds" value="<%= Long.toString(link.getLinkId()) %>" />	
			<portlet:param name="redirect" value="<%= currentURL %>" />			
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteURL %>" />
	</c:if>	
</liferay-ui:icon-menu>