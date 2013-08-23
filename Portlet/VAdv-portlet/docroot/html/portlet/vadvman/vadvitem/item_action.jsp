<%--/**
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
 */ --%>
<%@include file="/html/portlet/vadvman/init.jsp"%>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);	
	AdvItem item = (AdvItem) row.getObject();
%>
<liferay-ui:icon-menu>
	<!-- View detail -->
	<c:if test="<%= AdvItemPermission.contains(permissionChecker, item, ActionKeysExt.VIEW_DETAIL) %>">
		<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="viewURL">
			<portlet:param name="jspPage" value="/html/portlet/vadvman/vadvitem/detail.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="cmd" value="viewDetail" />			
			<portlet:param name="itemId" value="<%= String.valueOf(item.getItemId())%>" />
			<portlet:param name="name" value="<%= item.getName() %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="view" url="<%= viewURL %>" />	
	</c:if>
	
	<!-- Edit item -->
	<c:if test="<%= AdvItemPermission.contains(permissionChecker, item, ActionKeysExt.UPDATE) %>">
		<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL">
			<portlet:param name="jspPage" value="/html/portlet/vadvman/vadvitem/edit_item.jsp" />
			<portlet:param name="cmd" value="showupdate" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="itemId" value="<%= Long.toString(item.getItemId()) %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="<%= editURL %>" />		
	</c:if>
	
	<!-- Permissions -->
	<c:if test="<%= AdvItemPermission.contains(permissionChecker, item, ActionKeysExt.PERMISSIONS) %>">	
		<liferay-security:permissionsURL
			modelResource="<%= AdvItem.class.getName() %>"
			modelResourceDescription="<%= item.getName() %>"
			resourcePrimKey="<%= String.valueOf(item.getItemId()) %>"
			var="permissionsURL" />
		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
		
	<!-- Delete item -->
	<c:if test="<%= AdvItemPermission.contains(permissionChecker, item, ActionKeysExt.DELETE) %>">		
		<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" name="_deleteItem" var="deleteURL">
			<portlet:param name="jspPage" value="/html/portlet/vadvman/vadvitem/view_item.jsp" />
			<portlet:param name="cmd" value="dodelete" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="ids" value="<%= Long.toString(item.getItemId()) %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteURL %>" />
	</c:if>
</liferay-ui:icon-menu>