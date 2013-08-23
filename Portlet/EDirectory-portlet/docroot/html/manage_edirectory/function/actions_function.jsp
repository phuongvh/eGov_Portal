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
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/html/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute( WebKeys.SEARCH_CONTAINER_RESULT_ROW);
EDFunction func  = (EDFunction) row.getObject();
long groupId = themeDisplay.getScopeGroupId();
String name = EDDepartment.class.getName();
String primKey = String.valueOf(func.getPrimaryKey());
%>

<liferay-ui:icon-menu message='<%=LanguageUtil.get(pageContext, "managecontacts.position.view-actions") %>'>

<%--   <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>"> --%>
<c:if test='<%= PortletPermissionUtil.contains(permissionChecker,plid, portletDisplay.getId(), ActionKeys.UPDATE) %>'>
	<portlet:renderURL windowState="normal" var="suaChucVuURL">
		<portlet:param name="resourcePrimKey" value="<%= primKey %>"></portlet:param>
		<portlet:param name="jspPage" value="/html/manage_edirectory/function/edit_function.jsp"></portlet:param>
	</portlet:renderURL>

    <liferay-ui:icon image="edit" message='<%=LanguageUtil.get(pageContext, "managecontacts.position.view-actions.edit") %>' url="<%= suaChucVuURL.toString() %>" />
  </c:if>

<%--   <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>"> --%>
	<c:if test='<%= PortletPermissionUtil.contains(permissionChecker,plid, portletDisplay.getId(), ActionKeys.DELETE) %>'>
    <portlet:actionURL name="deleteFunction" var="deleteFunctionURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete  url="<%= deleteFunctionURL.toString() %>" />
  </c:if>

<%--   <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.PERMISSIONS) %>"> --%>
	<c:if test='<%= PortletPermissionUtil.contains(permissionChecker,plid, portletDisplay.getId(), ActionKeys.PERMISSIONS) %>'>
    <liferay-security:permissionsURL
        modelResource="<%= EDFunction.class.getName() %>"
        modelResourceDescription="<%= func.getName() %>"
        resourcePrimKey="<%= primKey %>"
        var="permissionsURL" />

    <liferay-ui:icon image="permissions" message='<%=LanguageUtil.get(pageContext, "managecontacts.position.view-actions.permissions") %>' url="<%= permissionsURL.toString() %>" />
  </c:if>
</liferay-ui:icon-menu>





