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
<%@page import="com.vportal.portlet.polls.service.PollsQuestionExtServiceUtil"%>
<%@ include file="/html/portlet/vcms/init.jsp" %>





<script language="javascript">
		
	function <portlet:namespace />selectPolls(){
		//document.getElementById('<portlet:namespace />polls_box').innerHTML = <portlet:namespace />pollsMessageBox.innerHTML;	
		
		var questionId = '';
		var questionTitle = '';
		questionIds = document.getElementsByName('<portlet:namespace />poll_question_id');
		questionTitles = document.getElementsByName('<portlet:namespace />poll_question_title');
		
		if (questionIds && (questionIds.length > 0)) {
			for (i = 0; i < questionIds.length; i ++) {
				if (questionIds[i].checked) {
					questionId = questionIds[i].value;
					questionTitle = questionTitles[i].value;
				}
			}
		}
		
		document.<portlet:namespace />fm.<portlet:namespace />pollId.value = questionId;
		document.getElementById('<portlet:namespace />pollContainer').innerHTML = '[<a href="#browsePoll" onClick="javascript:<portlet:namespace />showPollsList()"><%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.browse-poll") %>...</a>] ' + questionTitle;
	}
</script>
<%		
		List pollsQuestions = PollsQuestionExtServiceUtil.getPollsQuestions();
%>
<p style="margin-top: 10px" />
<table cellspacing="0" cellpadding="4" width="100%" border="0">
<c:choose>
	<c:when test="<%= ((pollsQuestions != null) && (pollsQuestions.size() > 0)) %>">
		<%
			for (int i = 0; i < pollsQuestions.size(); i ++) {
				PollsQuestion pollsQuestion = (PollsQuestion) pollsQuestions.get(i);
		%>
			<tr>
				<td width="2%" valign="top">
					<input type="hidden" name="<portlet:namespace />poll_question_title" value="<%= pollsQuestion.getTitle() %>" />
					<input type="radio" id="<portlet:namespace />question_<%= pollsQuestion.getQuestionId() %>" name="<portlet:namespace />poll_question_id" value="<%= pollsQuestion.getQuestionId() %>" />
				</td>
				<td width="98%" align="left" valign="top">
					<label for="<portlet:namespace />question_<%= pollsQuestion.getQuestionId() %>"><%= pollsQuestion.getTitle() %></label>
				</td>
			</tr>
		<%
			}
		%>
		<tr>
			<td colspan="2" align="center"><input class="form-button" type="button" value="<liferay-ui:message key="portlet.vcms.article.edit.select-poll" />" style="margin: 10px" onClick="javascript:<portlet:namespace />selectPolls();"/></td>
		</tr>
	</c:when>
	<c:otherwise>
		<tr>
			<td width="100%" align="center">
				<%= LanguageUtil.get(pageContext, "portlet.vcms.article.edit.no-polls-available") %>
			</td>
		</tr>
	</c:otherwise>
</c:choose>
</table>