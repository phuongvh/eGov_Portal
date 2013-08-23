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
	List portionResults = VcmsPortionServiceUtil.getPortionsByS_L(groupId, language);
	Calendar currentDate = new GregorianCalendar();
	int curYear = currentDate.get(Calendar.YEAR);
	int curMonth = currentDate.get(Calendar.MONTH);
	int curDay = currentDate.get(Calendar.DATE);
	
	int fromDay = ParamUtil.getInteger(request, "fromDay", curDay);
	int fromMonth = ParamUtil.getInteger(request, "fromMonth", curMonth);
	int fromYear = ParamUtil.getInteger(request, "fromYear", curYear-10);
	
	int toDay = ParamUtil.getInteger(request, "toDay", curDay+1);
	int toMonth = ParamUtil.getInteger(request, "toMonth", curMonth);
	int toYear = ParamUtil.getInteger(request, "toYear", curYear);	
	
		// Convert Date...
	
	Date dateFrom  = new GregorianCalendar(fromYear, fromMonth, fromDay).getTime();
	
	Date dateTo = new GregorianCalendar(toYear, toMonth, toDay).getTime();
	
	String byUser = ParamUtil.getString(request,"byUser",null);	
%>


<table width="100%" border="0" align="center">
<tr>        
	<td>
		<b><%= LanguageUtil.get(pageContext, "user") %>:</b> 					
			<select name= "<portlet:namespace/>byUser">
				<option value="">T&#7845;t c&#7843; user</option>
				<%
					List userList = UserLocalServiceUtil.getUsers(0, 200);
				
					for(int i=0; i < userList.size();i++){
						User userBean = (User)userList.get(i);
				%>
					<option value="<%=userBean.getUserId() %>"><%=userBean.getScreenName() %></option>
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
			disabled="<%= false %>"
		/>
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

<table width="100%" border="1" bordercolor="#999999">
	<tr height="30" bgcolor="#CCCCCC">
		<td width="5%" align="center"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.report.stt") %></b></td>
		<td width="35%"><b>&nbsp;<%= LanguageUtil.get(pageContext, "portlet.vcms.report.portion-category") %></b></td>
		<td width="60%">
			<table width="100%" width="100%">
				<tr height="30">
					<%
					if(totalStatus > 0)
						for(int i=0; i<totalStatus; i++){
							VcmsStatus status = (VcmsStatus) statusResults.get(i);
					%>
						<td style="border-right: 1px solid #999999; text-align: center;">
							<b><%=status.getName() %></b>
						<td>
					<%
						}
					%>	
				</tr>
			</table>			
		</td>	
	</tr>
</table>
<%	
	for(int i=0; i < portionResults.size();i++){
		VcmsPortion vcmsPortion = (VcmsPortion)portionResults.get(i);
		//List categoryResults = VcmsCategoryServiceUtil.getCategoriesByPortion(groupId, vcmsPortion.getPortionId(), language);
%>	
		<table width="100%">
				<tr>
					<td align="center" width="5%">
						<b><%=i+1 %></b>
					</td>
					<td width="35%">
						<b><a style="cursor: pointer;" onclick="showTag(<%=vcmsPortion.getPortionId() %>)"><%=vcmsPortion.getName()%></a></b>
					</td>
					<td></td>									
				</tr>
		</table>
<%	
		List categoryByPortion = ActionUtil.getListCategoryReport(groupId,vcmsPortion.getPortionId(),
					parentId,language);
%>
		<table width="100%" id="<%=vcmsPortion.getPortionId() %>">
		<%
			for(int j=0; j < categoryByPortion.size();j++){
					VcmsCategory vcmsCategory = (VcmsCategory)categoryByPortion.get(j);
					List tempArr = null;
		%>	
				
				<tr>
					<td width="5%">
								
					</td>							
					<td width="35%">
						<%
							int subCounter = ActionUtil.countCategoryIndex(vcmsCategory.getCategoryId());
							for(int m=0; m <= subCounter; m++){
								out.print("&nbsp;");		
							}
						%>				
						 - <%=vcmsCategory.getName() %>					 
					</td>
					<td width="60%">
						<table width="100%">
							<tr>
								<%								 						 	
								 	for(int k =0; k < totalStatus; k++){
								 		VcmsStatus status = (VcmsStatus) statusResults.get(k);
								 		int countAticles = VcmsArticleServiceUtil.countByC_P_L_S_D(vcmsCategory.getCategoryId(), groupId,
								 				language, status.getStatusId(), dateFrom, dateTo, byUser);
								%>
									<td align="center">
										<%=countAticles %>
									</td>
								<%
								 	}								 
								%>
							</tr>						
						</table>
					</td>					
				</tr>	
		<%	
				}
		%>
		</table>
<%
	}
%>
