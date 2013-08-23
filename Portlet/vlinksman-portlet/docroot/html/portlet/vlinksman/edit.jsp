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

<%@include file="/html/portlet/vlinksman/init.jsp"%>
	
<%	
	Links link = (Links) request.getAttribute("link");
	if(link == null){
		link = new LinksImpl();
	}
	
	List listLinks = (List) request.getAttribute("listLinks");	
	
	String linkId = ((link != null && Long.toString(link.getLinkId()) != null) ? Long.toString(link.getLinkId()) : null);
	
	String redirect = ParamUtil.getString(request, "redirect");
	PortletURL formAction = renderResponse.createActionURL();
	formAction.setParameter("jspPage","/html/portlet/vlinksman/edit.jsp");
%>

<script>	
		
	function <portlet:namespace />submitForm(type) {
		var myform = document.<portlet:namespace />fm;		
		myform.action="<%= formAction.toString() %>";		
		myform.method="post";
		
		var name = myform.<portlet:namespace />name		
		var url = myform.<portlet:namespace />url;
		
		// validate URL	
		var r = new RegExp(/^(([\w]+:)?\/\/)?(([\d\w]|%[a-fA-f\d]{2,2})+(:([\d\w]|%[a-fA-f\d]{2,2})+)?@)?([\d\w][-\d\w]{0,253}[\d\w]\.)+[\w]{2,4}(:[\d]+)?(\/([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)*(\?(&?([-+_~.\d\w]|%[a-fA-f\d]{2,2})=?)*)?(#([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)?$/);
			
		if (type == 0) {
			myform.submit();
			return ;
		}
		resetField(name);
		resetField(url);
		
		if (name.value.length<1) {
			alert("<%= LanguageUtil.get(pageContext, "VLinksman.form.name") %> <%= LanguageUtil.get(pageContext, "VLinksman.form.cannotBlank") %>");
			showErrorField(name);
			name.focus();
			return false;			
		}		
		if (url.value.length<1){
			alert("<%= LanguageUtil.get(pageContext, "VLinksman.form.url") %> <%= LanguageUtil.get(pageContext, "VLinksman.form.cannotBlank") %>");
			showErrorField(url);
			url.focus();
			return false;
		}
		
		if(!r.test(url.value)){
			alert("<%= LanguageUtil.get(pageContext, "VLinksman.form.url") %> <%=LanguageUtil.get(pageContext,"VLinksman.form.invalid")%>");
			showErrorField(url);
			url.value = "";
			return false;
		}
		
		myform.submit();
	}	
</script>	
	
<form action="<portlet:actionURL><portlet:param name="struts_action" value="/vlinksman/edit" />
	</portlet:actionURL>" method="post" name="<portlet:namespace />fm">
	<input name="<portlet:namespace />linkId" type="hidden" value="<%= (linkId != null) ? linkId : "" %>">
	<input name="<portlet:namespace />cmd" type="hidden" value="<%=Validator.isNotNull(link.getLinkId()) ? "doupdate" : "doadd" %>">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= redirect %>" />
	
	
	<table class="lfr-table">
		<tr>
			<td align="left" style="font-size: small">
				<b>
				<c:if test="<%= !linkId.equalsIgnoreCase("0") %>"><%= LanguageUtil.get(pageContext, "VLinksman.form.update") %></c:if>
				<c:if test="<%= linkId.equalsIgnoreCase("0") %>"><%= LanguageUtil.get(pageContext, "VLinksman.form.add-new") %></c:if>
				</b>
			</td>
		</tr>
	</table>
		
	<br/>	
		
	<table class="lfr-table">
		<tr>
			<td ><%= LanguageUtil.get(pageContext, "VLinksman.form.name") %> :</td>
			<td><liferay-ui:input-field model="<%= Links.class %>" bean="<%= link %>" field="name" /></td>
		<tr>
		<tr>
			<td ><%= LanguageUtil.get(pageContext, "VLinksman.form.description") %> :</td>
			<td>
				<textarea name="<portlet:namespace />description" id="<portlet:namespace />description" class="lfr-textarea" ><%= (link != null) ? link.getDescription() : "" %></textarea>
			</td>
		<tr>	
		<tr>
			<td ><%= LanguageUtil.get(pageContext, "VLinksman.form.url") %> :</td>
			<td><liferay-ui:input-field model="<%= Links.class %>" bean="<%= link %>" field="url" /></td>
		</tr>
		
		<tr>
			<td colspan="2"><b>&#272;&#7883;a ch&#7881; URL c&#7911;a liên k&#7871;t ph&#7843;i nh&#7853;p theo &#273;&#7883;nh d&#7841;ng : <font color="red">http://www.</font>*</b></td>
		</tr>		
	</table>
		
	
	<br/>		
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="save" />" onclick="<portlet:namespace />submitForm(1)" />
	<input type="button" class="portlet-form-button" value="<liferay-ui:message key="cancel" />" onClick="self.location = '<%= redirect %>';" />

</form>