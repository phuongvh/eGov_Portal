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
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<liferay-theme:defineObjects />
<div class="wd-boxs">
	<h2 class="wd-tlh1-1 wd-alignment"><%=title %></h2>
	<ul class="wd-list-link">
		<%	
			for (int i=0;i<listCategory.size();i++){
			TFCategory category = (TFCategory)listCategory.get(i);	
			categoryURL.setParameter("categoryId", String.valueOf(category.getId()));	
		%>
	   		
		   	<li><a href="<%=categoryURL%>"><%=StringUtil.shorten(HtmlUtil.extractText(category.getName()),42)%></a></li>
		<%
			}
		%>
	</ul>
</div>