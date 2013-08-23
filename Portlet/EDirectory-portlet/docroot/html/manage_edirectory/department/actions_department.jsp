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
<%@page import="com.liferay.util.bridges.jsf.sun.LiferayApplicationMap"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Http" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="/html/init.jsp" %>
<%
ResultRow row = (ResultRow) request.getAttribute( WebKeys.SEARCH_CONTAINER_RESULT_ROW);
EDDepartment donvi  = (EDDepartment) row.getObject();
long groupId = themeDisplay.getScopeGroupId();
String name = EDDepartment.class.getName();
String primKey = String.valueOf(donvi.getPrimaryKey());


%>
<form method="post" name="<portletnamespace/>fm">
<liferay-ui:icon-menu message='<%=LanguageUtil.get(pageContext, "managecontacts.agency.view-actions") %>' >

<%--   <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>"> --%>
	<c:if test='<%= PortletPermissionUtil.contains(permissionChecker,plid, portletDisplay.getId(), ActionKeys.UPDATE) %>'>
	<portlet:renderURL windowState="normal" var="suaDonViURL">
		<portlet:param name="resourcePrimKey" value="<%= primKey %>"></portlet:param>
		<portlet:param name="jspPage" value="/html/manage_edirectory/department/edit_department.jsp"></portlet:param>
	</portlet:renderURL>

    <liferay-ui:icon image="edit" message='<%=LanguageUtil.get(pageContext, "managecontacts.agency.view-actions.edit") %>' url="<%= suaDonViURL.toString() %>" />
  </c:if>

<%--   <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>"> --%>
  <c:if test='<%= PortletPermissionUtil.contains(permissionChecker,plid, portletDisplay.getId(), ActionKeys.DELETE) %>' >
    <portlet:actionURL name="deleteDepartment" var="deleteDepartmentURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete  url="<%=deleteDepartmentURL %>" />
 
  </c:if>

<%--   <c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.PERMISSIONS) %>"> --%>
  <c:if test='<%= PortletPermissionUtil.contains(permissionChecker,plid, portletDisplay.getId(), ActionKeys.PERMISSIONS) %>'>
    <liferay-security:permissionsURL
        modelResource="<%= EDDepartment.class.getName() %>"
        modelResourceDescription="<%= donvi.getName() %>"
        resourcePrimKey="<%= primKey %>"
        var="permissionsURL" />

    <liferay-ui:icon image="permissions" message='<%=LanguageUtil.get(pageContext, "managecontacts.agency.view-actions.permissions") %>' url="<%= permissionsURL.toString() %>" />
  </c:if>
</liferay-ui:icon-menu>
</form>




