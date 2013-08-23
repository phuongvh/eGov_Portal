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
<%@ include file="/html/portlet/vcms/javascript.jsp" %>
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
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	portletURL.setParameter("jspPage", "/html/portlet/vcms/view.jsp");
	portletURL.setParameter("tabs1", tabs1);
	portletURL.setParameter("tabs2", tabs2);
	portletURL.setParameter("tabs3", tabs3);
	portletURL.setParameter("redirect", currentURL);
	portletURL.setParameter("language", language);	
	portletURL.setParameter("fromDay", String.valueOf(fromDay));
	portletURL.setParameter("fromMonth", String.valueOf(fromMonth));
	portletURL.setParameter("fromYear", String.valueOf(fromYear));
	portletURL.setParameter("toDay", String.valueOf(toDay));
	portletURL.setParameter("toMonth", String.valueOf(toMonth));
	portletURL.setParameter("toYear", String.valueOf(toYear));
	portletURL.setParameter("parentId", String.valueOf(parentId));
	
	String[] strType = request.getParameterValues("typeIds");
	if(Validator.isNotNull(strType)){
		portletURL.setParameter("typeIds",strType);
	}
	
	String strTypeIds="";	
	int begin = 0;
	int end = 100000;
	
	// Convert Date...
	Date dateFrom  = new GregorianCalendar(fromYear, fromMonth, fromDay).getTime();	
	Date dateTo = new GregorianCalendar(toYear, toMonth, toDay).getTime();
	
	String byUser = ParamUtil.getString(request,"byUser","");	
	
	int total =0;	
	List listType = VcmsTypeServiceUtil.getTypesByS_L(groupId, language);
	
	
	
	
%>
<table width="100%">
	<tr>	
		<td valign="top" width="38%" style="padding-top: 5px;">			   	
	   			<label for="<portlet:namespace/>isDate"><b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.from-date") %></b></label>	       	
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
				<br/><br/>
				
				<b><%= LanguageUtil.get(pageContext, "portlet.vcms.article.search.to-date") %></b>
	       	
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
					
	  		<br/>
	  		<br/>
	   			<b><%= LanguageUtil.get(pageContext, "user") %> :</b> &nbsp; 
				<select name= "<portlet:namespace/>byUser">
					<option value="">T&#7845;t c&#7843; user</option>
					<%	
						OrderByComparator compare  = null;
						//int totalUser = UserLocalServiceUtil.searchCount(company.getCompanyId(), null, true, null);
						int totalUser = UserLocalServiceUtil.searchCount(company.getCompanyId(), "", 0, null);
						//List userList = UserLocalServiceUtil.search(company.getCompanyId(), null, true, null, 0, totalUser, compare);
						List userList = UserLocalServiceUtil.search(company.getCompanyId(), "", 0, null, 0, 1000, compare);
					
						for(int i=0; i < userList.size();i++){
							User userBean = (User)userList.get(i);
					%>
					<option value="<%=userBean.getUserId() %>" <%=byUser.equals(String.valueOf(userBean.getUserId()))?"selected":"" %> ><%=userBean.getFullName() %></option>
					<%
						}
					%>	
				</select>	
			   			
			   		
		</td>
		<td>			
			<fieldset>			
			<legend><%= LanguageUtil.get(pageContext, "portlet.vcms.article.select.typeArticle") %></legend>					
				<div style="overflow: auto; height: 80px; border:1px solid">
					
					<table cellspacing="3" cellpadding="0" border="0" width="100%">
					<%	if(Validator.isNotNull(listType) && listType.size()>0){
							for(int i=0;i<listType.size();i++){
								VcmsType vType = (VcmsType)listType.get(i);
					%>								
					<tr>
						<td width="30">&nbsp;
							<input type="checkbox" name="<portlet:namespace/>typeIds" id="<portlet:namespace/>typeIds" 
								<% if(Validator.isNotNull(strType)){
									for(int j=0;j<strType.length;j++){
										if(strType[j].equals(vType.getTypeId())){
											if(j<strType.length-1){
												strTypeIds += vType.getTypeId()+",";
											}else{
												strTypeIds += vType.getTypeId();
											}											
										}
								%>	
									<%= strType[j].equals(vType.getTypeId())? "checked=\"checked\"" : "" %>
									
								<%
									}																		
								}
								%> value="<%=vType.getTypeId()%>">
						</td>
						<td><%=vType.getName()%></td>			
					</tr>	
					<%						
						}
					}
					%>
					</table>
				</div>		
			</fieldset>
		</td>
		<td>
			&nbsp; &nbsp; &nbsp; <input class="portlet-form-button" type="button" style="width:100px;height:23px;font-weight:bold" value="<%= LanguageUtil.get(pageContext, "search") %>" onclick="javascript:<portlet:namespace />doSearchArticles();">
		</td>
	</tr>
</table>

<br/>
<%

	List headerNames = new ArrayList();
	headerNames.add("STT");
	headerNames.add("Ti&#234;u &#273;&#7873;");
	headerNames.add("Ng&#224;y &#273;&#259;ng");
	headerNames.add("Ng&#432;&#7901;i t&#7841;o");
	headerNames.add("Ng&#432;&#7901;i duy&#7879;t");
	headerNames.add("Ng&#432;&#7901;i xu&#7845;t b&#7843;n");
	//headerNames.add("Tr&#7841;ng th&#225;i");
	headerNames.add("Lo&#7841;i tin");	
	
	SearchContainer searchCtn = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 30, portletURL, headerNames, null);	
	searchCtn.setEmptyResultsMessage("there-are-no-items");	
	List listArticlebyDate = new ArrayList();
		
	listArticlebyDate = VcmsArticleServiceUtil.listArticleByDateTypes(groupId,
			language, statusId, dateFrom, dateTo, byUser, strType,searchCtn.getStart(), searchCtn.getEnd());
	total = VcmsArticleServiceUtil.countArticleByDateTypes(groupId,
			language, statusId, dateFrom, dateTo, byUser, strType);
	
	searchCtn.setTotal(total);
	searchCtn.setResults(listArticlebyDate);
	List resultRows = searchCtn.getResultRows();
	
	for(int i=0; i < listArticlebyDate.size();i++){
		VcmsArticle vcmsArticle = (VcmsArticle)listArticlebyDate.get(i);		
		ResultRow row = new ResultRow(vcmsArticle, vcmsArticle.getArticleId(), i);
				
// 		TextSearchEntry rowSTT = new TextSearchEntry("left", SearchEntry.DEFAULT_VALIGN, String.valueOf(searchCtn.getStart()+i+1));
		TextSearchEntry rowSTT = new TextSearchEntry();
		rowSTT.setAlign("left");
		rowSTT.setValign(SearchEntry.DEFAULT_VALIGN);
		rowSTT.setName(String.valueOf(searchCtn.getStart()+i+1));
		row.addText(rowSTT);
				
		String articleTitle = "<a href=\"javascript:expandingWindow('/VCMS-portlet/html/portlet/vcms/articles/print_article.jsp?printArticleId=" + vcmsArticle.getArticleId() + "')\"')\" ><b>" + vcmsArticle.getTitle() + "</b></a>"; 
		row.addText(articleTitle);
			
// 		TextSearchEntry rowDate = new TextSearchEntry("left", SearchEntry.DEFAULT_VALIGN, ActionUtil.dateParser(vcmsArticle.getPublishedDate()));
		TextSearchEntry rowDate = new TextSearchEntry();
		rowDate.setAlign("left");
		rowDate.setValign(SearchEntry.DEFAULT_VALIGN);
		rowDate.setName(ActionUtil.dateParser(vcmsArticle.getPublishedDate()));
		row.addText(rowDate);
		
		try{
			User userCreate = UserLocalServiceUtil.getUserById(Long.valueOf(vcmsArticle.getCreatedByUser()));
			//TextSearchEntry rowUser = new TextSearchEntry("left", SearchEntry.DEFAULT_VALIGN, userCreate.getFullName());
			TextSearchEntry rowUser = new TextSearchEntry();
			rowUser.setAlign("left");
			rowUser.setValign(SearchEntry.DEFAULT_VALIGN);
			rowUser.setName(userCreate.getFullName());
			row.addText(rowUser);		
		}catch(Exception ex){
			row.addText("Not Available");				
		}
		
		try{	
			User userModified = UserLocalServiceUtil.getUserById(Long.valueOf(vcmsArticle.getModifiedByUser()));
			//TextSearchEntry rowModifiedUser = new TextSearchEntry("left", SearchEntry.DEFAULT_VALIGN, userModified.getFullName());
			TextSearchEntry rowModifiedUser = new TextSearchEntry();
			rowModifiedUser.setAlign("left");
			rowModifiedUser.setValign(SearchEntry.DEFAULT_VALIGN);
			rowModifiedUser.setName(userModified.getFullName());
			row.addText(rowModifiedUser);
		}catch(Exception ex){
			row.addText("Not Available");				
		}
		
		try{
			User userPublished = UserLocalServiceUtil.getUserById(Long.valueOf(vcmsArticle.getPublishedByUser()));
			//TextSearchEntry rowPublishUser = new TextSearchEntry("left", SearchEntry.DEFAULT_VALIGN, userPublished.getFullName());
			TextSearchEntry rowPublishUser = new TextSearchEntry();
			rowPublishUser.setAlign("left");
			rowPublishUser.setValign(SearchEntry.DEFAULT_VALIGN);
			rowPublishUser.setName(userPublished.getFullName());
			row.addText(rowPublishUser);
		}catch(Exception ex){
			row.addText("Not Available");
		}
			
		//TextSearchEntry rowStatus = new TextSearchEntry("left", SearchEntry.DEFAULT_VALIGN, vcmsStatus.getName());
		//row.addText(rowStatus);
		
		try{
			//TextSearchEntry rowType = new TextSearchEntry("left", SearchEntry.DEFAULT_VALIGN, ReportUtil.getTypeNames(vcmsArticle.getArticleId()));
			TextSearchEntry rowType = new TextSearchEntry();
			rowType.setAlign("left");
			rowType.setValign(SearchEntry.DEFAULT_VALIGN);
			rowType.setName(ReportUtil.getTypeNames(vcmsArticle.getArticleId()));
			row.addText(rowType);
		}catch(Exception ex){
			
		}
		
		resultRows.add(row);
	}
	
%>		
<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />
<portlet:actionURL name="exportToExcel" var="exportToExcelUrl" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="fromDay" value="<%=String.valueOf(fromDay)%>"></portlet:param>
	<portlet:param name="fromMonth" value="<%=String.valueOf(fromMonth)%>"></portlet:param>
	<portlet:param name="fromYear" value="<%=String.valueOf(fromYear)%>"></portlet:param>
	<portlet:param name="toDay" value="<%=String.valueOf(toDay)%>"></portlet:param>
	<portlet:param name="toMonth" value="<%=String.valueOf(toMonth)%>"></portlet:param>
	<portlet:param name="toYear" value="<%=String.valueOf(toYear)%>"></portlet:param>
	<portlet:param name="parentId" value="<%=String.valueOf(parentId)%>"></portlet:param>
	<portlet:param name="language" value="<%=language%>"></portlet:param>
	<portlet:param name="exportType" value="3"></portlet:param>
	<portlet:param name="begin" value="<%=String.valueOf(begin) %>"></portlet:param>
	<portlet:param name="end" value="<%=String.valueOf(end)%>"></portlet:param>
	<portlet:param name="groupId" value="<%=String.valueOf(groupId)%>"></portlet:param>
	<portlet:param name="statusId" value="<%=String.valueOf(statusId)%>"></portlet:param>
</portlet:actionURL>
<br/>
<a href="<%=exportToExcelUrl.toString() %>">
	<input name="btnExport" type="button" value="Xu&#7845;t b&#225;o c&#225;o" />
</a>
