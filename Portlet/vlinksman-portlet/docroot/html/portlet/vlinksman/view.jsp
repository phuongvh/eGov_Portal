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
	String tabs1 = ParamUtil.getString(request, "tabs1",
			"VLinksman.title.link");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("jspPage", "/html/portlet/vlinksman/view.jsp");

	String tabsNames = "VLinksman.title.link,VLinksman.title.linkgroup";

	// 	tabsNames = "VAdvman.title.item";	
	//boolean showTabItem = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VADVMAN , ActionKeysExt.VIEW_ITEM_TAB);
	//boolean showTabType = showTabs && PortletPermissionUtil.contains(permissionChecker , plid.longValue() , PortletKeysExt.VADVMAN, ActionKeysExt.VIEW_TYPE_TAB);	

	//if (showTabType){
	//	tabsNames += ",VAdvman.title.type";
	//}
%>

<form action="<%=portletURL.toString()%>" method="post"
	name="<portlet:namespace />fm">
	<liferay-ui:tabs names="<%=tabsNames%>"
		url="<%=portletURL.toString()%>" />
	<c:choose>
		<c:when
			test='<%=tabs1.equalsIgnoreCase("VLinksman.title.linkgroup")%>'>
						<%@ include file="/html/portlet/vlinksman/linkgroup/view_linkgroup.jsp"%>
		</c:when>
		<c:otherwise>
				   		<%@ include file="/html/portlet/vlinksman/link/view_link.jsp" %>
		</c:otherwise>
	</c:choose>

</form>