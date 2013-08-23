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

<%@page import="com.liferay.portal.kernel.dao.search.TextSearchEntry"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.vportal.portlet.vfaq.service.FAQCommentLocalServiceUtil"%>
<%
	PortletURL viewComment = renderResponse.createRenderURL();
	viewComment.setParameter("jspPage", "/html/portlet/vfaq/view.jsp");
	viewComment.setParameter("tabs1", tabs1);
	viewComment.setParameter("language", language);
	viewComment.setParameter("groupId", String.valueOf(groupId));
	viewComment.setWindowState(WindowState.MAXIMIZED);

	List headerNames = new ArrayList();
	headerNames.add("pFAQ.form.title");
	headerNames.add("pFAQ.title.answer");
	headerNames.add("pFAQ.title.comment");
	headerNames.add("pFAQ.title.createdDate");
	headerNames.add("");
	SearchContainer searchCtn = new SearchContainer(renderRequest,
			null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA,
			viewComment, headerNames, null);

	searchCtn.setEmptyResultsMessage("there-are-no-conments");	
	
	int  total = 0;
	List result = new ArrayList();
	
	total = FAQCommentLocalServiceUtil.countByPara(groupId, "");
	result = FAQCommentLocalServiceUtil.getByPara(groupId, "", searchCtn.getStart(), searchCtn.getEnd());
	searchCtn.setRowChecker(new RowChecker(renderResponse));
	searchCtn.setTotal(total);
	//searchCtn.setDelta(15);
	List resultRows = searchCtn.getResultRows();
	for (int i = 0; i < result.size(); i++) {
		FAQComment content = (FAQComment)result.get(i);
		
		long answerId = content.getAnswerid();
		FAQAnswer answer = FAQAnswerLocalServiceUtil
						.getAnswer(answerId);
		long questionId = answer.getQuestionid();
		FAQQuestion question = FAQQuestionLocalServiceUtil
							.getQuestion(groupId, questionId);

		ResultRow row = new ResultRow(content, content.getPrimaryKey(), i);

		//title question
		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setWindowState(WindowState.MAXIMIZED);
		rowURL.setParameter("jspPage", "/html/portlet/vfaq/edit_comment.jsp");
		rowURL.setParameter("commentId", Long.toString(content.getId()));
		rowURL.setParameter("tabs1", tabs1);
		rowURL.setParameter("redirect", redirectURL.toString());
		//TextSearchEntry rowTextEntry = new TextSearchEntry(SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN, question.getTitle(), rowURL.toString());
		TextSearchEntry rowTextEntry = new TextSearchEntry();
		rowTextEntry.setHref(rowURL.toString());
		rowTextEntry.setName(question.getTitle());
		rowTextEntry.setTarget("_blank");
		rowTextEntry.setTitle(question.getTitle());
		row.addText(rowTextEntry);
		//answer
		row.addText(FAQUtil.trimString(answer.getContent(), 100));
		
		//content
		row.addText(FAQUtil.trimString(content.getContent(), 100));
		
		//comment date
		row.addText(FAQUtil.dateParser(content.getCommDate()));
		
		//edit
		//delete
		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/vfaq/button.jsp",application,request,response);
		
		resultRows.add(row);
	}
%>
<script type="text/javascript">
	Liferay.provide( window,'<portlet:namespace />deleteComment', function() {
		var listsChecked = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
		if(listsChecked != ""){	
			if (confirm('<%= LanguageUtil.get(pageContext, "pFAQ.title.confirm-delete-comment") %>')) {
				document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE %>";
				document.<portlet:namespace />fm.<portlet:namespace />deleteCommentIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, "<portlet:namespace />allRowIds");
<%-- 				submitForm(document.<portlet:namespace />fm, "<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"><portlet:param name="struts_action" value="/vfaq/edit_comment" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:actionURL>"); --%>
				submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="deleteComment"></portlet:actionURL>');
			}
		} else {
			alert("<%= LanguageUtil.get(pageContext, "portlet.vfaq.comment.listchecked.warning")%>");	
		}	
	},['liferay-util-list-fields']
);
</script>
<input name="<portlet:namespace />deleteCommentIds" type="hidden" value="" />
	
<input type="button" value="<%=LanguageUtil.get(pageContext,"pFAQ.title.delete") %>" onclick="<portlet:namespace />deleteComment();" />

<br/><br/>
<liferay-ui:search-iterator searchContainer="<%= searchCtn %>" />
