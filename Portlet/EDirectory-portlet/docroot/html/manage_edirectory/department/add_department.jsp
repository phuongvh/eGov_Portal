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
	
	List<EDDepartment> donvi = EDDepartmentLocalServiceUtil.getByParent(0);
	long count = EDDepartmentLocalServiceUtil.getEDDepartmentsCount();
%>

<portlet:actionURL name="addDepartment" var="addDepartmentURL"/>

<liferay-ui:tabs names="<%= tabsName %>" param="tab1" url="<%= portletURL.toString() %>">
	<aui:form name="fm" Method="post" action="<%= addDepartmentURL.toString() %>">
		<table >
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-agency") %></td>
				<td align="left"><aui:input name="name" label="" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-select.agency.parent") %></td>
				<td><aui:select name="parentId" label=""  style="width:200px">
						<aui:option value="0">---&nbsp;<%=LanguageUtil.get(pageContext, "managecontacts.agency.add-select.all.agency") %> &nbsp;---</aui:option>
						<% for(EDDepartment dv : donvi) {%>
							<aui:option value="<%= dv.getId() %>">  <%=dv.getName() %></aui:option>
							<%
								List<EDDepartment> donviByParent = EDDepartmentLocalServiceUtil.getByParent(dv.getId());
								if(!donviByParent.isEmpty()) {
								for(EDDepartment dv2 : donviByParent) {
							%>
								<aui:option  value="<%=dv2.getId() %>" > &nbsp;&nbsp;&nbsp;&nbsp; <%= dv2.getName() %> </aui:option>
				
								<%} %>
							<%} %>
					<% }%>
					</aui:select></td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-level") %></td>
				<td>	<aui:select name="level" label="" >
							<%for(int i = 0; i< count; i++){ %>
								<aui:option value="<%= i+1 %>"><%= i+1 %>  </aui:option>
							<%} %>
						</aui:select>  
				</td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-phone.number") %></td>
				<td><aui:input name="phone" label="" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-fax") %></td>
				<td><aui:input name="fax" label="" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-email") %></td>
				<td><aui:input name="email" label="" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-website") %></td>
				<td><aui:input name="website" label="" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-address") %></td>
				<td><aui:input name="address" label="" style="width:350px" />  </td>
			</tr>
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.agency.add-introduce") %></td>
				<td> <liferay-ui:input-textarea param="description"  /> </td>
			</tr>			
							 
		</table>
		
		
			<aui:button type="submit" value='<%=LanguageUtil.get(pageContext, "managecontacts.agency.add-button.save") %>'/>
			<aui:button type="button" value='<%=LanguageUtil.get(pageContext, "managecontacts.agency.add-button.cancel") %>' onClick="history.back();"/>	
	</aui:form>
</liferay-ui:tabs>







