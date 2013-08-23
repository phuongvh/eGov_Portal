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

<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.vportal.portal.util.PortalUtilExt"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file ="/html/portlet/vfaqsend/init.jsp" %>
<%@ taglib uri="http://www.vietsoftware.com/tld" prefix="vportal" %>
<script language="JavaScript1.2"> setTypingMode(4); </script>
<%
	String redirect = ParamUtil.getString(request, "redirect");	
	
	List parentList = FAQCategoryLocalServiceUtil.getAll(groupId);
// 	parentList = FAQUtil.sort(parentList);
// 	parentList = FAQUtil.formatByLevel(parentList);
	
	long questionId = ParamUtil.getLong(request, "questionId");
	// get attachment
	/* List attachmentList = AttachmentServiceUtil.getAttachments(questionId,
			FAQQuestion.class); */
		
// 	PortletURL actionURL = renderResponse.createActionURL();
// 	actionURL.setWindowState(WindowState.NORMAL);
// 	actionURL.setParameter("jspPage", "/html/portlet/vfaqsend/view.jsp");
// 	actionURL.setParameter(Constants.CMD, Constants.ADD);
	
%>

<script type="text/javascript">	
	function <portlet:namespace />savePreferences() {
		return <portlet:namespace />submitForm();	
	}
</script>
<style>
.wd-submit-2, .wd-form-question div.wd-submit input {
    background-image: none;
}
.wd-input table td {
    border: 0px solid #C3C3C3;
}
</style>

<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />	
<form  method="post" enctype="multipart/form-data" name="<portlet:namespace />fm">
	<input name="<portlet:namespace />language" type="hidden" value="vi_VN">
	<input name="<portlet:namespace/>questionId" type="hidden" value= 0>	
	<input name="<portlet:namespace />cmd" type="hidden" value="send">
	<input name="<portlet:namespace/>approved" type ="hidden" value ="false">
	<input name="<portlet:namespace/>type" type ="hidden" value ="type1">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>">

<%-- 	<% --%>
<!--  				SessionErrors.add(request, "error-captcha");success-send -->
<%-- 			%> --%>
<%-- 			<liferay-ui:error key="error-captcha" message="error-captcha" /> --%>

	<%
				SessionErrors.add(request, "success-send"); 
	%>
<liferay-ui:success key="success-send" message="success-send" />

<div class="wd-boxs">
	<h2 class="wd-tlh1-2"><%=titlePortlet%></h2>
	<div class="wd-introduction">
		<fieldset>
			<div class="wd-form-question">
				<h3 class="wd-tlh3-8 wd-tlh3-first"><%= LanguageUtil.get(pageContext, "pFAQ.form.infoPerson") %>:</h3>
				<div class="wd-shorter">
					<label for="people" class="label-shorter"><%= LanguageUtil.get(pageContext, "pFAQ.form.sentByUser") %>: <span class="wd-star">&nbsp;</span></label>
					<input type="text" id="people" name="<portlet:namespace />username" onKeyUp="telexingVietUC(this,event);"/>
				</div>
				<div class="wd-shorter wd-shorter-two">
					<label for="email" class="label-shorter">Email: <span class="wd-star">&nbsp;</span></label>
					<input type="text" id="email" name="<portlet:namespace />email" onKeyUp="telexingVietUC(this,event);"/>
				</div>
				<h3 class="wd-tlh3-8"><%= LanguageUtil.get(pageContext, "pFAQ.form.infoQuestion") %>:</h3>
				<div class="wd-input">
					<label for="title"><%= LanguageUtil.get(pageContext, "pFAQ.form.title") %>: <span class="wd-star">&nbsp;</span></label>
					<input type="text" id="title" name="<portlet:namespace />title" onKeyUp="telexingVietUC(this,event);" />
				</div>
				<div class="wd-input">
					<label for="topics"><%= LanguageUtil.get(pageContext, "pFAQ.form.threadquestion") %>: <span class="wd-star">&nbsp;</span></label>
					<!-- <input type="text" id="topics" name="topics" value="" /> -->
					<select name="<portlet:namespace />category" style="width: 250px; height: 30px; font-size:16px">
					<%
						for (int i = 0; i < parentList.size(); i++) {
							FAQCategory category = (FAQCategory) parentList.get(i);
					%>
							<option value="<%= category.getId() %>" ><%= category.getName() %></option>
					<%
						}
					%>
					</select>
				</div>
				<div class="wd-input">
					<label for="content"><%= LanguageUtil.get(pageContext, "content") %>: <span class="wd-star">&nbsp;</span></label>
					<div class="wd-radio">
						<input type="radio" id="radioone" name="<portlet:namespace/>switch" value="OFF" onFocus="setTypingMode(0)"  />
						<label for="radioone">T&#7855;t</label>	
						<input type="radio" id="radiotwo" name="<portlet:namespace/>switch" value="TELEX" onFocus="setTypingMode(1)"  checked/>
						<label for="radiotwo">Telex</label>
						<input type="radio" id="radiothree" name="<portlet:namespace/>switch" value="VNI" onFocus="setTypingMode(2)"  />
						<label for="radiothree">VNI</label>
					</div>
					<textarea id="message" name="<portlet:namespace />content" cols="50" rows="10" class="validate[required]" onKeyUp="initTyper(this)"></textarea>
				</div>
				<div class="wd-input">
					<label for="file"><%= LanguageUtil.get(pageContext, "pFAQ.form.attachedFile") %>:</label>
					<!-- <input type="file" id="file" name="file" value="" /> -->
					<vportal:file-upload entryId="<%= GetterUtil.getLong(questionId,0) %>" entryClass="<%=FAQQuestion.class%>" style="2"/>
				</div>
				<div class="wd-input">
					<label for="code"><%= LanguageUtil.get(pageContext, "pFAQ.form.captcha") %>:</label>
					<div class="wd-verification">
						<portlet:resourceURL var="captchaURL" /><liferay-ui:captcha url="<%=captchaURL%>" />
						<label for="code"><%= LanguageUtil.get(pageContext, "pFAQ.form.inputCaptcha") %>:<span class="wd-star">&nbsp;</span></label>
						<input type="text" id="enter" name="<portlet:namespace />captchaText" />
					</div>
				</div>
				<div class="wd-submit">
					<input type="submit" id="send" value="<%= LanguageUtil.get(pageContext, "pFAQ.form.submit") %>" 
					onclick="return <portlet:namespace />savePreferences();" />
					<a href="#">* <%= LanguageUtil.get(pageContext, "pFAQ.form.*") %></a>
				</div>
			</div>
		</fieldset>
	</div>
</div>	
</form>

<script language="javascript">
	function <portlet:namespace />submitForm() {
		var addContentForm = document.<portlet:namespace />fm;
		var title = addContentForm.<portlet:namespace />title;
		var username = addContentForm.<portlet:namespace/>username;
		var email = addContentForm.<portlet:namespace/>email;
		var category = addContentForm.<portlet:namespace />category;
		var content = addContentForm.<portlet:namespace />content;
		resetField(title);
		resetField(username);
		resetField(email);
		resetField(category);
		resetField(content);
		if (title.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.title") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(title);
			return false;
		}
		if (username.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.sentByUser") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(title);
			return false;
		}
		if(email.value.length <1)
		{
			alert("Email <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(email);
			return false;			
		}
		if (!checkEmail(email.value)) {
			alert("Email <%= LanguageUtil.get(pageContext, "pFAQ.form.notValid") %>");
			showErrorField(email);
			return false;
		}
		
		if (category.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.form.parentCategory") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(category);
			return false;
		}
		if (content.value.length < 1) {
			alert("<%= LanguageUtil.get(pageContext, "pFAQ.title.description") %> <%= LanguageUtil.get(pageContext, "pFAQ.form.cannotBlank") %>");
			showErrorField(content);
			return false;
		}	
		else
			submitForm(document.<portlet:namespace />fm,'<portlet:actionURL windowState="<%= WindowState.MAXIMIZED.toString() %>"></portlet:actionURL>');
	}	

	function showErrorField(field) {
		field.style.border="2px solid red";
		field.focus();
	}
	function checkEmail(email) {
		var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (filter.test(email)) {
			return true;
		}
		return false;
	}
	function resetField(field) {
		field.style.border="1px solid #CCC";
	}	
</script>
	