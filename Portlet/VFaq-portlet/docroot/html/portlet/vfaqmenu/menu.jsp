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

<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@ include file="init.jsp"%>
	
<%	
	PortletURL categoryURL = PortletURLFactoryUtil.create(request,portletSelectId, plId, PortletRequest.RENDER_PHASE);
	categoryURL.setParameter("struts_action", "/vfaqcontent/contentview");
	categoryURL.setParameter("groupId", String.valueOf(groupId));
	
	List contactList = (List)FAQCategoryLocalServiceUtil.getCategoriesByG_L(groupId , language);
%>
<% if(themeType.equals("3")){%> <!--  -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr>
	<td width="4" align="left" height="5">
		<img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/1.gif" width="4" height="5"/></td>	
	<td height="3" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/3.gif"></td>
	<td width="4" align="right">
		<img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/2.gif" width="4" height="5" /></td>
</tr>
		
<tr>
   	<td width="4" align="left" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/7.gif"></td>
	<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" >
		<tr><td height="3px"></td></tr>
	
		<tr><td width="3px"></td>
		    <td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17"><img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/9.gif" width="17" height="30"/></td>
					<td width="100%" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/10.gif" height="30" style="color:#FFFFFF;font-size:11px;font-weight:bold;text-transform:uppercase;" valign="middle">&nbsp;Chuyên m&#7909;c</td>
				</tr>
				<tr>
					<td colspan="2">
						 <table width="100%" border="0" cellspacing="0" cellpadding="0">
						<%	for (int i=0;i<contactList.size();i++){								
								FAQCategory g = (FAQCategory)contactList.get(i);
								categoryURL.setParameter("categoryId",String.valueOf(g.getId()));																
						%>
								
								
						 <tr>
						   <td width="5"></td>
						   <td>
								<td class="<%=(i==0)?"title_menu_first":"title_menu" %>"><a href="<%=categoryURL%>"><%= g.getName()%></a></td>
							</td>
						   <td width="5"></td>
						</tr>
						<%}%>		
						</table>
					</td>
				</tr>
				</table>
			</td>
			<td width="3px"></td>
		</tr>
		 
		</table>
	</td>
	<td width="4" align="right" background="<%= themeDisplay.getPathThemeImage() %>/DB_image/8.gif"></td>	
</tr>
			
<tr>
	<td width="4" align="left" height="5">
	<img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/6.gif" width="4" height="5"/></td>
	<td background="<%= themeDisplay.getPathThemeImage() %>/DB_image/4.gif" height="5"></td>
	<td width="4" align="right">
	<img src="<%= themeDisplay.getPathThemeImage() %>/DB_image/5.gif" width="4" height="5" /></td>	
</tr>
<tr><td height="4px" colspan="3"></td></tr>		
</table>
	
<%} else if (themeType.equals("2")) {%>															
	
	<table cellspacing="0" cellpadding="0" border="0" width="100%">
		<tr bgcolor="#FFFFFF">
			<td align="center">
				<img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/i_45.gif" />
			</td>			
		</tr>
		<tr>
			<td>
				<div><img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/i_46.gif" width="188" height="12"/></div>
			</td>			
		</tr>
		<tr>				 
		   <td align="left" valign="top" class="bg_04" height="300" style="padding-left:15px">
			<%	for (int i=0;i<contactList.size();i++){	
					FAQCategory g = (FAQCategory)contactList.get(i);
						categoryURL.setParameter("categoryId",String.valueOf(g.getId()));								
			%>
		   		
			   		<a class="menuleft2" href="<%=categoryURL%>">		   
			   			<%= g.getName()%>
			   		</a>
			   	<br/>
			<%
				}
			%>
		   	</td>  
		</tr>
		<tr><td bgcolor="#CAE0FF" height="10"></td></tr>
		<tr height="5">
			<td bgcolor="#CAE0FF">
				<img src="<%= themeDisplay.getPathThemeImage() %>/HN_image/i_48.gif" width="100%" height="5"/>
			</td>
		</tr>
	</table>
						

<%}%>	