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
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunction"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunctionEmployee"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.edirectory.model.EDEmployee"%>
<div id="div_content">
<table style="width: 100%">
	
		<% EDEmployee  employee = null;
		PortletURL p = renderResponse.createRenderURL();
		p.setParameter("jspPage", "/html/content_edirectory/details.jsp");
		if(currentPage==1 && test == true){
			test = false;
		
		 	employee = (EDEmployee)employeeList.get(0);
		 	List<EDFunctionEmployee> functionEmployeeList = EDFunctionEmployeeLocalServiceUtil.getByEmployeeId(employee.getId());
			EDFunctionEmployee functionEmployee = (EDFunctionEmployee)functionEmployeeList.get(0);
			EDFunction function = EDFunctionLocalServiceUtil.getEDFunction(functionEmployee.getFunctionId());
			p.setParameter("employeeId",String.valueOf(employee.getId()));
		 	%>
		 	<tr>
				<td align="center" width="100%" colspan="3">
				<a href="<%= p.toString()%>"><img width="50%"  src="<%=themeDisplay.getPathImage()%>/EDirectory-portlet?img_id=<%= employee.getImage() %>" name="<%= employee.getImage() %>" ></a>
				<br/>
				<%= employee.getName() %>
				<%= function.getName() %>
				</td>
			</tr>
		 	<%} %>
			
	
	<%	int tong = employeeList.size();
	int conlai = (!test) ? tong - 1 : tong;
int sodong = (conlai % 3 == 0) ? conlai / 3 : conlai / 3 +1;
int soo = 3;
int check = 0;
for (int i=1;i<=sodong;i++){

	%>
	<tr>
		<%for (int j=1;j<=soo;j++){
			
			if(check<conlai && !test){
				check+=1;
				employee = employeeList.get(check);
				List<EDFunctionEmployee> functionEmployeeList = EDFunctionEmployeeLocalServiceUtil.getByEmployeeId(employee.getId());
				EDFunctionEmployee functionEmployee = (EDFunctionEmployee)functionEmployeeList.get(0);
				EDFunction function = EDFunctionLocalServiceUtil.getEDFunction(functionEmployee.getFunctionId());
			%>
		<td width="30%" align="center">
			
			<br/>
			<a href="<%= p.toString()%>"><img width="50%"  src="<%=themeDisplay.getPathImage()%>/EDirectory-portlet?img_id=<%= employee.getImage() %>" name="<%= employee.getImage() %>"></a>
			<br/>
			<%=employee.getName() %>
				<br/>
				<%= function.getName() %>
			
				
		</td>
		<%}
			if( check<conlai && test==true) {employee = employeeList.get(check);
			List<EDFunctionEmployee> functionEmployeeList = EDFunctionEmployeeLocalServiceUtil.getByEmployeeId(employee.getId());
			EDFunctionEmployee functionEmployee = (EDFunctionEmployee)functionEmployeeList.get(0);
			EDFunction function = EDFunctionLocalServiceUtil.getEDFunction(functionEmployee.getFunctionId());
			check+=1;%>
				<td width="30%" align="center">
		
			<br/>
			<a href="<%= p.toString()%>"><img width="50%"  src="<%=themeDisplay.getPathImage()%>/EDirectory-portlet?img_id=<%= employee.getImage() %>" name="<%= employee.getImage() %>"></a>
			<br/>
				<%=employee.getName() %>
				<br/>
				<%= function.getName() %>
		</td>
			
		<%	}} %>
	</tr>
<%} %>
</table>
</div>