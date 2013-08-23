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

<%@ include file="/html/portlet/vimagegallery/init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	TFCategory category = (TFCategory) row.getObject();
%>
<liferay-ui:icon-menu>
	<!-- Edit category -->
	<c:if test="<%= TFCategoryPermission.contains(permissionChecker, category, ActionKeysExt.UPDATE) %>">
		<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL" >
			<portlet:param name="jspPage" value="/html/portlet/vimagegallery/category/edit_category.jsp" />
			<portlet:param name="cmd" value="showupdate" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="categoryId" value="<%= Long.toString(category.getId()) %>" />
			<portlet:param name="tabs1" value="<%= tabs1 %>" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="<%= editURL %>" />	
	</c:if>	
	
	<!-- Permissions -->
	<c:if test="<%= TFCategoryPermission.contains(permissionChecker, category, ActionKeysExt.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= TFCategory.class.getName() %>"
			modelResourceDescription="<%= category.getName() %>"
			resourcePrimKey="<%= String.valueOf(category.getId()) %>"
			var="permissionsURL" />
		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>			
		
	<!-- Delete category -->
	<c:if test="<%= TFCategoryPermission.contains(permissionChecker, category, ActionKeysExt.DELETE) %>">
		<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="deleteURL" name="deleteCategory">
			<portlet:param name="jspPage" value="/html/portlet/vimagegallery/category/edit_category.jsp" />
			<portlet:param name="cmd" value="dodelete" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="ids" value="<%= Long.toString(category.getId()) %>" />
			<portlet:param name="tabs1" value="<%= tabs1 %>" />
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteURL %>" />
	</c:if>	
</liferay-ui:icon-menu>