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
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.edirectory.model.EDDepartment" %>
<%@page import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/html/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%
	String tabsName = "tab.danhba.donvi";
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);	
	portletURL.setParameter("tab1", tab1);
	
	List<EDDepartment> depList = EDDepartmentLocalServiceUtil.getByParent(0);
	long count = EDDepartmentLocalServiceUtil.getEDDepartmentsCount();
	
	long departmentId = Long.valueOf(renderRequest.getParameter("resourcePrimKey"));
	EDDepartment dep = EDDepartmentLocalServiceUtil.getEDDepartment(departmentId);
%>

<portlet:actionURL name="updateDepartment" var="updateDepartmentURL"/>

<liferay-ui:tabs names="<%= tabsName %>" param="tab1" url="<%= portletURL.toString() %>">
	<aui:form name="fm" Method="post" action="<%= updateDepartmentURL.toString() %>">
	<aui:input name="depId" value="<%= dep.getId() %>" type="hidden"/>
		<table >
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-agency") %></td>
				<td align="left"><aui:input name="name" label="" value="<%= dep.getName() %>"  style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-select.agency.parent") %></td>
				<td><aui:select name="parentId" label=""  style="width:200px">
						<aui:option value="0">---&nbsp;<%=LanguageUtil.get(pageContext, "managecontacts.agency.add-select.all.agency") %> &nbsp;---</aui:option>
						<% for(EDDepartment dep1 : depList) {%>
							<aui:option value="<%= dep1.getId() %>" selected="<%= (dep1.getId() == dep.getParent()) %>">  <%=dep1.getName() %></aui:option>
							<%
								List<EDDepartment> depByParent = EDDepartmentLocalServiceUtil.getByParent(dep1.getId());
								if(!depByParent.isEmpty()) {
								for(EDDepartment dep2 : depByParent) {
							%>
								<aui:option  value="<%=dep2.getId() %>" selected="<%= (dep2.getId() == dep.getParent()) %>" > &nbsp;&nbsp;&nbsp;&nbsp; <%= dep2.getName() %> </aui:option>
				
								<%} %>
							<%} %>
					<% }%>
					</aui:select></td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-level") %></td>
				<td>	<aui:select name="level" label="" >
							<%for(int i = 0; i< count; i++){ %>
								<aui:option value="<%= i+1 %>" selected="<%= (dep.getLevelEd() == (i+1)) %>" ><%= i+1 %>  </aui:option>
							<%} %>
						</aui:select>  
				</td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-phone.number") %></td>
				<td><aui:input name="phone" label="" value="<%= dep.getPhone() %>" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-fax") %></td>
				<td><aui:input name="fax" label="" value="<%= dep.getFax() %>" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-email") %></td>
				<td><aui:input name="email" label="" value="<%= dep.getEmail() %>" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-website") %></td>
				<td><aui:input name="website" label="" value="<%= dep.getWebsite() %>"  style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-address") %></td>
				<td><aui:input name="address" label="" value="<%= dep.getAddress() %>"  style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-introduce") %></td>
				<td> <liferay-ui:input-textarea param="description" defaultValue="<%= dep.getDescription() %>" /> </td>
			</tr>			
							 
		</table>
		
		
			<aui:button type="submit" value='<%=LanguageUtil.get(pageContext, "managecontacts.agency.add-button.save") %>'/>
			<aui:button type="button" value='<%=LanguageUtil.get(pageContext, "managecontacts.agency.add-button.cancel") %>' onClick="history.back();"/>	
	</aui:form>
</liferay-ui:tabs>







