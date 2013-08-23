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

<%@page import="com.vportal.portlet.vfaq.service.FAQQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.vportal.portlet.vfaq.util.FAQUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.vportal.util.HtmlExt"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.WindowState"%>

<%
PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setParameter("jspPage","/html/portlet/vfaq/view.jsp");
searchURL.setParameter("tabs1", tabs1);
searchURL.setParameter("tabs2", tabs2);
searchURL.setParameter("redirect", redirectURL.toString());
%>
<script type="text/javascript">	

	function <portlet:namespace />doSearch() {
		var myform = document.<portlet:namespace />fm;
		myform.action="<%= searchURL.toString() %>";
		myform.submit();
	}
</script>
<%
 	String titleQuestion = ParamUtil.getString(request,"titleQuestion");
	String sentByUser = ParamUtil.getString(request, "sentByUser");
	String catId = ParamUtil.getString(request,"categoryId","0");
	String cmdSearchFlag = ParamUtil.getString(request,"cmd-search-flag",StringPool.BLANK);
	String list_answer = ParamUtil.getString(request, "list_answer");
	String questionIds = ParamUtil.getString(request, "questionId"); 
	
	String tabs2Names ="";
	boolean status = false;
	if(list_answer.equals("view_list_answer_by_question")){
	
	}else{
		tabs2Names = "un-approve,approved";
		if (tabs2.equals("un-approve")){
			status = false;		
		} else if (tabs2.equals("approved")){
			status = true;			
		}
	}
		
%>

<liferay-ui:tabs names="<%= tabs2Names %>" param="tabs2" url="<%= portletURL.toString() %>" />

<c:if test="<%= (tabs2.equals(\"un-approve\"))%>">
	<input type="hidden" name="<portlet:namespace />cmd-search-status" value="0"/>
</c:if>
<c:if test="<%= (tabs2.equals(\"approved\"))%>">
	<input type="hidden" name="<portlet:namespace />cmd-search-status" value="1"/>
</c:if>
<input type="hidden" name="<portlet:namespace />cmd-search-flag" value="true"/>	
	
<%
	PortletURL viewQuestion = renderResponse.createRenderURL();
	viewQuestion.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	viewQuestion.setParameter("tabs1", tabs1);
	viewQuestion.setParameter("tabs2", tabs2);
	viewQuestion.setParameter("language", language);
	viewQuestion.setParameter("groupId", String.valueOf(groupId));
	viewQuestion.setWindowState(WindowState.MAXIMIZED);
	viewQuestion.setParameter("cmd-search-flag", cmdSearchFlag);
	viewQuestion.setParameter("sentByUser", sentByUser);
	viewQuestion.setParameter("title", titleQuestion);
	viewQuestion.setParameter("categoryId", catId);
	viewQuestion.setParameter("status", String.valueOf(status));

	List headerNames = new ArrayList();
	headerNames.add("pFAQ.title.question");	
	headerNames.add("Ng&#432;&#7901;i tr&#7843; l&#7901;i");
	headerNames.add("pFAQ.title.createdDate");	
	headerNames.add("");
	
	SearchContainer searchCtn = new SearchContainer(renderRequest,
			null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA,
			viewQuestion, headerNames, null);
	
	searchCtn.setEmptyResultsMessage("there-are-no-answers");	
	
	int  total = 0;
	List result = new ArrayList();
	
	if (Validator.isNotNull(cmdSearchFlag) && Validator.equals(cmdSearchFlag,"true")){
		result = FAQAnswerLocalServiceUtil.getByParam(groupId, language, status,titleQuestion, sentByUser, Long.parseLong(catId), searchCtn.getStart(), searchCtn.getEnd());		
		total = FAQAnswerLocalServiceUtil.countByParam(groupId, language, status,titleQuestion, sentByUser, Long.parseLong(catId));
	}
	else if(list_answer.equals("view_list_answer_by_question") && Validator.isNotNull(questionIds)){
		result = FAQAnswerLocalServiceUtil.getByQuestion(Long.valueOf(questionIds));		
		total = FAQAnswerLocalServiceUtil.countQuestion(Long.valueOf(questionIds));
	}else {
		result = FAQAnswerLocalServiceUtil.getByParam(groupId, language, status, "", "", 0, searchCtn.getStart(), searchCtn.getEnd());
		total = FAQAnswerLocalServiceUtil.countByParam(groupId, language, status,"", "", 0);
	}
	
	searchCtn.setTotal(total);
	//searchCtn.setDelta(15);
	searchCtn.setRowChecker(new RowChecker(renderResponse));
	List resultRows = searchCtn.getResultRows();
	for (int i = 0; i < result.size(); i++) {
		FAQAnswer content = (FAQAnswer)result.get(i);
		
		long questionId = content.getQuestionid();
		FAQQuestion question = FAQQuestionLocalServiceUtil.getQuestion(groupId, questionId);
		
		ResultRow row = new ResultRow(content, content.getPrimaryKey(),	i);

		//title
		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.MAXIMIZED);
		rowURL.setParameter("jspPage","/html/portlet/vfaq/edit_answer.jsp");
		rowURL.setParameter("answerId", Long.toString(content.getId()));
		rowURL.setParameter("questionId",Long.toString(question.getId()));		
		rowURL.setParameter("redirect",currentURL);
		rowURL.setParameter("tabs1", tabs1);
		rowURL.setParameter("tabs2", tabs2);
		
		TextSearchEntry rowTextEntry = new TextSearchEntry();
		rowTextEntry.setHref(rowURL.toString());
		rowTextEntry.setName(StringUtil.shorten(HtmlExt.extractText(question.getTitle()),200));
		rowTextEntry.setTarget("_blank");
		rowTextEntry.setTitle(StringUtil.shorten(HtmlExt.extractText(question.getTitle()),200));
		
		//TextSearchEntry rowTextEntry = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN, StringUtil.shorten(HtmlExt.extractText(question.getTitle()),200), rowURL.toString());
		row.addText(rowTextEntry);
		
		row.addText(content.getAnsweredByUser());		
		row.addText(FAQUtil.dateParser(content.getAnsweredDate()));
				
		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vfaq/button.jsp",application,request,response);
		
		resultRows.add(row);
	}
%>



	
<table width="100%">
<tr height="30">	
	<td width="15%"><b><%= LanguageUtil.get(pageContext, "pFAQ.form.threadquestion") %> :</b></td>
	<td width="25%">
		<select name="<portlet:namespace/>categoryId" style="width:180px;" onchange="<portlet:namespace />doSearch()">
			<option value="0">---<%= LanguageUtil.get(pageContext, "pFAQ.form.selectedtopics") %>---</option>
			<%
				out.println(ActionUtil.getCategoryTree(groupId,language, Long.parseLong(catId), Long.parseLong(catId) ,null));
			%>
		</select>
	</td>
	<td></td>	
</tr>	
<tr height="30">
	<td><b><%= LanguageUtil.get(pageContext, "pFAQ.form.questiontitle")%> :</b></td>
	<td><input type="text" name="<portlet:namespace/>titleQuestion" value="<%=titleQuestion%>" style="width:200px;"></td>
</tr>
<tr height="30">
	<td><b><%= LanguageUtil.get(pageContext, "pFAQ.form.sentByUser")%> :</b></td>
	<td><input type="text" name="<portlet:namespace/>sentByUser" value="<%=sentByUser%>" style="width:200px;"></td>
	<td><input class="portlet-form-button" type="button" style="width:150px;height:23px;font-weight:bold" value="<%= LanguageUtil.get(pageContext, "search") %>" 
				onclick="javascript:<portlet:namespace />doSearch();"></td>
</tr>	
</table>	
				
<br><div class="beta-separator"></div>	
<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />