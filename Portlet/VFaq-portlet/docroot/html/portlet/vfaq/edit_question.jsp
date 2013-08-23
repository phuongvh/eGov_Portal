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

<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@ include file= "/html/portlet/vfaq/init.jsp"%>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	
	List answerList = (List) request.getAttribute(WebKeysExt.VFAQ_LIST_ANSWER);
	List parentList = (List) request.getAttribute(WebKeysExt.VFAQ_LIST_CATEGORY);
	
	FAQQuestion question = null;
	long[] arrayCat = null;
	
	if(Validator.isNotNull(question)){
		List listCategory = (List)FAQCategoryQuestionLocalServiceUtil.getCategoriesOfQuestion(question.getId());
		if (Validator.isNotNull(listCategory) && listCategory.size()>0){
			arrayCat = new long[listCategory.size()];
			for(int i=0;i<listCategory.size();i++){
				FAQCategoryQuestion cat = (FAQCategoryQuestion)listCategory.get(i);
				arrayCat[i] = cat.getCategoryId();
			}
		}
	}
	
	String questionId = ParamUtil.getString(request, "questionId", "0");
	if(!questionId.equals("0") && questionId != null){
 		question = FAQQuestionLocalServiceUtil.getFAQQuestion(Long.valueOf(questionId));
 	}
	String content = ((question!= null) ? question.getContent() : StringPool.BLANK);
	
	PortletURL actionURL = renderResponse.createActionURL();
	actionURL.setWindowState(WindowState.MAXIMIZED);
	actionURL.setParameter("jspPage", "/html/portlet/vfaq/edit_question.jsp");
	actionURL.setParameter(Constants.CMD, Constants.ADD);
%>

<script language="javascript">

	function <portlet:namespace />initContentEditor() {
		document.<portlet:namespace />fm.<portlet:namespace />content.value = "<%= UnicodeFormatter.toString(content) %>";
		return "<%= UnicodeFormatter.toString(content) %>";
	};
	
	function <portlet:namespace />submitForm() {
		var addContentForm = document.<portlet:namespace />fm;
		var title = addContentForm.<portlet:namespace />title;
		var category = addContentForm.<portlet:namespace />category;
		var content = addContentForm.<portlet:namespace />content;
		
		resetField(title);
		resetField(category);
		resetField(content);
		
		if (title.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.title") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(title);
			return ;
		}
		if (category.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.parentCategory") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(category);
			return ;
		}		
		submitForm(document.<portlet:namespace />fm, '<portlet:actionURL name="updateQuestion" windowState="<%=WindowState.MAXIMIZED.toString()%>"></portlet:actionURL>');
	}
	
	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}
	
</script>
	
<c:if test='<%= !questionId.equals("0") %>'>
	<liferay-ui:tabs names="update-question" backURL="<%= redirect %>" />
</c:if>
<c:if test='<%= questionId.equals("0") %>'>
	<liferay-ui:tabs names="add-question" backURL="<%= redirect %>" />
</c:if>
		
<%-- <form action="<%= actionURL.toString() %>" method="post" enctype="multipart/form-data" name="<portlet:namespace />fm">
	<input name="<portlet:namespace />language" type="hidden" value="vi_VN">
	<input name="<portlet:namespace />questionId" type="hidden" value="<%= (question != null) ? question.getId() : "" %>">
	<input name="<portlet:namespace />questionman" type="hidden" value="<%= (question != null) ? question.getSentByUser() : "" %>"> 
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>"> --%>
	
<form action="<portlet:actionURL><portlet:param name="struts_action" value="/vfaq/question" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm" enctype="multipart/form-data">	
	<input name="<portlet:namespace />language" type="hidden" value="vi_VN">
	<input name="<portlet:namespace />questionId" type="hidden" value="<%= (question != null) ? question.getId() : "" %>">
	<input name="<portlet:namespace />questionman" type="hidden" value="<%= (question != null) ? question.getSentByUser() : "" %>"> 
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">
	<input name="<portlet:namespace /><%=Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" >
	<input name="<portlet:namespace />tabs1" type="hidden" value="<%= tabs1 %>">
	<input name="<portlet:namespace />tabs2" type="hidden" value="<%= tabs2 %>">

<table width="100%" border="1" bordercolor="#90ABCC">
<tr height="30">
	<td style="padding:10px;"><%= LanguageUtil.get(pageContext, "title") %></td>
	<td style="padding:10px;">		
		<liferay-ui:input-field model="<%= FAQQuestion.class %>" bean="<%= question %>" field="title" />
	</td>
</tr>
<tr height="30">
	<td style="padding:10px;"> <%= LanguageUtil.get(pageContext, "pFAQ.person.send") %> </td>
	<td style="padding:10px;">		
		<liferay-ui:input-field model="<%= FAQQuestion.class %>" bean="<%= question %>" field="sentByUser" />
	</td>
</tr>
<tr height="30">
	<td style="padding:10px;"> Email </td>
	<td style="padding:10px;">		
		<liferay-ui:input-field model="<%= FAQQuestion.class %>" bean="<%= question %>" field="senderEmail" />
	</td>
</tr>

<tr height="30" valign="top">
	<td style="padding:10px;"><%= LanguageUtil.get(pageContext, "description") %></td>
	<td style="padding:10px;">		
		<textarea name="<portlet:namespace />content" class="lfr-textarea" ><%= (question != null) ? question.getContent() : "" %></textarea>
	</td>
</tr>

<tr height="10"><td colspan="2"></td></tr>	
	
<tr height="30">
	<td valign="top" style="padding:10px;"><%= LanguageUtil.get(pageContext, "category") %></td>
	<td style="padding:10px;">
		<select name="<portlet:namespace />category" style="width: 200px;" multiple="multiple">
		<%
			out.println(ActionUtil.getCategoryTree(groupId,language, 0, 0 ,arrayCat));
		%>
		</select>
	</td>
</tr>
			
<tr height="30">
	<td style="padding:10px;"><%= LanguageUtil.get(pageContext, "approve") %></td>
	<td style="padding:10px;">
		<c:if test='<%= questionId.equals("0") %>'>
			<input type="radio" name="<portlet:namespace />approved" value="true" checked="checked"><%= LanguageUtil.get(pageContext, "pFAQ.form.yes") %>
			<input type="radio" name="<portlet:namespace />approved" value="false"><%= LanguageUtil.get(pageContext, "pFAQ.form.no") %>
		</c:if>
		<c:if test='<%= !questionId.equals("0") %>'>
			<input type="radio" name="<portlet:namespace />approved" value="true"<%= question.getApproved()? " checked=\"checked\"" : "" %>><%= LanguageUtil.get(pageContext, "pFAQ.form.yes") %>
			<input type="radio" name="<portlet:namespace />approved" value="false"<%= !question.getApproved()? " checked=\"checked\"" : "" %>><%= LanguageUtil.get(pageContext, "pFAQ.form.no") %>
		</c:if>
	</td>
</tr>
			
<tr height="30">
	<td style="padding:10px;"><%= LanguageUtil.get(pageContext, "pFAQ.form.attachedFile") %></td>
	<td style="padding:10px;">
		<vportal:file-upload entryId="<%= GetterUtil.getLong(questionId,0) %>" entryClass="<%=FAQQuestion.class%>" style="2" />				
	</td>
</tr>


<c:if test="<%= answerList != null && answerList.size() > 0 %>">
<tr height="30">
	<td valign="top" style="padding:10px;">
		Tr&#7843; l&#7901;i
	</td>
	<td style="padding:10px;">
		<% for (int i = 0; i < answerList.size(); i++) {
			FAQAnswer answer = (FAQAnswer)answerList.get(i);
		%>
			Tr&#7843; l&#7901;i <%=i+1%> : <%= answer.getContent() %><br/>
			<hr width="100%"/>
		<% } %>	
	</td>
</tr>
</c:if>

<c:if test='<%= questionId.equals("0") %>'>			
<tr height="30">
	<td colspan="2">
		<liferay-ui:input-permissions modelName="<%=FAQQuestion.class.getName() %>" />
	</td>
</tr>
</c:if>
	
</table>

<br/>	
<input type="button" class="portlet-form-button" value="<%= LanguageUtil.get(pageContext, "save") %>" onclick="<portlet:namespace />submitForm();" />
<input type="button" class="portlet-form-button" name="<portlet:namespace />btnBack" value="<%= LanguageUtil.get(pageContext, "cancel") %>" onclick="self.location = '<%= redirect %>';" />			
		
</form>
<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
	<script type="text/javascript">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />title);
	</script>
</c:if>			
<%!
	
	public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.journal.edit_article_content.jsp";
	public static final String EDITOR_WYSIWYG_IMPL_KEY_DEFAULT = "editor.wysiwyg.default";
	public static final String EDITOR_WYSIWYG_IMPL_KEY_SIMPLE = "editor.wysiwyg.default";
%> 	