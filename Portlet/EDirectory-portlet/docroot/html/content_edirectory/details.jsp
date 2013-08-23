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
<%@include file="/html/init.jsp" %>
<%@page import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDDepartment"%>
<%@page import="com.vportal.portlet.edirectory.model.EDEmployee"%>
<%@page import="com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionDepartmentLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunctionDepartment"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunctionEmployee"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunction"%>
<%@page import="com.vportal.portlet.edirectory.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<% 
	String employeeId = ParamUtil.getString(request, "employeeId");
	EDEmployee employee = EDEmployeeLocalServiceUtil.getById(Long.valueOf(employeeId));
	EDDepartment depart = EDDepartmentLocalServiceUtil.getEDDepartment(employee.getDepartmentId());
	List<EDFunctionEmployee> functionEmployeeList = EDFunctionEmployeeLocalServiceUtil.getByEmployeeId(employee.getId());
	EDFunctionEmployee functionEmployee = (EDFunctionEmployee)functionEmployeeList.get(0);
	EDFunction function = EDFunctionLocalServiceUtil.getEDFunction(functionEmployee.getFunctionId());
%>
	
	
	
<table cellspacing="4" cellpadding="4" width="600" border="0">
	<tr>
		<td align=center >
		<b><font size="4">T&#243;m t&#7855;t ti&#7875;u s&#7917;</font></b><hr width="100%" color="#cc9933" size="1"></td>
	</tr>
	<tr>
		<td>

		<table cellspacing="0" cellpadding="1" width="584" align="center" bgcolor="#333333" border="0">
			<tr valign="center">
				<td class="newsheader" align="middle" bgcolor="#ffffff" height="199" rowspan="7">
				<strong>
				    <br><br>&nbsp;<p align='center'><img width="50%"  src="<%=themeDisplay.getPathImage()%>/EDirectory-portlet?img_id=<%= employee.getImage() %>" name="<%= employee.getImage() %>"></p><p><br><br>&nbsp;
				</strong></td>
				<td align="left" bgcolor="#ffffff" height="15" width="142">
				<b><%= LanguageUtil.get(pageContext, "content.contact.name") %></b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="15" width="258">
				<p align="left"><%= employee.getName() %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="11" width="142">
				<b><%= LanguageUtil.get(pageContext, "content.contact.birthday") %>:</b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="11" width="258">
				<%= ActionUtil.parseDateToString(employee.getBirthday()) %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="11" width="142">
				<b>
				<span class="gen"><%= LanguageUtil.get(pageContext, "content.contact.sex") %>:</span></b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="11" width="258">
				<%= employee.getSex() %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="24" width="142">
				<b><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-country") %></b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="24" width="255">
				<%= employee.getHomeSide() %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="11" width="142">
				<b><%= LanguageUtil.get(pageContext, "content.contact.address") %></b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="11" width="258">
				<%= employee.getHome() %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="11" width="142">
				<b><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-people") %> </b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="11" width="258">
				<%= employee.getPhilosophism() %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="19">
				<b><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-qualifications")%></b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="11" width="400" colspan="2">
				<%= employee.getMajorLevel() %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="19">
				<b><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-position")%></b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="11" width="400" colspan="2">
				<%= function.getName() %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="19">
				<b><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-agency")%></b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="11" width="400" colspan="2">
				<%= depart.getName() %></td>
			</tr>
			<tr valign="center">
				<td  align="left" bgcolor="#ffffff" height="19">
				<b><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-date-join-party")%></b></td>
				<td class="newsheader" align="left" bgcolor="#ffffff" height="11" width="400" colspan="2">
				<%=ActionUtil.parseDateToString(employee.getJoinDate()) %></td>
			</tr>
			
			</table>

		</td>
	</tr>
</table>
