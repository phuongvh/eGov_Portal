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

<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocOrgServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDORelServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.action.VDocManage"%>
<%@page import="com.vportal.portlet.vdoc.model.vdocOrg"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDORelServiceUtil"%>
<%@page import="com.vportal.portlet.vdoc.service.vdocDocumentServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<script language ="javascript">
	function showTag(tag){
		var abc = document.getElementById(tag);
		
		if(abc.style.display=="none"){
			jQuery(abc).show();
		}else{
			jQuery(abc).hide();
		}
	}		
</script>

<%	
	Calendar currentDate = new GregorianCalendar();
	 curYear = currentDate.get(Calendar.YEAR);
	 curMonth = currentDate.get(Calendar.MONTH);
	curDay = currentDate.get(Calendar.DATE);
	
	int fromDay = ParamUtil.getInteger(request, "fromDay", curDay);
	int fromMonth = ParamUtil.getInteger(request, "fromMonth", curMonth);
	int fromYear = ParamUtil.getInteger(request, "fromYear", curYear-1);
	
	int toDay = ParamUtil.getInteger(request, "toDay", curDay+1);
	int toMonth = ParamUtil.getInteger(request, "toMonth", curMonth);
	int toYear = ParamUtil.getInteger(request, "toYear", curYear);	
	
		// Convert Date...
	
	Date dateFrom  = new GregorianCalendar(fromYear, fromMonth, fromDay).getTime();
	
	Date dateTo = new GregorianCalendar(toYear, toMonth, toDay).getTime();
	
	String byUser = ParamUtil.getString(request,"byUser",null);	
	List listOrg = vdocOrgServiceUtil.getOrgByG_L(groupId, language);
	int choxuatban =	vdocDocumentServiceUtil.countDocByG_L_S(groupId, language, 0);
	int daxuyet =	vdocDocumentServiceUtil.countDocByG_L_S(groupId, language, 1);
	int daxuatban =	vdocDocumentServiceUtil.countDocByG_L_S(groupId, language, 2);
%>



<br/>

<table width="100%" border="1" bordercolor="#999999">
	<tr height="30" bgcolor="#CCCCCC">
		<td width="5%" align="center"><b><%= LanguageUtil.get(pageContext, "portlet.vdoc.report.stt") %></b></td>
		<td width="35%"><b>&nbsp;<%= LanguageUtil.get(pageContext, "portlet.vdoc.report.category") %></b></td>
		<td width="60%">
			<table width="100%" width="100%" >
				<tr height="30">
					<td style="border-right: 1px solid #999999; text-align: center;"><%= LanguageUtil.get(pageContext, "portlet.vdoc.report.approving") %></td>
					<td style="border-right: 1px solid #999999; text-align: center;"><%= LanguageUtil.get(pageContext, "portlet.vdoc.report.approved") %></td>
					<td style="border-right: 1px solid #999999; text-align: center;"><%= LanguageUtil.get(pageContext, "portlet.vdoc.report.modify") %></td>
				</tr>
			</table>			
		</td>	
	</tr>
</table>

<table width="100%">
	<%for (int i=0;i<listOrg.size();i++){ 
			vdocOrg org = (vdocOrg)listOrg.get(i);
		
		%>
	<tr>
		<td align="center" width="5%">
		
			<b><%= i+1 %></b>
			
		</td>
		<td  width="35%">
			<b><%=org.getName()%></b>
		</td>	
		<td  width="60%">
			<table width="100%" width="100%">
				<tr height="30">
					<td style="width:33%; text-align: center;"><%=vdocDORelServiceUtil.countCategory_approving(org.getOrgId()) %></td>
					<td style=" text-align: center;"><%=vdocDORelServiceUtil.countCategory_public(org.getOrgId()) %></td>
					<td style=" text-align: center;"><%=vdocDORelServiceUtil.countCategory_modify(org.getOrgId()) %></td>
				</tr>
			</table>
		</td>
		<%} %>												
	</tr>
</table>



<br/>
<portlet:actionURL name="exportToExcel" var="exportToExcelUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="language" value="<%=language%>"></portlet:param>
	<portlet:param name="groupId" value="<%=String.valueOf(groupId)%>"></portlet:param>
	<portlet:param name="cmd" value="reportByOrg"></portlet:param>
	
	
</portlet:actionURL>
<br/>
<a href="<%=exportToExcelUrl.toString() %>">
	<input name="btnExport" type="button" value="Xu&#7845;t b&#225;o c&#225;o" />
</a>
