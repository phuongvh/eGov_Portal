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

<%@page import="com.vportal.portlet.vpolls.util.WebKeysExt"%>
<%@page import="java.util.Iterator"%>
<%@ include file="/html/portlet/vpolls/init.jsp" %>
<%@ page import="com.liferay.portal.util.*" %>
<script type="text/javascript">	
	
	function <portlet:namespace />Vote(){
		if(document.getElementsByName("<portlet:namespace/>choiceId").checked = false){
			alert('Ban hay chon 1 lua chon');
			return false;
		}
	}
	
	function <portlet:namespace />SubmitVote(){
		submitForm(document.<portlet:namespace />fm);		
	}
</script>
	
<%
	PollsQuestion question = (PollsQuestion)request.getAttribute(WebKeysExt.POLLS_QUESTION);
	List choices = (List)request.getAttribute("choices");
	if(Validator.isNotNull(question)){
		question = question.toEscapedModel();	
	}
	String choiceId = (String)request.getAttribute("choiceId");
%>
<liferay-ui:success key="vote_added" message="thank-you-for-your-vote" />
<liferay-ui:error exception="<%= DuplicateVoteException.class %>" message="you-may-only-vote-once" />
<liferay-ui:error exception="<%= NoSuchChoiceException.class %>" message="please-select-an-option" />

<c:if test='<%= Validator.isNotNull(question) %>'>	
<form action="<portlet:renderURL><portlet:param name="struts_action" value="/vpolls/view" />
	</portlet:renderURL>" method="post" name="<portlet:namespace />fm">
<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
<input name="<portlet:namespace />questionId" type="hidden" value="<%= question.getQuestionId() %>" />	
	
<div class="wd-boxs">
<% if(themeType.equals("2")){%>	
<%@include file = "/html/portlet/vpolls/Style/style1.jsp" %>
	
<%}else if(themeType.equals("1")){%> 				
<%@include file = "/html/portlet/vpolls/Style/style2.jsp" %>
<%}%>
</div>				
</form>
</c:if>
<c:if test='<%= !Validator.isNotNull(question) %>'>
<h2><%=LanguageUtil.get(pageContext, "NoVote") %></h2>
</c:if>
