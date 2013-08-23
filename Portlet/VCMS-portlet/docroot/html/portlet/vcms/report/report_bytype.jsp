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
<%@ include file="/html/portlet/vcms/init.jsp" %>
<%	
	
	Calendar currentDate = new GregorianCalendar();
	int curYear = currentDate.get(Calendar.YEAR);
	int curMonth = currentDate.get(Calendar.MONTH);
	int curDay = currentDate.get(Calendar.DATE);
	
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
	
		
	List listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);	
%>


<table width="100%" border="0" align="center">
<tr>        
	<td>
		<b><%= LanguageUtil.get(pageContext, "user") %>:</b>
			<select name= "<portlet:namespace/>byUser">
				<option value="">T&#7845;t c&#7843; user</option>
				<%
					OrderByComparator compare  = null;
					int totalUser = UserLocalServiceUtil.searchCount(company.getCompanyId(), "", 0, null);
					List userList = UserLocalServiceUtil.search(company.getCompanyId(), "", 0, null, 0, 1000, compare);
				
					for(int i=0; i < userList.size();i++){
						User userBean = (User)userList.get(i);
				%>
					<option value="<%=userBean.getUserId() %>"><%=userBean.getFullName() %></option>
				<%
					}
				%>
			</select>
 							
 			</td>	          
 			<td width="7%"><label for="<portlet:namespace/>isDate"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.from-date") %></label></td>
        	<td width="28%">
       			<liferay-ui:input-date
					disableNamespace="<%= false %>"
					formName='<%= renderResponse.getNamespace() + "fm" %>'
					monthParam="fromMonth"
					monthValue="<%= fromMonth %>"
					dayParam="fromDay"
					dayValue="<%= fromDay %>"
					yearParam="fromYear"
					yearValue="<%=fromYear %>"
					yearRangeStart="<%= curYear-10 %>"
					yearRangeEnd="<%= curYear+10 %>"
					firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
					disabled="<%= false %>"	/>
  		</td>
       	<td width="7%"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.to-date") %></td>
       	<td width="28%">
         	<liferay-ui:input-date
				disableNamespace="<%= false %>"
				formName='<%= renderResponse.getNamespace() + "fm" %>'
				monthParam="toMonth"
				monthValue="<%= toMonth %>"
				dayParam="toDay"
				dayValue="<%= toDay %>"
				yearParam="toYear"
				yearValue="<%=curYear %>"
				yearRangeStart="<%= curYear-10 %>"
				yearRangeEnd="<%= curYear+10 %>"
				firstDayOfWeek="<%= currentDate.getFirstDayOfWeek() - 1 %>"
				disabled="<%= false %>"/>
  		</td>
  		<td>  			
			<input class="portlet-form-button" type="button" style="width:100px;height:23px;font-weight:bold" value="<%= LanguageUtil.get(pageContext, "search") %>" onclick="javascript:<portlet:namespace />doSearchArticles();">
		</td>
   	</tr>
</table>
<br/>
<table width="100%" border="1" bordercolor="gray">
	<tr height="30" bgcolor="#CCCCCC">
		<td width="5%" align="center"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.report.stt") %></b></td>
		<td align="center" width="45%"><b>Lo&#7841;i tin</b></td>		
		<td align="center" width="15%">
			<b>T&#225;c ph&#7849;m</b>
		</td>		
	</tr>
	<%
		int totalArticle=0;
		for(int i=0; i<listType.size();i++){
			VcmsType vcmsType = (VcmsType)listType.get(i);
	%>	
	<tr>
		<td style="padding: 5px;" align="center">
			<%=i+1 %>
		</td>
		<td style="padding: 5px;">
			<%= vcmsType.getName()%>
		</td>
		<td style="padding: 5px;" align="center">
			<%
				int articleOfType = VcmsArticleServiceUtil.countByType(groupId, language, statusId,
						Long.valueOf(vcmsType.getTypeId()), dateFrom, dateTo, byUser);
				totalArticle += articleOfType;
			%>		
			<%=articleOfType %>
		</td>
	</tr>
	<%
		}
	%>
	<tr height="40">
		<td colspan="2" align="center">		
			<b>T&#7893;ng s&#7889; t&#225;c ph&#7849;m</b>
		</td>
		<td align="center">
			<b><%=totalArticle %></b>
		</td>
	</tr>
</table>
<portlet:actionURL name="exportToExcel" var="exportToExcelUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="fromDay" value="<%=String.valueOf(fromDay)%>"></portlet:param>
	<portlet:param name="fromMonth" value="<%=String.valueOf(fromMonth)%>"></portlet:param>
	<portlet:param name="fromYear" value="<%=String.valueOf(fromYear)%>"></portlet:param>
	<portlet:param name="toDay" value="<%=String.valueOf(toDay)%>"></portlet:param>
	<portlet:param name="toMonth" value="<%=String.valueOf(toMonth)%>"></portlet:param>
	<portlet:param name="toYear" value="<%=String.valueOf(toYear)%>"></portlet:param>
	<portlet:param name="parentId" value="<%=String.valueOf(parentId)%>"></portlet:param>
	<portlet:param name="language" value="<%=language%>"></portlet:param>
	<portlet:param name="exportType" value="4"></portlet:param>
	<portlet:param name="groupId" value="<%=String.valueOf(groupId)%>"></portlet:param>
	<portlet:param name="statusId" value="<%=String.valueOf(statusId)%>"></portlet:param>
</portlet:actionURL>
<br/>
<a href="<%=exportToExcelUrl.toString() %>">
	<input name="btnExport" type="button" value="Xu&#7845;t b&#225;o c&#225;o" />
</a>