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

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@ include file="/html/portlet/vfaqmenu/init.jsp"%>
	
<%
	PortletURL categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
	categoryURL.setParameter("jspPage", "/html/portlet/vfaqcontent/view.jsp");
	categoryURL.setParameter("groupId", String.valueOf(groupId));
	
	List contactList = (List)FAQCategoryLocalServiceUtil.getCategoriesByG_L(groupId , language);
%>
<div align="center">
 <c:choose>
	<c:when test='<%= themeType.equals("1") %>'>
		<%@ include file="/html/portlet/vfaqmenu/Style/style1.jsp" %>
	</c:when>
	<c:when test='<%= themeType.equals("2") %>'>
		<%@ include file="/html/portlet/vfaqmenu/Style/style2.jsp" %>
	</c:when>
	</c:choose>
</div>
