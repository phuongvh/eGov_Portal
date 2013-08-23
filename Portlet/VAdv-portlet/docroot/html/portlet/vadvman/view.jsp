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
<%@page import="com.vportal.portlet.vadvman.action.ViewAction"%>
<%@include file="/html/portlet/vadvman/init.jsp"%>
<%	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("jspPage", "/html/portlet/vadvman/view.jsp");
	portletURL.setParameter("tabs1", tabs1);
	portletURL.setParameter("language", language);
	portletURL.setParameter("groupId", String.valueOf(groupId));
			
	String tabsNames = "";
	
	tabsNames = "VAdvman.title.statistics";	
	boolean showTabItem = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VADVMAN , ActionKeysExt.VIEW_ITEM_TAB);
	boolean showTabType = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VADVMAN, ActionKeysExt.VIEW_TYPE_TAB);
	boolean showTabStatistics = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VADVMAN, ActionKeysExt.VIEW_TYPE_TAB);
	if (showTabItem){
		tabsNames += ",VAdvman.title.item";
	}	
	if (showTabType){
		tabsNames += ",VAdvman.title.type";
	}
	
%>
<%@ include file="/html/portlet/vadvman/error.jsp" %>
<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
<liferay-ui:tabs names="<%= tabsNames %>"
			url="<%= portletURL.toString() %>" />
			
				<c:choose>									
					<c:when test="<%=tabs1.equalsIgnoreCase(\"VAdvman.title.type\")%>">
						<%@ include file="/html/portlet/vadvman/vadvtype/view_type.jspf" %>	
					</c:when>
					<c:when test="<%=tabs1.equalsIgnoreCase(\"VAdvman.title.item\")%>">
						<%@ include file="/html/portlet/vadvman/vadvitem/view_item.jspf" %>	
					</c:when>
					<c:otherwise>
				   		<%@ include file="/html/portlet/vadvman/vadvstatistics/view_statistics.jspf" %>	
					</c:otherwise>					
				</c:choose>
				
<%-- 			<c:if test="<%= ViewAction.error == true %>">								 --%>
<%-- 						<%@ include file="/html/portlet/vadvman/error.jsp" %>		 --%>
<%-- 						<% ViewAction.error = false; %>				 --%>
<%-- 			</c:if>	 --%>
</form>