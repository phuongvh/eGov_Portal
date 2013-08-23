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
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDDepartment" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/html/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%
	String tabsName = "tab.danhba.chucvu";
						
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);	
	portletURL.setParameter("tab1", tab1);
	
	long funcId = Long.valueOf(renderRequest.getParameter("resourcePrimKey"));
	EDFunction func = EDFunctionLocalServiceUtil.getEDFunction(funcId);
	
	int count = EDFunctionLocalServiceUtil.getEDFunctionsCount();
%>


<portlet:actionURL name="updateFunction" var="updateFunctionURL" />

<liferay-ui:tabs names="<%= tabsName %>" param="tab1" url="<%= portletURL.toString() %>" > 

	<aui:form name="fm" Method="post" action="<%= updateFunctionURL.toString() %>">
		<input type="hidden" name="funcId" value="<%=funcId %>" />
		<input type="hidden" name="languageId" value="vi_VN" />
		<input type="hidden" name="show" value="true" />
		<table >
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.position.add-position") %></td>
				<td><aui:input name="name" label="" value="<%= func.getName() %>" style="width:350px"/>  </td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.position.add-introduce") %></td>
				<td> <liferay-ui:input-textarea param="description" defaultValue="<%= func.getDescription() %>"/> </td>
			</tr>	
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.position.add-level") %></td>
				<td>	<aui:select name="level" label="" >
							<%for(int i = 0; i< count; i++){ %>
								<aui:option value="<%= i + 1 %>" selected="<%= (func.getLevelEd() == i + 1) %>" > <%= i+ 1%> </aui:option>
							<%} %>
						</aui:select>  
				</td>
			</tr>			 
		</table>
		
			<aui:button type="submit" value='<%= LanguageUtil.get(pageContext, "managecontacts.position.add-button.save") %>'/>
			<aui:button type="button" value='<%= LanguageUtil.get(pageContext, "managecontacts.position.add-button.cancel") %>' onClick="history.back();"/>	
	</aui:form>
</liferay-ui:tabs>

















