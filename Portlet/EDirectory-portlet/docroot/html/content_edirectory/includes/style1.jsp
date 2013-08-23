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
<%@page import="com.vportal.portlet.edirectory.model.EDFunctionEmployee"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunction"%>
<%@page import="com.vportal.portlet.edirectory.model.EDDepartment"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="com.vportal.portlet.edirectory.model.EDEmployee"%>

<div id="div_content">
		<table id="tb_content" style="border-style:none;">
			<tr id="tr_content">
				<td align="center">
					<span class="title_tenthutuc">H&#7885; v&#224; t&#234;n</span>
				</td>
				<td align="center" style="width: 20%;">
					<span class="title_coquanthuchien">Ph&#242;ng ban</span>
				</td>
				<td align="center" style="width: 15%;">
					<span class="title_taive">Ch&#7913;c v&#7909;</span>
				</td>
				<td align="center" style="width: 25%;">
					<span class="title_taive">Email</span>
				</td>
				
			</tr>
			
		<%	for (int i=0;i<employeeList.size();i++){
			EDEmployee employee = (EDEmployee)employeeList.get(i);
			EDFunctionEmployee functionEmployee = (EDFunctionEmployee)EDFunctionEmployeeLocalServiceUtil.getByEmployeeId(employee.getId()).get(0);
			EDFunction function = (EDFunction)EDFunctionLocalServiceUtil.getEDFunction(functionEmployee.getFunctionId());
			EDDepartment department = EDDepartmentLocalServiceUtil.getEDDepartment(employee.getDepartmentId());
			
						
						
		%>
							<tr id="tr_content_01">
								<td><div style="margin:7px;" align="left"><span class="thutuc01"><%= employee.getName()%></span> </div></td>
								<td style="width: 20%"><div style="margin:7px;" align="left"><span class="coquanthuchien01"><%=department.getName()%></span></div></td>
								<td align="center" style="width: 15%"><div style="margin:7px;" align="left"><span class="coquanthuchien01"><%=function.getName()%></span></div></td>
								<td align="center" style="width: 25%"><div style="margin:7px;" align="left"><span class="coquanthuchien01"><%=employee.getEmail()%></span></div></td>
								
							</tr>
		<%
					
					
		}
					
			
		%>
		

			
		</table>
	</div>