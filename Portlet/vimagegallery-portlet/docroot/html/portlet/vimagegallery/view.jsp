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
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("jspPage", "/html/portlet/vimagegallery/view.jsp");
	portletURL.setParameter("tabs1", tabs1);	
			
	String tabsNames = "";
	String tabsIcons = "";

	tabsNames = "VImageGallery.title.image";
	tabsIcons = "vimagegallery/tab-image.png";
		
	boolean showTabImage = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeyExt.VIMAGEGALLERY, ActionKeysExt.VIEW_IMAGE_TAB);
	boolean showTabCategory = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeyExt.VIMAGEGALLERY, ActionKeysExt.VIEW_CATEGORY_TAB);	

	
	//Check Permission to view Tabs
	if(showTabCategory){
		tabsNames += ",VImageGallery.title.category";
		tabsIcons += ",vimagegallery/tab-categories.gif";
	}
		
%>
	
<form action="<%= portletURL.toString() %>" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace />tabs1" type="hidden" value="<%=tabs1 %>" / >
	
<liferay-ui:tabs names="<%= tabsNames %>" url="<%= portletURL.toString() %>" />
	<c:choose>
		<c:when test="<%=tabs1.equalsIgnoreCase(\"VImageGallery.title.category\")%>">
			<%@ include file="/html/portlet/vimagegallery/category/view_category.jsp" %>	
		</c:when>
	
		<c:otherwise>
	   		<%@ include file="/html/portlet/vimagegallery/image/view_image.jsp" %>
		</c:otherwise>	
	</c:choose>
			
</form>