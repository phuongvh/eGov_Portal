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
<%
String tabs1 = ParamUtil.getString(request, "tabs1", "day");
int status = 0;
%>
<liferay-ui:tabs
	names="day,week,month,year"
	url="<%= personelURL.toString() %>"
	param="tabs1"
/>
<c:choose>
	<c:when test='<%= tabs1.equals("day") %>'>
		<%@ include file="/html/portlet/vcalendar/personel/day.jsp" %>
	</c:when>
	<c:when test='<%= tabs1.equals("week") %>'>
		<%@ include file="/html/portlet/vcalendar/personel/week.jsp" %>
	</c:when>
	<c:when test='<%= tabs1.equals("month") %>'>
		<%@ include file="/html/portlet/vcalendar/personel/month.jsp" %>
	</c:when>
	<c:when test='<%= tabs1.equals("year") %>'>
		<%@ include file="/html/portlet/vcalendar/personel/year.jsp" %>
	</c:when>
</c:choose>