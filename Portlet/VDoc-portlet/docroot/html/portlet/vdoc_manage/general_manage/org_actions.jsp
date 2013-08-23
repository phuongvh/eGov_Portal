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

<%@ include file="/html/portlet/vdoc_manage/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute( WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	vdocOrg org  = (vdocOrg) row.getObject();
	String name = vdocOrg.class.getName();
	String primKey = String.valueOf(org.getPrimaryKey());
%>

<liferay-ui:icon-menu message='<%=LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.actions") %>'>

	<c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), ActionKeys.UPDATE) %>'>
	<portlet:renderURL windowState="normal" var="editOrgURL">
		<portlet:param name="orgId" value="<%= primKey %>"></portlet:param>
		<portlet:param name="jspPage" value="/html/portlet/vdoc_manage/general_manage/edit_org.jsp"></portlet:param>
	</portlet:renderURL>

    <liferay-ui:icon image="edit" message='<%=LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.update") %>' url="<%= editOrgURL.toString() %>" />
  </c:if>

  <c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), ActionKeys.DELETE) %>'>
    <portlet:actionURL name="deleteOrg" var="deleteOrgURL">
      <portlet:param name="orgId" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%= deleteOrgURL.toString() %>" />
  </c:if>

  <c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), ActionKeys.PERMISSIONS) %>'>
    <liferay-security:permissionsURL
        modelResource="<%= vdocOrg.class.getName() %>"
        modelResourceDescription="<%= org.getName() %>"
        resourcePrimKey="<%= primKey %>"
        var="permissionsURL" />

    <liferay-ui:icon image="permissions" message='<%=LanguageUtil.get(pageContext, "portlet.vdoc.general-manage.permissions") %>' url="<%= permissionsURL.toString() %>" />
  </c:if>
</liferay-ui:icon-menu>





