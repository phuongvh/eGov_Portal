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

<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ include file="/html/portlet/vimagegallerymenu/init.jsp"%>
<%@ include file="/html/portlet/vimagegallerymenu/css.jsp"%>
<link href="/html/js/media/css/common.css" rel="stylesheet"
	type="text/css" />

<%
	List listCategory = new ArrayList();
	listCategory = (List) TFCategoryServiceUtil.getByGroupId(groupId);
	// 	
	ViewAction viewaction = new ViewAction();
	PortletURL categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
	categoryURL.setParameter("jspPage",
			"/html/portlet/vimagegalleryview/view.jsp");
	categoryURL.setParameter("groupId", String.valueOf(groupId));
%>

<c:choose>
	<c:when test="<%=themeType.equals(\"2\")%>">
		<%@ include file="/html/portlet/vimagegallerymenu/includes/style2.jsp"%>
	</c:when>
	<c:when test="<%=themeType.equals(\"1\")%>">
		<%@ include file="/html/portlet/vimagegallerymenu/includes/style1.jsp"%>
	</c:when>
	<c:when test="<%=themeType.equals(\"3\")%>">
		<%@ include file="/html/portlet/vimagegallerymenu/includes/style3.jsp"%>
	</c:when>
</c:choose>
