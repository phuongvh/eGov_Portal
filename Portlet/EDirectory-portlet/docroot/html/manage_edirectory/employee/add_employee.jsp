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
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.vportal.portlet.edirectory.service.EDFunctionLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDEmployee"%>
<%@page import="com.vportal.portlet.edirectory.model.EDFunction"%>
<%@page import="com.vportal.portlet.edirectory.util.WebKeysExt"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDEmployeeLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.service.EDDepartmentLocalServiceUtil"%>
<%@page import="com.vportal.portlet.edirectory.model.EDDepartment" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@include file="/html/init.jsp" %>
<%
	String tabsName = "tab.danhba.canbo";
	long groudId = themeDisplay.getPortletGroupId();
	System.out.println("Add GroupId: " + groudId);
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);	
	portletURL.setParameter("tab1", tab1);
	
	List<EDDepartment> departments = EDDepartmentLocalServiceUtil.getByParent(0);
	List<EDFunction> functions = EDFunctionLocalServiceUtil.getAllFunction();
	int count = EDEmployeeLocalServiceUtil.getEDEmployeesCount();
	
	List attachmentList = (List)request.getAttribute("EMPLOYEE_ATTACHMENTS");
	//List attachmentList = (List)request.getAttribute(WebKeysVClip.VCLIP_LIST_ATTACHMENT);
%>

<%-- <portlet:actionURL name="tabCanBo" var="tabCanBoURL" /> --%>
<portlet:actionURL name="addEmployee" var="addEmployeeURL" />

<liferay-ui:tabs names="<%= tabsName %>" param="tab1" url="<%= portletURL.toString() %>" > 

<form name="fm" Method="post" action="<%= addEmployeeURL.toString() %>" enctype="multipart/form-data">
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
										<aui:option value="Ông"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-appellation-mr") %></aui:option>
										<aui:option value="Bà"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-appellation-mrs") %></aui:option>
								</aui:select>   
				</td>
				<td></td>
			</tr>
						
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-name") %></td>
				<td align="left"> <aui:input name="name" type="text" label="" style="width:350px"></aui:input> </td>
				<td></td>
			</tr>
			<%
   				Calendar cal = CalendarFactoryUtil.getCalendar();   			
    		%>
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-birthday") %></td>
				<td align="left"> <liferay-ui:input-date 
 								disableNamespace="<%= true %>" 
								monthParam="monthDOB"
								dayParam="dayDOB"
								yearParam="yearDOB"
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
										<aui:option value="1"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-gender.male") %> &nbsp; </aui:option>
										<aui:option value="2"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-gender.female") %>&nbsp;</aui:option>
								</aui:select>   
				</td>
				<td></td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-country") %></td>
				<td align="left"><aui:input name="homeSide" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckhomeSide" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-people") %></td>
				<td align="left"><aui:input name="race" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckrace" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-diaspora") %></td>
				<td align="left"><aui:input name="home" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckhome" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-home.phone") %></td>
				<td align="left"><aui:input name="homePhone" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckhomePhone" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-agency.phone") %></td>
				<td align="left"><aui:input name="workPhone" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckworkPhone" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-mobile.phone") %></td>
				<td align="left"><aui:input name="mobilePhone" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckmobilePhone" />
				</td>
			</tr>
			<!-- Email -->
			<tr height="30">
				<td width="20%"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-email") %></td>
				<td align="left"><aui:input name="email" type="text" label="" style="width:350px"></aui:input> </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckemail" />
				</td>
			</tr>
			
			<!-- Chức vụ -->
			<tr height="30">
				<td  width="20%" style="font: bold;"><%= LanguageUtil.get(pageContext, "managecontacts.staff.add-position")%></td>
				<td align="left"> <aui:select name="functionId" size="5" label="" multiple="true" style="width:200px">
									<%for(EDFunction func : functions){ %>
									<aui:option value="<%= func.getId() %>"> <%= func.getName() %></aui:option>
									<%} %>
								</aui:select> 
				</td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckfunctionId" />
				</td>
			</tr>
					
			<!-- Đơn vị -->	
			<tr height="30">
				<td width="20%" style="font:bold; "><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-agency")%></td>
				<td align="left"> <aui:select name="departmentId" label="" style="width:200px" >
									<aui:option value="0">---&nbsp;<%= LanguageUtil.get(pageContext, "managecontacts.staff.view-select.all-agency")%> &nbsp;---</aui:option>
										<% for(EDDepartment dep1 : departments) {%>
											<aui:option value="<%= dep1.getId() %>">  <%= dep1.getName() %></aui:option>
											<%
												List<EDDepartment> donviByParent = EDDepartmentLocalServiceUtil.getByParent(dep1.getId());
												if(!donviByParent.isEmpty()) {
												for(EDDepartment dep2 : donviByParent) {
											%>
												<aui:option  value="<%=dep2.getId() %>" > &nbsp;&nbsp;&nbsp;&nbsp; <%= dep2.getName() %> </aui:option>
				
											<%} %>
										<%} %>
								<% }%>
								</aui:select>
				</td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckdepartmentId" />
				</td>
			</tr>
<!-- Upload Image -->
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-image")%></td>
				<td align="left">
<%-- 				<aui:input name="bigPhoto" type="file" label=""></aui:input>   --%>
				<vportal:file-upload entryId="<%= GetterUtil.getLong(0,0) %>" entryClass="<%=EDEmployee.class%>" style="2" />
					
				</td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckbigPhoto" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-qualifications")%></td>
				<td align="left"><aui:input name="majorLevel" label="" style="width:350px" />  </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckmajorLevel" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-political-theory")%></td>
				<td align="left"><aui:input name="philosophism" label="" style="width:350px" />  </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckphilosophism" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-family")%></td>
				<td align="left"><aui:input name="family" label="" style="width:350px" />  </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckfamily" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-foreign-language")%></td>
				<td align="left"><aui:input name="foreignLanguage" label="" style="width:350px" />  </td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckforeignLanguage" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-date-join-party")%></td>
				<td align="left"> <liferay-ui:input-date 
 								disableNamespace="<%= true %>" 
								monthParam="monthJoinDate"
								dayParam="dayJoinDate"
								yearParam="yearJoinDate"
								yearRangeStart="<%= cal.get(Calendar.YEAR) - 100 %>"
								yearRangeEnd="<%= cal.get(Calendar.YEAR) %>" 
								firstDayOfWeek="<%= cal.getFirstDayOfWeek() - 1 %>"
                            	disabled="<%= false %>"
								 />				 
				</td>
				<td align="center">
		  			<input type="checkbox" value="true" name="ckjoinDate" />
				</td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-information")%></td>
				<td align="left"></td>
			</tr>
			<tr height="30">
				<td  width="20%"> </td>
				<td align="left"><liferay-ui:input-editor name="otherInfo" ></liferay-ui:input-editor> </td>
			</tr>
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-display-in-tree-contacts")%></td>
				<td>	
					<input name="isShowTree" type="radio" checked="checked"  value="1"/> &nbsp; <%=LanguageUtil.get(pageContext, "managecontacts.staff.add-display-in-tree-contacts.YES")%>
					<input name="isShowTree" type="radio"  value="0"/> &nbsp; <%=LanguageUtil.get(pageContext, "managecontacts.staff.add-display-in-tree-contacts.NO")%>
				 </td>			 
			</tr>	
			
			<tr height="30">
				<td width="20%"><%=LanguageUtil.get(pageContext, "managecontacts.staff.add-level")%></td>
				<td> <aui:select name="order" label="">
						<% for(int i = 0; i < count; i++){ %>
							<aui:option value="<%= i+1 %>" > <%=i+1 %> </aui:option>
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
	</form>
</liferay-ui:tabs>

















