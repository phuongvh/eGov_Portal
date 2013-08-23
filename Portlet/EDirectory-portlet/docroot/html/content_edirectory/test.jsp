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
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>

<%@ page import="javax.portlet.WindowState"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.lang.Integer" %>
<%@ page import="java.lang.Long" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>

<%@ page import="com.vportal.portlet.edirectory.action.ActionUtil" %>
<%@ page import="com.vportal.portlet.edirectory.model.EDEmployee" %>
<%@ page import="com.vportal.portlet.edirectory.model.EDDepartment" %>
<%@ page import="com.vportal.portlet.edirectory.model.EDFunction" %>
<%@ page import="com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil" %>
<%@ page import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil" %>
<%@ page import="com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("jspPage","/html/content_edirectory/test.jsp");
	int pages = 10	;
	int sPageNum = ParamUtil.getInteger(request, "pagenum", 1);		
%>

<portlet:actionURL name="getPageNum" var="getPageNumURL" ></portlet:actionURL>

<script language ="javascript">		
	function <portlet:namespace/>submitPageForm(numPage){
	    	var myform = document.<portlet:namespace />fm;
		if(numPage!=''){
			myform.<portlet:namespace/>pagenum.value=numPage;
		}
		myform.action="<%= getPageNumURL.toString() %>";
		myform.submit();
	}	
	function <portlet:namespace/>submitForm(){
		document.<portlet:namespace />fm.action="<%= searchURL.toString() %>";
		document.<portlet:namespace />fm.submit();
	}	
</script>
	<html>
	<body>
	<form action="" name="fm" Method="post">
	<input type="text" value="<%= sPageNum %>" />
	<table>
		<c:if test='<%= pages > 1 %>'>			
		<tr>
			<td class="text_none" height="40" align="left" colspan="3">
			<p>
				<strong>&nbsp;&nbsp;&nbsp;Trang&nbsp;&nbsp;</strong>
				<% 	
					if(sPageNum >1){
						int intPrev = sPageNum-1;%>
						<span><a class="style1" href="#" onclick="<portlet:namespace/>submitPageForm('<%=intPrev%>');" >&lsaquo;&lsaquo; Tr&#432;&#7899;c</a></span>
						
				<%
					}
				%>
					
				
				<% 
					for(int i = 1;i <= pages;i++){ 	
						if( i == sPageNum ){%>
<%-- 						<strong><a class="menu_left" href="#" onclick="<portlet:namespace/>submitPageForm('<%=i%>');" > <%=i%></a></strong> --%>

						
				<%
					}else{
				%>	
<%-- 						<strong><a class="text_download" href="#" onclick="<portlet:namespace/>submitPageForm('<%=i%>');" > <%=i%></a></strong> --%>

				<%
						}
				 	} 
			 	%>
			 	
					
				<% 	
					if(sPageNum < pages){
						int intNext = sPageNum + 1;
				%>
						<a class="text_download" href="#" onclick="<portlet:namespace/>submitPageForm('<%=intNext%>');"  >Ti&#7871;p &rsaquo;&rsaquo;</a>
				<%
					}
				%>		
			</td>
		</tr>
		</c:if>
	  </table>
	  </form>
	  </body>
</html>
