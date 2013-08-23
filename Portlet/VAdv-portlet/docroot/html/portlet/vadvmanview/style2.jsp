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
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<c:if test="<%= validImageExtension%>">
	<%	if (item.getExpriedDate()!=null && item.getExpriedDate().before(new Date())){	%>
		<div align="left">
			<b>Qu&#7843;ng cáo này &#273;ã h&#7871;t h&#7841;n hi&#7875;n th&#7883;</b>
		</div>	
	<% } else {%>
		<a href="<%=item.getUrl()%>" target="<%= (item.getIsTargetBlank())? "_blank":"_self"%>" title="<%= item.getTxtMouseOver()%>" style="font-weight: bold;color: #06c;display: block;font-size: 14px; text-decoration: none; background: url(<%=themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + item.getFolderId() + StringPool.SLASH + HttpUtil.encodeURL(item.getName(), true)%>) no-repeat 5px 7px; padding: 7px 5px 7px 46px; text-transform: uppercase;background-color: #F2F2F2;border: 1px solid #F2F2F2;border-radius: 10px 10px 10px 10px;margin: 2px 0;text-align: left;">
			<span style="line-height: 26px;"><%= item.getDescription() %></span>
		</a>
	<%}%>
</c:if>