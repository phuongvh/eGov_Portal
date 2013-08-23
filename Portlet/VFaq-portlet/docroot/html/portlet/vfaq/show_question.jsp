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

<%@page import="com.vportal.util.HtmlExt"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.vportal.portlet.vfaq.action.ActionUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQAnswerLocalServiceUtil"%>
<%@page import="com.vportal.portlet.vfaq.model.FAQQuestion"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%
PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setParameter("jspPage","/html/portlet/vfaq/view.jsp");
searchURL.setParameter("tabs1", tabs1);
searchURL.setParameter("tabs2", tabs2);
searchURL.setParameter("redirect", redirectURL.toString());
%>

<script type="text/javascript">	
		Liferay.provide( window,'<portlet:namespace />deleteQuestion', function() {
		var listsChecked = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		if(listsChecked != ""){	
			if (confirm('<%= LanguageUtil.get(pageContext, "pFAQ.title.confirm-delete-question") %>')) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
				document.<portlet:namespace />fm.<portlet:namespace />deleteQuestionIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="deleteQuestion"></portlet:actionURL>');
			}
		} else {
				alert("<%= LanguageUtil.get(pageContext, "portlet.vfaq.question.listchecked.warning")%>");
		}	
	},['liferay-util-list-fields']
		    );
	
	function <portlet:namespace />doSearchQuestion() {
		var myform = document.<portlet:namespace />fm;
		myform.action="<%= searchURL.toString() %>";
		myform.submit();
	}
</script>

<%	
	PortletURL addURL = renderResponse.createRenderURL();
	addURL.setParameter("jspPage","/html/portlet/vfaq/edit_question.jsp");
	addURL.setParameter("tabs1", tabs1);
	addURL.setParameter("tabs2", tabs2);
	addURL.setParameter("redirect", redirectURL.toString());
	
	boolean showAddButton = showButtons && PortletPermissionUtil.
	contains(permissionChecker , plid.longValue(), WebKeysExt.VFAQ, ActionKeysExt.ADD_QUESTION);	
	boolean showDeleteButton = showButtons && PortletPermissionUtil.
	contains(permissionChecker , plid.longValue(), WebKeysExt.VFAQ, ActionKeysExt.DELETE_QUESTION);
	
	String catId = ParamUtil.getString(request,"categoryId","0");	
	String title = ParamUtil.getString(request,"title");
	String sentByUser = ParamUtil.getString(request,"sentByUser");
	String cmdSearchFlag = ParamUtil.getString(request,"cmd-search-flag",StringPool.BLANK);
	String tabs2Names = "un-approve,approved";
	boolean status = false;

	if (tabs2.equals("un-approve")){
		status = false;				
	} else if (tabs2.equals("approved")){
		status = true;		
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
	viewQuestion.setParameter("title", title);
	viewQuestion.setParameter("categoryId", catId);
	viewQuestion.setParameter("status", String.valueOf(status));
	
	
	List headerNames = new ArrayList();
	headerNames.add("title");	
	headerNames.add("H&#7885; t&#234;n");
	headerNames.add("Email");
	headerNames.add("#answer");
	headerNames.add("");
	SearchContainer searchCtn = new SearchContainer(renderRequest,
			null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA,
			viewQuestion, headerNames, null);
	
	searchCtn.setEmptyResultsMessage("there-are-no-questions");	
		
	int total = 0;
	List result = new ArrayList();
	
	if (Validator.isNotNull(cmdSearchFlag) && Validator.equals(cmdSearchFlag,"true")){		
		result = FAQQuestionLocalServiceUtil.getQuestionByParam(groupId, language, Long.parseLong(catId), title, sentByUser, status, searchCtn.getStart(), searchCtn.getEnd());
		total = FAQQuestionLocalServiceUtil.countQuestionByParam(groupId, language, Long.parseLong(catId), title, sentByUser, status);
	
	} else {		
		result = FAQQuestionLocalServiceUtil.getQuestionByG_L_S(groupId, language, status,searchCtn.getStart(), searchCtn.getEnd());
		total = FAQQuestionLocalServiceUtil.countQuestionByG_L_S(groupId, language, status);
	}	
	
	searchCtn.setTotal(total);
	searchCtn.setResults(result);
	
	//searchCtn.setDelta(5);
	searchCtn.setRowChecker(new RowChecker(renderResponse));
	List resultRows = searchCtn.getResultRows();
	for (int i = 0; i < result.size(); i++) {
		FAQQuestion content = (FAQQuestion) result.get(i);
		ResultRow row = new ResultRow(content, content.getPrimaryKey(), i);
		
		int count = FAQAnswerLocalServiceUtil.countByG_L_S_Q(groupId, language, true, content.getId());

		//title
		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.MAXIMIZED);
		rowURL.setParameter("jspPage", "/html/portlet/vfaq/edit_question.jsp");
		rowURL.setParameter("questionId", Long.toString(content.getId()));
		rowURL.setParameter("tabs1", tabs1);
		rowURL.setParameter("redirect", redirectURL.toString());
		TextSearchEntry rowTextEntry = new TextSearchEntry();
		rowTextEntry.setHref(rowURL.toString());
		rowTextEntry.setName(StringUtil.shorten(HtmlExt.extractText(content.getTitle()),200));
		rowTextEntry.setTarget("_blank");
		rowTextEntry.setTitle(StringUtil.shorten(HtmlExt.extractText(content.getTitle()),200));

		row.addText(rowTextEntry);
		
		//name
		rowTextEntry =(TextSearchEntry)rowTextEntry.clone();
		//TextSearchEntry rowFullName = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN, StringUtil.shorten(content.getSentByUser(),50));
		rowTextEntry.setName(StringUtil.shorten(content.getSentByUser(),50));
		row.addText(rowTextEntry);		
		
		if(Validator.isNotNull(content.getSenderEmail())){
			row.addText(StringUtil.shorten(content.getSenderEmail(),50));
		}else{
			row.addText("");
		}
		//TextSearchEntry rowCount = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN, String.valueOf(count));
		rowTextEntry =(TextSearchEntry)rowTextEntry.clone();
		rowTextEntry.setName(String.valueOf(count));
		row.addText(rowTextEntry);
		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vfaq/button.jsp",application,request,response);
		
		resultRows.add(row);
	}
%>

<input type="hidden" name="<portlet:namespace />deleteQuestionIds" value="" />	
	
<table width="100%">
	<tr height="30">	
		<td width="15%"><b><%= LanguageUtil.get(pageContext, "pFAQ.form.threadquestion") %> :</b></td>
		<td width="25%">
			<select name="<portlet:namespace/>categoryId" style="width:180px;" onchange="<portlet:namespace />doSearchQuestion()">
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
		<td><input type="text" name="<portlet:namespace/>title" value="<%=title%>" style="width:200px;"></td>
	</tr>
	<tr height="30">
		<td><b><%= LanguageUtil.get(pageContext, "pFAQ.form.sentByUser")%> :</b></td>
		<td><input type="text" name="<portlet:namespace/>sentByUser" value="<%=sentByUser%>" style="width:200px;"></td>
		<td><input class="portlet-form-button" type="button" style="width:150px;height:23px;font-weight:bold" value="<%= LanguageUtil.get(pageContext, "search") %>" 
					onclick="javascript:<portlet:namespace />doSearchQuestion();"></td>
	</tr>	
</table>	
<br/>


<%-- 	<input type="button" value="<%=LanguageUtil.get(pageContext,"pFAQ.add.question") %>" onClick="javascript:<portlet:namespace />updateQuestion('<%= Constants.ADD %>', true);" /> --%>

<%-- 	<input type="button" value="<%=LanguageUtil.get(pageContext,"pFAQ.title.delete") %>" onclick="<portlet:namespace />deleteQuestion();" /> --%>

<c:if test="<%=showAddButton==true %>">
	<input type="button" value="<%=LanguageUtil.get(pageContext,"pFAQ.add.question") %>" onClick="self.location = '<%= addURL %>';" />
</c:if>
<c:if test="<%=showDeleteButton==true %>">
	<input type="button" value="<%=LanguageUtil.get(pageContext,"pFAQ.title.delete") %>" onclick="<portlet:namespace />deleteQuestion();" />
</c:if>
<br/><br/>
<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />
	

