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

<style>
	div.menu-img {
    background-color: #4B8BC4;
    border: 1px solid white;    
    height: 30px;   
	}
	
	div.menu-img a,div.menu-img p{
	color: white;
	font-weight: bold;
	padding-left: 10px;
	line-height: 30px;
	}
	
	div.menu-img a:hover{
		color: tan;
	}
	
	div.menu-img a:link {text-decoration:none;}

</style>

<table class="vimg-menu" cellspacing="0" cellpadding="0" border="0" width="100%">
	<tr bgcolor="#FFFFFF">
		<td align="center">
			<img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/i_45.gif" />
		</td>			
	</tr>
	<tr>
		<td>
			<div class="menu-img">
				<p align="center" style="font-size: 14px;">
					<%=title%>
				</p>
			</div>
		</td>			
	</tr>
	
	<tr>				 
	   <td align="left" valign="top" class="bg_04" height="100%">
		<%	
			for (int i=0;i<listCategory.size();i++){
			TFCategory category = (TFCategory)listCategory.get(i);	
			categoryURL.setParameter("categoryId", String.valueOf(category.getId()));	
		%>
	   		<div class="menu-img">
		   		<a class="menuleft2" href="<%=categoryURL%>">		   			   			
		   			<%=StringUtil.shorten(HtmlUtil.extractText(category.getName()),42)%>
		   		</a>			   	
		   	</div>
		<%
			}
		%>
	   	</td>  
	</tr>
	
</table>