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
	VcmsPortion portion = null;
	if(Validator.isNotNull(portionId)){
		portion = VcmsPortionServiceUtil.getPortion(portionId);
	}	
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
	
	Date dateFrom  = new GregorianCalendar(fromYear, fromMonth, fromDay).getTime();	
	Date dateTo = new GregorianCalendar(toYear, toMonth, toDay).getTime();
	
	String byUser = ParamUtil.getString(request, "byUser", null);
	List listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);
%>

<table width="100%" border="0" align="center">
	<tr>
		<td colspan="5">
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
				<%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.portion") %>:
			</div>
			<div class="portlet-font" style="float: left; margin-right: 10px">
				<select style="width: 150px" name="<portlet:namespace />portionId" onChange="javascript:<portlet:namespace />submitForm();">
					<option selected value=""><%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.all-portion") %></option>
					<%					
						List portions = VcmsPortionServiceUtil.getPortionsByS_L(groupId, language);
						
						for (int i = 0; i < portions.size(); i++) {
							VcmsPortion portion2 = (VcmsPortion) portions.get(i);
						if (VcmsPortionPermission.contains(permissionChecker, portion2,
								ActionKeysExt.MANAGE_CATEGORIES_PORTION)) {									
							if (!portion2.getCategorizable()) {
								continue;
							}
					%>
						<option <%= portionId.equals(portion2.getPortionId()) ? "selected" : "" %> value="<%= portion2.getPortionId() %>"><%= portion2.getName() %></option>
					<%
						}
					}
					%>
				</select>
			</div>			
			<div class="portlet-font" style="font-weight: bold; float: left; margin-right: 10px">
				&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 
				<%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.parent-category") %>:
			</div>			
			<div class="portlet-font" style="float: left; margin-right: 10px">
				<select style="width: 150px" name="<portlet:namespace />parentId" <%= ((portion != null) && (portion.getCategorizable())) ? "" : "disabled" %> onChange="javascript:<portlet:namespace />submitForm();">
					<option value="0" <%= ("0".equals(parentId)) ? "selected" : "" %>><%= LanguageUtil.get(pageContext, "portlet.vcms.category.search-panel.root-category") %></option>
					<%
						// Print out the categories tree
						if (portion != null) {
							out.println(ActionUtil.getCategoryTree(portionId, parentId));
						}
					%>
				</select>
			</div>			
		</td>
	</tr>
	<tr><td colspan="5" height="10"></td></tr>
	<tr>
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
				disabled="<%= false %>"/>
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
		<td width="35%" align="center"><b><%= LanguageUtil.get(pageContext, "user") %></b></td>
		<td width="60%">
			<table width="100%">
				<tr height="30">
					<%					
						for(int i=0; i<listType.size(); i++){
							VcmsType vcmsType = (VcmsType) listType.get(i);
					%>
						
						<td style="border-right: 1px solid #999999; text-align: center;" width=<%= Math.round(100/(listType.size()+1)) %>%>
							<b><%=vcmsType.getName() %></b>
						<td>
					<%
						}
					%>
					<td style="border-right: 1px solid #999999; text-align: center;">
						<b>C&#225;c lo&#7841;i tin kh&#225;c</b>
					</td>					
				</tr>
			</table>			
		</td>	
	</tr>
</table>
<%
	OrderByComparator compare = null;
	int totalUser = UserLocalServiceUtil.searchCount(company.getCompanyId(), "", 0, null);
	//int totalUser = UserLocalServiceUtil.searchCount(company.getCompanyId(), "", 0, null);
	List userList = UserLocalServiceUtil.search(company.getCompanyId(), "", 0, null, 0, 1000, compare);
	//List userList = UserLocalServiceUtil.search(company.getCompanyId(), null, true, null, 0, totalUser, compare);
	int totalArticle =0;
	
%>
<table width="100%" border="1" bordercolor="gray">
	<%
		for(int i=0; i < userList.size();i++){
			User userBean = (User)userList.get(i);
	%>
	<tr>
		<td width="5%" align="center"><%=i+1 %></td>
		<td width="35%">
			&nbsp; &nbsp;<b><%=userBean.getFullName() %></b>
		</td>
		<td width="60%">
			<table width="100%">
				<tr>
					<%	
					
						int articleNotInType = 0;					
						if(!parentId.equals("0")){				 		
							articleNotInType = VcmsArticleServiceUtil.countArticleNotInType(groupId, language, parentId,statusId, dateFrom, dateTo, String.valueOf(userBean.getUserId()));
			 			}else{
			 				articleNotInType = VcmsArticleServiceUtil.countArticleAllCatNotInType(groupId, language, statusId, dateFrom, dateTo, String.valueOf(userBean.getUserId()));
			 			}
						
					 	for(int k =0; k < listType.size(); k++){
					 		VcmsType vcmsType = (VcmsType) listType.get(k);
					 		int countArticles = 0;
					 		if(!parentId.equals("0")){				 		
					 			countArticles = VcmsArticleServiceUtil.countByUser(groupId, language, parentId,statusId, Long.valueOf(vcmsType.getTypeId()), dateFrom, dateTo, String.valueOf(userBean.getUserId()));
					 		}else{
					 			countArticles = VcmsArticleServiceUtil.countByType(groupId, language, statusId,Long.valueOf(vcmsType.getTypeId()), dateFrom, dateTo, String.valueOf(userBean.getUserId()));
					 		}
					 		totalArticle += countArticles; 
					 		
					%>
						<td align="center" width="<%=Math.round(100/(listType.size()+1)) %>%" height="25" style="border: #999999 solid 1px;border-bottom:0px;">
							<%=countArticles %>
						</td>
					<%
					 	}
					 	totalArticle += articleNotInType;
					%>
					<td align="center" height="25" style="border: #999999 solid 1px;border-bottom:0px;">
						<%=articleNotInType %>
					</td>
				</tr>
			</table>			
			
		</td>
	</tr>	
	<%
		}
	%>
	<tr height="40">
		<td colspan="2" align="center">		
			<b>T&#7893;ng s&#7889; b&#224;i vi&#7871;t</b>
		</td>
		<td align="center">
			<b><%=totalArticle %></b>
		</td>
	</tr>
</table>

<%	
	String rowHREF = themeDisplay.getPathMain() + "/vcms/report?fromDay="+fromDay+"&fromMonth="+fromMonth+"&fromYear="+fromYear+"&toDay="+toDay+"&toMonth="+toMonth+"&toYear="+toYear+"&parentId="+parentId+"&language="+language+"&groupId="+groupId+"&exportType="+1+"&statusId="+statusId;
%>
<portlet:actionURL name="exportToExcel" var="exportToExcelUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="fromDay" value="<%=String.valueOf(fromDay)%>"></portlet:param>
	<portlet:param name="fromMonth" value="<%=String.valueOf(fromMonth)%>"></portlet:param>
	<portlet:param name="fromYear" value="<%=String.valueOf(fromYear)%>"></portlet:param>
	<portlet:param name="toDay" value="<%=String.valueOf(toDay)%>"></portlet:param>
	<portlet:param name="toMonth" value="<%=String.valueOf(toMonth)%>"></portlet:param>
	<portlet:param name="toYear" value="<%=String.valueOf(toYear)%>"></portlet:param>
	<portlet:param name="parentId" value="<%=String.valueOf(parentId)%>"></portlet:param>
	<portlet:param name="language" value="<%=language%>"></portlet:param>	
	<portlet:param name="exportType" value="1"></portlet:param>
	<portlet:param name="groupId" value="<%=String.valueOf(groupId)%>"></portlet:param>
	<portlet:param name="statusId" value="<%=String.valueOf(statusId)%>"></portlet:param>
</portlet:actionURL>
<br/>
<a href="<%=exportToExcelUrl.toString() %>">
	<input name="btnExport" type="button" value="Xu&#7845;t b&#225;o c&#225;o" />
</a>
