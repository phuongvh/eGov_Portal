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

<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/html/init.jsp" %>
<liferay-ui:error key="do-not-delete-department" message='<%=LanguageUtil.get(pageContext, "do-not-delete-department") %>' />


<%
	String tabsName = "tab.danhba.canbo";
			tabsName += ",tab.danhba.donvi";
			tabsName += ",tab.danhba.chucvu";
			
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	
	portletURL.setParameter("tab1", tab1);
	portletURL.setParameter("tab2", tab2);
	portletURL.setParameter("tab3", tab3);
	
	PortletURL deletedocumment = renderResponse.createActionURL();
	deletedocumment.setParameter(ActionRequest.ACTION_NAME, "deletestaff");
%>


<portlet:actionURL name="tabCanBo" var="tabCanBoURL" />
<portlet:actionURL name="tabDonVi" var="tabDonViURL" />


<liferay-ui:tabs names="<%= tabsName %>" param="tab1" url="<%=portletURL.toString()%>" > 
  <c:choose>
    	<c:when test='<%= tab1.equals("tab.danhba.donvi") %>'>
    		<%@ include file="/html/manage_edirectory/department/view_department.jsp" %>
    	</c:when>
    	<c:when test='<%= tab1.equals("tab.danhba.chucvu") %>'>
    		<%@ include file="/html/manage_edirectory/function/view_function.jsp" %>
    	</c:when>
    	<c:otherwise >
    		<%@ include file="/html/manage_edirectory/employee/view_employee.jsp" %>
    	</c:otherwise>
</c:choose>    
</liferay-ui:tabs>



