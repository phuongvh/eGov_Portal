
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

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/html/portlet/vfaq/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");

	FAQComment content = null;
	FAQAnswer answer = null;
	
	String answerId = ParamUtil.getString(request, "answerId","0");
	String commentId = ParamUtil.getString(request, "commentId", "0");	
	
	
	if(!answerId.equals("0")){
		answer = FAQAnswerLocalServiceUtil.getAnswer(Long.valueOf(answerId));		
	}
	
	if(!commentId.equals("0")){
		content = FAQCommentLocalServiceUtil.getComment(Long.valueOf(commentId));
	}
	
	PortletURL actionURL = renderResponse.createActionURL();
	actionURL.setWindowState(WindowState.MAXIMIZED);
	actionURL.setParameter("jspPage","/html/portlet/vfaq/edit_comment.jsp");
	actionURL.setParameter(Constants.CMD, Constants.ADD);
%>

<script language="javascript">
	function <portlet:namespace />submitForm() {
		var addContentForm = document.<portlet:namespace />fm;
		var commentContent = addContentForm.<portlet:namespace />content;
		var commName = addContentForm.<portlet:namespace />commName;
		var commEmail = addContentForm.<portlet:namespace />commEmail;
		var approvedByUser = addContentForm.<portlet:namespace />approvedByUser;
		resetField(commentContent);
		resetField(commName);		
		resetField(commEmail);
		resetField(approvedByUser);
		
		if (commentContent.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.content") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(commentContent);
			return ;
		}
		if (commName.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.commName") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(commName);
			return ;
		}
		if (commEmail.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.commEmail") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(commEmail);
			return ;
		}
		if (!checkEmail(commEmail.value)) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.invalidEmail") %>");
			showErrorField(commEmail);
			return ;
		}
		if (approvedByUser.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.approvedByUser") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(approvedByUser);
			return ;
		}
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updateComment"></portlet:actionURL>');
	}
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
	function checkEmail(email) {
		var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (filter.test(email)) {
			return true;
		}
		return false;
	}
</script>
	

<liferay-ui:tabs names="Comment" backURL="<%= redirect %>" />	
	
<form action="<%= actionURL.toString() %>" method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace />commentId" type="hidden" value="<%=(content != null)? content.getId() : "" %>">
	<input name="<portlet:namespace />answerId" type="hidden" value="<%=(answer != null)? answer.getId() : ""%>"> 
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">

<table>
	<tr>
		<td><%= LanguageUtil.get(pageContext, "pFAQ.form.content") %> * :</td>
		<td>
			<textarea class="form-text" cols="23" rows="5" name="<portlet:namespace />content" style="width: 400px;"><%=(content != null) ? content.getContent() : "" %></textarea>
		</td>
	</tr>
		<tr>
		<td><%= LanguageUtil.get(pageContext, "pFAQ.form.commName") %> * :</td>
		<td>
			<input type="text" class="form-text" name="<portlet:namespace />commName" style="width: 400px;" value="<%=(content != null) ? content.getCommName() : "" %>" />
		</td>
	</tr>
	<tr>
		<td><%= LanguageUtil.get(pageContext, "pFAQ.form.commEmail") %> * :</td>
		<td>
			<input type="text" class="form-text" name="<portlet:namespace />commEmail" style="width: 400px;" value="<%=(content != null) ? content.getCommEmail() : "" %>" />
		</td>
	</tr>
	<tr>
		<td><%= LanguageUtil.get(pageContext, "pFAQ.form.approved") %>:</td>
		<td>
			<c:if test='<%= commentId.equals("0") %>'>
				<input type="radio" name="<portlet:namespace />approved" value="true" checked="checked"><%= LanguageUtil.get(pageContext, "pFAQ.form.yes") %>
				<input type="radio" name="<portlet:namespace />approved" value="false"><%= LanguageUtil.get(pageContext, "pFAQ.form.no") %>
			</c:if>
			<c:if test='<%= !commentId.equals("0") %>'>
				<input type="radio" name="<portlet:namespace />approved" value="true"<% if (content.getApproved()) out.print(" checked=\"checked\""); %>><%= LanguageUtil.get(pageContext, "pFAQ.form.yes") %>
				<input type="radio" name="<portlet:namespace />approved" value="false"<%if (!content.getApproved()) out.print(" checked=\"checked\"");%>><%= LanguageUtil.get(pageContext, "pFAQ.form.no") %>
			</c:if>
		</td>
	</tr>	
	<tr>
		<td><%= LanguageUtil.get(pageContext, "pFAQ.form.approvedByUser") %> * :</td>
		<td>
			<input type="text" class="form-text" name="<portlet:namespace />approvedByUser" style="width: 400px;" value="<%=(content != null) ? content.getApproveByUser() : "" %>" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
				<liferay-ui:input-permissions modelName="<%=FAQComment.class.getName() %>" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" class="portlet-form-button" value="<%= LanguageUtil.get(pageContext, "pFAQ.form.submit") %>" onclick="<portlet:namespace />submitForm();" />
			<input type="submit" class="portlet-form-button" name="<portlet:namespace />btnBack" value="<%= LanguageUtil.get(pageContext, "pFAQ.form.back") %>" onclick="self.location = '<%= redirect %>';" />

		</td>
	</tr>
</table>