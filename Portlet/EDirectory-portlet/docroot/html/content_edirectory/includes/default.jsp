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
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactory"%>
<%@page import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDDepartment"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunction"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunctionEmployee"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="com.vportal.portlet.edirectory.model.EDEmployee" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<portlet:defineObjects/>
<tbody>
		<%	
			for (int i=0;i<employeeList.size();i++){	//Start for
				int stt = i + (currentPage-1) * 10;
				//System.out.println("STT: " + stt);
				EDEmployee employee = (EDEmployee)employeeList.get(i);
				EDFunctionEmployee functionEmployee = (EDFunctionEmployee)EDFunctionEmployeeLocalServiceUtil.getByEmployeeId(employee.getId()).get(0);
				EDFunction function = (EDFunction)EDFunctionLocalServiceUtil.getEDFunction(functionEmployee.getFunctionId());
				EDDepartment department =(EDDepartment) EDDepartmentLocalServiceUtil.getEDDepartment(employee.getDepartmentId());					
				//s.setParameter("empId", String.valueOf(employee.getId()));		//Thiet lap cac tham so truoc khi gui du lieu
		%>
			
				<tr>
					<td><%= stt>=9 ? String.valueOf(stt+1) : "0" + String.valueOf(stt+1)  %></td>
					<td><%= employee.getName()%></td>
					<td><%= function.getName()%></td>
					<td><%= employee.getWorkPhone()%></td>
					<td><%= employee.getHomePhone()%></td>
					<td><%= employee.getMobilePhone()%></td>
					<td>
					<a href="#"><%= employee.getEmail()%></a>
					</td>
				</tr>
				
					<%
					
			}//End for
			
					
		%>
			</tbody>
		<%
			if(employeeList.size() == 0){
		%>
			<tr >
			<td colspan="7">
		<% 
				out.println("<br><font color=red size=+1>" + LanguageUtil.get(pageContext,"message.display.table") + "</font></br>");
		%>
				</td>
			</tr>
		<%
			}
		%>

	