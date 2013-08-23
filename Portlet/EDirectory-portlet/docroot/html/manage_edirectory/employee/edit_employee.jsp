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
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunction"%>
<%@page import="com.vportal.portlet.edirectory.model.EDEmployee"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionEmployeeLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunctionEmployee"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDDepartment" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@include file="/html/init.jsp"%>

<%
	String tabsName = "tab.danhba.canbo";
						
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);	
	portletURL.setParameter("tab1", tab1);
	
	long employeeId = Long.valueOf(renderRequest.getParameter("resourcePrimKey"));
	EDEmployee employee = EDEmployeeLocalServiceUtil.getEDEmployee(employeeId);
	List<EDFunctionEmployee> functionsOfEmployee = EDFunctionEmployeeLocalServiceUtil.getByEmployeeId(employeeId);
	String show[] = employee.getShow().split(",");
	
	Calendar calendar = GregorianCalendar.getInstance();
	calendar.setTime(employee.getBirthday());
	int dayDOB = calendar.get(Calendar.DAY_OF_MONTH);
	int monthDOB = calendar.get(Calendar.MONTH);
	int yearDOB = calendar.get(Calendar.YEAR);
	
	calendar.setTime(employee.getJoinDate());
	int dayJoinDate = calendar.get(Calendar.DAY_OF_MONTH);
	int monthJoinDate = calendar.get(Calendar.MONTH);
	int yearJoinDate = calendar.get(Calendar.YEAR);
	
	List<EDDepartment> departments = EDDepartmentLocalServiceUtil.getByParent(0);
	List<EDFunction> functions = EDFunctionLocalServiceUtil.getAllFunction();
	int count = EDEmployeeLocalServiceUtil.getEDEmployeesCount();
	
%>


<portlet:actionURL name="updateEmployee" var="updateEmployeeURL" />

<liferay-ui:tabs names="<%= tabsName %>" param="tab1" url="<%= portletURL.toString() %>" > 


	<aui:form name="fm" Method="post" action="<%= updateEmployeeURL.toString() %>" enctype="multipart/form-data">
	<aui:input type="hidden" name="employeeId" value="<%= employee.getId() %>"/>
	<table style="width: 100%">	
	<tr>
		<td width="70%">
		<table style="width: 100%">
			<tr>
	  			<td>
	  			</td>
	  			<td>
	  			</td>
	  			<td >
	    			Tr&#7841;ng th&#225;i hi&#7879;n
	  			</td>
			</tr>
			
			<tr style="padding: 10px" height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-appellation") %></td>
				<td align="left"> <aui:select name="title" label="" >
										<aui:option value="Ông" selected="<%= employee.getTitle().equals(\"Ông\")%>" > <%=LanguageUtil.get(pageContext, "managecontacts.staff.add-appellation-mr") %> </aui:option>
										<aui:option value="Bà" selected="<%= employee.getTitle().equals(\"Bà\")%>" ><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-appellation-mrs") %></aui:option>
								</aui:select>   
				</td>
				<td></td>
			</tr>
						
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-name") %></td>
				<td align="left"> <aui:input name="name" value="<%= employee.getName() %>" type="text" label="" style="width:350px"></aui:input> </td>
				<td></td>
			</tr>
			<%
   				Calendar cal = CalendarFactoryUtil.getCalendar();   			
    		%>
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-birthday") %></td>
				<td align="left"> <liferay-ui:input-date 
 								disableNamespace="<%= true %>" 
								dayParam="dayDOB"
								dayValue="<%= dayDOB %>"
								monthParam="monthDOB"
								monthValue="<%= monthDOB %>"
								yearParam="yearDOB"
								yearValue="<%= yearDOB %>"
								yearRangeStart="<%= cal.get(Calendar.YEAR) - 100 %>"
								yearRangeEnd="<%= cal.get(Calendar.YEAR) %>" 
								firstDayOfWeek="<%= cal.getFirstDayOfWeek() - 1 %>"
                            	disabled="<%= false %>"
								 />
				 
				</td>
				<td></td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-gender") %></td>
				<td align="left"> <aui:select name="sex" label="" style="width: 75px">
										<aui:option value="1" selected="<%= employee.getSex().equals(\"1\") %>"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-gender.male") %> &nbsp; </aui:option>
										<aui:option value="2" selected="<%= employee.getSex().equals(\"2\") %>"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-gender.female") %>&nbsp;</aui:option>
								</aui:select>   
				</td>
				<td></td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-country") %></td>
				<td align="left"><aui:input name="homeSide" value="<%= employee.getHomeSide() %>" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckhomeSide" <%=(show!=null&&show[0].equals("true"))?"checked":"" %> />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-people") %></td>
				<td align="left"><aui:input name="race" value="<%= employee.getRace() %>" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckrace" <%=(show!=null&&show[1].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-diaspora") %></td>
				<td align="left"><aui:input name="home" value="<%= employee.getHome() %>" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckhome" <%=(show!=null&&show[2].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-home.phone") %></td>
				<td align="left"><aui:input name="homePhone" value="<%= employee.getHomePhone() %>" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckhomePhone" <%=(show!=null&&show[3].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-agency.phone") %></td>
				<td align="left"><aui:input name="workPhone" value="<%= employee.getWorkPhone() %>" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckworkPhone" <%=(show!=null&&show[4].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-mobile.phone") %></td>
				<td align="left"><aui:input name="mobilePhone" value="<%= employee.getMobilePhone() %>" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckmobilePhone" <%=(show!=null&&show[5].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-email") %></td>
				<td align="left"><aui:input name="email" value="<%= employee.getEmail() %>" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckemail" <%=(show!=null&&show[6].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td  width="20%" style="font: bold;"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-position")%></td>
				<td align="left"> <select name="functionId" size="5" multiple="multiple" style="width:200px">
									<%for(EDFunction func : functions){ %>
									<option value="<%= func.getId() %>"
									<%for(EDFunctionEmployee fe : functionsOfEmployee){ %>
										<%= func.getId()==fe.getFunctionId()? " selected=\"selected\"" : "" %>  
									<%} %> > 
									<%= func.getName() %>
									</option>
									<%} %>
								</select> 
				</td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckfunctionId" <%=(show!=null&&show[7].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
						
			<tr height="30">
				<td width="20%" style="font:bold; "><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-agency")%></td>
				<td align="left"> <aui:select name="departmentId" label="" style="width:200px" >
									<aui:option value="0">---&nbsp;<%= LanguageUtil.get(pageContext, "managecontacts.staff.view-select.all-agency")%> &nbsp;---</aui:option>
										<% for(EDDepartment dep1 : departments) {%>
											<aui:option value="<%= dep1.getId() %>" selected="<%=(employee.getDepartmentId() == dep1.getId()) %>">  <%= dep1.getName() %></aui:option>
											<%
												List<EDDepartment> donviByParent = EDDepartmentLocalServiceUtil.getByParent(dep1.getId());
												if(!donviByParent.isEmpty()) {
												for(EDDepartment dep2 : donviByParent) {
											%>
												<aui:option  value="<%=dep2.getId() %>" selected="<%= (employee.getDepartmentId() == dep2.getId()) %>" > &nbsp;&nbsp;&nbsp;&nbsp; <%= dep2.getName() %> </aui:option>
				
											<%} %>
										<%} %>
								<% }%>
								</aui:select>
				</td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckdepartmentId" <%=(show!=null&&show[8].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			<!-- Add image -->
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-image")%></td>
				<td align="left"><vportal:file-upload entryId="<%= GetterUtil.getLong(employeeId,0) %>" entryClass="<%=EDEmployee.class%>" style="2" />  </td>
				
				<td align="center">
		  			<input type="checkbox" value="true" name="ckbigPhoto" <%=(show!=null&&show[9].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-qualifications")%></td>
				<td align="left"><aui:input name="majorLevel" value="<%= employee.getMajorLevel() %>" label="" style="width:350px" />  </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckmajorLevel" <%=(show!=null&&show[10].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-political-theory")%></td>
				<td align="left"><aui:input name="philosophism" value="<%= employee.getPhilosophism() %>" label="" style="width:350px" />  </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckphilosophism" <%=(show!=null&&show[11].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-family")%></td>
				<td align="left"><aui:input name="family" value="<%= employee.getFamily() %>" label="" style="width:350px" />  </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckfamily" <%=(show!=null&&show[12].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-foreign-language")%></td>
				<td align="left"><aui:input name="foreignLanguage" value="<%= employee.getForeignLanguage() %>" label="" style="width:350px" />  </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckforeignLanguage" <%=(show!=null&&show[13].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-date-join-party")%></td>
				<td align="left"> <liferay-ui:input-date 
 								disableNamespace="<%= true %>"
 								dayParam="dayJoinDate"
 								dayValue="<%= dayJoinDate %>" 
								monthParam="monthJoinDate"
								monthValue="<%= monthJoinDate %>"
								yearParam="yearJoinDate"
								yearValue="<%= yearJoinDate %>"
								yearRangeStart="<%= cal.get(Calendar.YEAR) - 100 %>"
								yearRangeEnd="<%= cal.get(Calendar.YEAR) %>" 
								firstDayOfWeek="<%= cal.getFirstDayOfWeek() - 1 %>"
                            	disabled="<%= false %>"
								 />				 
				</td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckjoinDate" <%=(show!=null&&show[14].equals("true"))?"checked":"" %>/>
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-information")%></td>
				<td align="left"></td>
			</tr>
			<tr height="30">
				<td  width="20%"> </td>
				<td align="left"><liferay-ui:input-editor name="otherInfo"  ></liferay-ui:input-editor> </td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-display-in-tree-contacts")%></td>
				<td>	
					
					<input name="isShowTree" type="radio"  value="1" <%=(employee.getIsShowTree() == true)? "checked=checked" : "" %> /> &nbsp; <%=LanguageUtil.get(pageContext, "managecontacts.staff.add-display-in-tree-contacts.YES")%>
					<input name="isShowTree" type="radio"  value="0" <%=(employee.getIsShowTree() == false)? "checked=checked" : "" %>/> &nbsp; <%=LanguageUtil.get(pageContext, "managecontacts.staff.add-display-in-tree-contacts.NO")%>
				 </td>			 
			</tr>	
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-level")%></td>
				<td> <aui:select name="order" label="">
						<% for(int i = 0; i < count; i++){ %>
							<aui:option value="<%= i+1 %>" selected="<%= (employee.getDisplayOrder() == (i+1)) %>" > <%=i+1 %> </aui:option>
						<%} %>
				</aui:select> </td>
			</tr>
			
<!-- 			<tr height="30"> -->
<!-- 				<td>Ch&#7885;n tr&#7841;ng th&#225;i</td> -->
<!-- 				<td> -->
<%-- 					<select name="<portlet:namespace/>status"> --%>
<!-- 						<option></option> -->
<!-- 						<option value="0">L&#227;nh &#273;&#7841;o hi&#7879;n t&#7841;i</option> -->
<!-- 						<option value="1">L&#227;nh &#273;&#7841;o qua c&#225;c th&#7901;i k&#236;</option> -->
<!-- 						<option value="2">C&#7909;c tr&#432;&#7903;ng d&#7921; tr&#7919; chuy&#234;n ngh&#224;nh</option> -->
<!-- 					</select> -->
<!-- 				</td> -->
<!-- 			</tr>								  -->
		</table>
		</td>
		
		<td valign="top">
			
		</td>
	</tr>
	</table>
	<br/><br/>
		
		<aui:button type="submit" value='<%=LanguageUtil.get(pageContext, "managecontacts.staff.add-button.save")%>'/>
		<aui:button type="button" value='<%=LanguageUtil.get(pageContext, "managecontacts.staff.add-button.cancel")%>' onClick="history.back();"/>		
	</aui:form>
</liferay-ui:tabs>

















