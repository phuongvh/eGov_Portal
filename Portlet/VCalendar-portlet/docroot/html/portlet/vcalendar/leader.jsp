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
<%@ include file="/html/portlet/vcalendar/init.jsp" %>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<%
String tabs1 = ParamUtil.getString(request, "tabs1", "day");
int status = 1;
%> 
  <tr>
    <td>
	  <liferay-ui:tabs
	names="day,week,month,year"
	url="<%= leaderURL.toString() %>"
	param="tabs1"
	/>
	<c:choose>
		<c:when test='<%= tabs1.equals("day") %>'>
			<%@ include file="/html/portlet/vcalendar/leader/day.jsp" %>
		</c:when>
		<c:when test='<%= tabs1.equals("week") %>'>
			<%@ include file="/html/portlet/vcalendar/leader/week.jsp" %>
		</c:when>
		<c:when test='<%= tabs1.equals("month") %>'>
			<%@ include file="/html/portlet/vcalendar/leader/month.jsp" %>
		</c:when>
		<c:when test='<%= tabs1.equals("year") %>'>
			<%@ include file="/html/portlet/vcalendar/leader/year.jsp" %>
		</c:when>
	</c:choose>
	</td>
	</tr>
</table>