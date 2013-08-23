
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

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/vfaq/init.jsp"%>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");

	FAQAnswer answer = null; 
	FAQQuestion question = null;
	
	String questionId = ParamUtil.getString(request, "questionId", "0");
	String answerId = ParamUtil.getString(request, "answerId","0");
	
	if(!answerId.equals("0") && answerId != null ){
		answer = FAQAnswerLocalServiceUtil.getAnswer(Long.valueOf(answerId));
	}
	if(!questionId.equals("0") && questionId != null){
 		question = FAQQuestionLocalServiceUtil.getQuestion(Long.valueOf(questionId));
 	}	
	
	long[] arrayCat = null;
	List listCategory = null;
		if(questionId.equals("0")){
			listCategory = (List)FAQCategoryQuestionLocalServiceUtil.getCategoriesOfQuestion(answer.getQuestionid());	
			question = FAQQuestionLocalServiceUtil.getQuestion(answer.getQuestionid());
		}
		else{
			listCategory = (List)FAQCategoryQuestionLocalServiceUtil.getCategoriesOfQuestion(question.getId());
		}
	if (Validator.isNotNull(listCategory) && listCategory.size()>0){
		arrayCat = new long[listCategory.size()];
		for(int i=0;i<listCategory.size();i++){
			FAQCategoryQuestion cat = (FAQCategoryQuestion)listCategory.get(i);
			arrayCat[i] = cat.getCategoryId();
		}
	}
	
	String arrayStr = "";
	
	for(int i=0;i<arrayCat.length;i++){
		FAQCategory category = FAQCategoryLocalServiceUtil.getCategory(arrayCat[i]);
			
		arrayStr += category.getName() + (i < arrayCat.length - 1 ? "," : "");
	}
	
	String editorContent ="";	
	if(Validator.isNotNull(answer)){
		editorContent = answer.getContent();
	}
	PortletURL actionURL = renderResponse.createActionURL();
	actionURL.setWindowState(WindowState.MAXIMIZED);
	actionURL.setParameter("jspPage","/html/portlet/vfaq/edit_answer.jsp");
	actionURL.setParameter(Constants.CMD, Constants.ADD);

%>

<%@page import="com.vportal.portlet.vfaq.model.impl.FAQQuestionImpl"%>
<script language="javascript">
	function <portlet:namespace />submitForm() {
		var addContentForm = document.<portlet:namespace />fm;
		var content = addContentForm.<portlet:namespace />content;
		content.value = parent.<portlet:namespace />content.getHTML();	
		resetField(content);
		if (content.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.content") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(content);
			return ;
		}
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>" name="updateAnswer"></portlet:actionURL>');
	}
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
	
	
	function <portlet:namespace />initContentEditor() {
		document.<portlet:namespace />fm.<portlet:namespace />content.value = "<%= UnicodeFormatter.toString(editorContent) %>";
		return "<%= UnicodeFormatter.toString(editorContent) %>";
	};
</script>
	
<liferay-ui:tabs names="reply" backURL="<%= redirect %>" />	
	
<%-- <form action="<%= actionURL.toString() %>" method="post" enctype="multipart/form-data" name="<portlet:namespace />fm"> --%>
<form action="<portlet:actionURL><portlet:param name="struts_action" value="/vfaq/answer" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data">
	<input name="<portlet:namespace />answerId" type="hidden" value="<%= (answer != null)? answer.getId() : "" %>">
	<input name="<portlet:namespace />questionId" type="hidden" value="<%= (questionId != null)? question.getId() : ""%>"> 
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
	<input name="<portlet:namespace />tabs1" type="hidden" value="<%= tabs1 %>">
	<input name="<portlet:namespace />tabs2" type="hidden" value="<%= tabs2 %>">
	


<table width="100%" border="1" bordercolor="#90ABCC">
<tr height="30">
	<td width="100" style="padding: 10px;"><b><%= LanguageUtil.get(pageContext, "question-title") %>:</b></td>
	<td style="padding: 10px;">
		<%= question.getTitle() %>
	</td>
</tr>
<tr height="30">
	<td style="padding: 10px;"><b><%= LanguageUtil.get(pageContext, "content") %>:</b></td>
	<td style="padding: 10px;">
		<%= question.getContent() %>
	</td>
</tr>
	
<tr height="30">
	<td style="padding: 10px;"><b><%= LanguageUtil.get(pageContext, "category") %>:</b></td>
	<td style="padding: 10px;">
		<%= arrayStr %>
	</td>
</tr>
<tr height="30">
	<td style="padding: 10px;"><b>Ng&#432;&#7901;i tr&#7843; l&#7901;i :</b></td>
	<td style="padding: 10px;">
		<input type="text" name="<portlet:namespace/>answeredByUser" value="<%=(answer != null)? answer.getAnsweredByUser() : "" %>" style="width: 300px;"/>
	</td>
</tr>
</table>

<br/>

<fieldset style="border: 1px solid rgb(144, 171, 204);">
<legend><strong><%= LanguageUtil.get(pageContext, "pFAQ.title.answer") %></strong></legend>
<table width="100%">
<tr>
	<td><%= LanguageUtil.get(pageContext, "pFAQ.form.content") %> * :</td>
	<td>
		<div id="editorContent">
			<liferay-ui:input-editor editorImpl="editor.wysiwyg.default" width="600" height="300" initMethod="initContentEditor" />
			<input name="<portlet:namespace />content" type="hidden" value="" />
		</div>
	</td>
</tr>
<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "approve") %>:</td>
	<td>
		<c:if test='<%= answerId.equals("0") %>'>
			<input type="radio" name="<portlet:namespace />approved" value="true" checked="checked"><%= LanguageUtil.get(pageContext, "pFAQ.form.yes") %>
			<input type="radio" name="<portlet:namespace />approved" value="false"><%= LanguageUtil.get(pageContext, "pFAQ.form.no") %>
		</c:if>
		<c:if test='<%= !answerId.equals("0") %>'>
			<input type="radio" name="<portlet:namespace />approved" value="true" <%= answer.getApproved()? " checked=\"checked\"" : "" %>><%= LanguageUtil.get(pageContext, "pFAQ.form.yes") %>
			<input type="radio" name="<portlet:namespace />approved" value="false"<%= !answer.getApproved()? " checked=\"checked\"" : "" %>><%= LanguageUtil.get(pageContext, "pFAQ.form.no") %>
		</c:if>
	</td>
</tr>	

<tr height="30">
	<td><%= LanguageUtil.get(pageContext, "pFAQ.form.attachedFile") %>:</td>
	<td>
		<vportal:file-upload entryId="<%= GetterUtil.getLong(answerId,0)%>" entryClass="<%=FAQAnswer.class%>" style="2" />
	</td>
</tr>
	
<tr height="30">
	<td colspan="2">
			<liferay-ui:input-permissions modelName="<%=FAQAnswer.class.getName() %>" />
	</td>
</tr>
</table>
</fieldset>
<br />
<input type="button" class="portlet-form-button" value="<%= LanguageUtil.get(pageContext, "save") %>" onclick="<portlet:namespace />submitForm();" />
<input type="button" class="portlet-form-button" name="<portlet:namespace />btnBack" value="<%= LanguageUtil.get(pageContext, "cancel") %>" onclick="self.location = '<%= redirect %>';" />
</form>